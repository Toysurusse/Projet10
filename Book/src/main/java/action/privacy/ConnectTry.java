package action.privacy;

import action.IndexAction;
import client.Authentication;

import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.library.OutputSOAUser;
import com.library.OutputSOAUserTest;
import com.library.OutputSOAddConfirm;
import com.library.User;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ConnectTry extends Connect {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    public String pseudo;
    public String password;

    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.ConnectTry");
        this.map.remove("user");
        return ActionSupport.SUCCESS;
    }

    public String input() throws Exception {
        LOGGER.info("input / Classe Java Action.privacy.ConnectTry");
        this.clearActionErrors();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);

        if (!pseudo.equals("") && !password.equals("")) {

            OutputSOAUserTest response = client.getUserTest(pseudo);

            if(response.getUser()==null){
                this.addActionError(getText("error.connectNotFound"));
            }
            else{
                boolean passwordMatch = Encrypt.verifyUserPassword(password, response.getUser().getPassword(), response.getUser().getSalt());


                if(passwordMatch)
            {
                LOGGER.info("Provided user password " + password + " is correct.");
            } else {
                LOGGER.info("Provided password is incorrect");
            }

            if (passwordMatch) {
                this.map.put("user", response.getUser());
                pseudo = null;
                password = null;
            } else {
                this.addActionError(getText("error.connectError"));
            }
            }
        } else {
            this.addActionError(getText("error.connectEmpty"));
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String disconnect() {
        LOGGER.info("disconnect / Classe Java Action.privacy.ConnectTry");
        this.map.remove("user");
        return ActionSupport.SUCCESS;
    }

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

    private void controlMDP(User user) {
        if (user.getPseudo().equals("")) {
            this.addActionError(getText("error.emptyPseudo"));
        }
        if (user.getPassword().equals("")) {
            this.addActionError(getText("error.emptyPassword"));
        }
        if (user.getGender() == null) {
            this.addActionError(getText("error.emptyGender"));
        }
        if (user.getMail().equals("")) {
            this.addActionError(getText("error.emptyMail"));
        }
    }
}
