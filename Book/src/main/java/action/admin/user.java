package action.admin;

import action.IndexAction;
import action.privacy.Connect;
import client.Authentication;
import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.library.*;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class User extends Connect {

    public List<com.library.User> getUserList() {
        return userList;
    }

    public void setUserList(List<com.library.User> userList) {
        this.userList = userList;
    }

    public int id;

    public List<com.library.User> userList;

    public com.library.User user;

    public String execute() throws Exception {

        userList=new ArrayList<>();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUser response = client.getUser(new Authentication("username","password"));
        userList=response.getResult();
        return SUCCESS;
    }

    public String createUser() throws Exception {

        this.clearActionErrors();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);

        controlMDP(user);

        if(!this.hasErrors()) {
            OutputSOAddConfirm response = client.getUserAdd(new Authentication("username", "password"), user);
            System.out.println(response.getResult());
        }

        return SUCCESS;
    }

    public String updateUInit() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserById response = client.getUserById(new Authentication("username", "password"), id);

        user=response.getResult();
        return SUCCESS;
    }

    public String userUpdate() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserById userById = client.getUserById(new Authentication("username", "password"), user.getUserid());
        user.setUserid(userById.getResult().getUserid());
        user.setPassword(userById.getResult().getPassword());
        user.setSalt(userById.getResult().getSalt());
        user.setDelete(userById.getResult().isDelete());
        controlMDP(user);

        if(!this.hasErrors()) {
            OutputSOAddConfirm response = client.getUserAdd(new Authentication("username", "password"), user);
            System.out.println(response.getResult());
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String deleteUser() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserById userById = client.getUserById(new Authentication("username", "password"), id);
        userById.getResult().setDelete(true);
        OutputSODelConfirm response = client.getUserDel(new Authentication("username", "password"), userById.getResult());
        return SUCCESS;
    }

    public String ActiveUser() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserById userById = client.getUserById(new Authentication("username", "password"), id);
        userById.getResult().setDelete(false);
        OutputSODelConfirm response = client.getUserDel(new Authentication("username", "password"), userById.getResult());
        return SUCCESS;
    }


    private void controlMDP(com.library.User user) {
        if (user.getPseudo().equals("")) {
            this.addActionError(getText("error.emptyPseudo"));
        }
        if (user.getPassword().equals("")) {
            this.addActionError(getText("error.emptyPassword"));
        }
        if (user.getGender() ==null) {
            this.addActionError(getText("error.emptyGender"));
        }
        if (user.getMail().equals("")) {
            this.addActionError(getText("error.emptyMail"));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.library.User getUser() {
        return user;
    }

    public void setUser(com.library.User user) {
        this.user = user;
    }
}
