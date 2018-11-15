package action.admin;

import action.privacy.Connect;
import client.Authentication;
import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.library.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class user extends Connect {

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> userList;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public User user;

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

    public String updateUser() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserById response = client.getUserById(new Authentication("username", "password"), idBook);

        user=response.getResult();

        return SUCCESS;
    }

    public String deleteUser() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserById userById = client.getUserById(new Authentication("username", "password"), idBook);
        OutputSOAUserDelConfirm response = client.getUserDel(new Authentication("username", "password"), userById.getResult());

        System.out.println(response.getResult());

        return SUCCESS;
    }

    private void controlMDP(User user) {
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
}
