package action;

import action.privacy.Connect;
import action.privacy.Encrypt;
import client.Authentication;
import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.library.*;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CreateAccount  extends Connect {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User user2;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User user;

    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.CreateAccount");
        return ActionSupport.SUCCESS;
    }




    public String createAccount() throws Exception {
        LOGGER.info("createAccount / Classe Java Action.privacy.Rent");
        this.clearActionErrors();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        controlMDP(user);
        OutputSOAUser list = client.getUser();

        for (User u : list.getResult()) {
            if (u.getPseudo().equals(user.getPseudo())){
                this.addActionError(getText("error.PseudoExist"));
            }
        }
        user.setRole(1);

        // Generate Salt. The generated value can be stored in DB.
        String salt = Encrypt.getSalt(30);

        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = Encrypt.generateSecurePassword(user.getPassword(), salt);

        user.setPassword(mySecurePassword);
        user.setSalt(salt);

        // Print out protected password
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);

        if (!this.hasErrors()) {
            OutputSOAddConfirm outputSOAddConfirm = client.getUserAdd(new Authentication("username", "password"),user);
            list = client.getUser();
            for (User u : list.getResult()) {
                if (u.getPseudo().equals(user.getPseudo())){
                    user.setUserid(u.getUserid());
                }
            }
            this.map.put("user", user);
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String updateInit() {
        LOGGER.info("UpdateInit / Classe Java Action.privacy.Rent");
        user = (User) this.map.get("user");
        pseudo = user.getPseudo();
        return ActionSupport.SUCCESS;
    }


    public String updateAccount() {
        LOGGER.info("updateAccount / Classe Java Action.privacy.Rent");
        this.clearActionErrors();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);

        controlMDP(user);
        OutputSOAUser list = client.getUser();

        user2 = (User) this.map.get("user");

        user.setRole(user2.getRole());
        user.setUserid(user2.getUserid());

        System.out.println(user.getUserid());

        System.out.println(user.getPseudo()+user.getMail());

        // Generate Salt. The generated value can be stored in DB.
        String salt = Encrypt.getSalt(30);

        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = Encrypt.generateSecurePassword(user.getPassword(), salt);

        user.setPassword(mySecurePassword);
        user.setSalt(salt);

        // Print out protected password
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);

        if (!this.hasErrors()) {
            OutputSOAddConfirm outputSOAddConfirm = client.getUserAdd(new Authentication("username", "password"),user);
            this.map.remove("user");
            this.map.put("user", user);
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
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


    public String pseudo;
    public String password;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
