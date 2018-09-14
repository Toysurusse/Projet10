package action.privacy;

import client.Authentication;

import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.javainuse.OutputSOAUser;
import com.javainuse.OutputSOAUserTest;
import com.javainuse.OutputSOAddConfirm;
import com.javainuse.User;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ConnectTry extends Connect {

    public String pseudo;
    public String password;

    public String execute() throws Exception {
        this.map.remove("user");
        return ActionSupport.SUCCESS;
    }

    public String input() throws Exception {
        this.clearActionErrors();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);

        if (!pseudo.equals("") && !password.equals("")) {

            OutputSOAUserTest response = client.getUserTest(new Authentication("username", "password"), pseudo);

            boolean passwordMatch = Encrypt.verifyUserPassword(password, response.getUser().getPassword(), response.getUser().getSalt());

            if(passwordMatch)
            {
                System.out.println("Provided user password " + password + " is correct.");
            } else {
                System.out.println("Provided password is incorrect");
            }

            if (passwordMatch) {
                this.map.put("user", response.getUser());
                pseudo = null;
                password = null;
            } else {
                this.addActionError(getText("error.connectError"));
            }
        } else {
            this.addActionError(getText("error.connectEmpty"));
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String disconnect() {
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
