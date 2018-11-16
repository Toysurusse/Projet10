package action.admin;

import action.IndexAction;
import action.privacy.Connect;
import client.Authentication;
import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.library.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class User extends Connect {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    public List<com.library.User> getUserList() {
        return userList;
    }

    public void setUserList(List<com.library.User> userList) {
        this.userList = userList;
    }

    public List<com.library.User> userList;

    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.User");
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
}
