package action.privacy;

import client.Authentication;

import client.User.SoapClientUserConfig;
import client.User.UserClient;
import com.javainuse.OutputSOAUserTest;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ConnectTry extends Connect {

    public String pseudo;
    public String password;

    public String execute() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUserTest response = client.getUserTest(new Authentication("username","password"), pseudo, password);

        System.out.println(response.getUser().getUserid()+" ; "+response.getUser().getGender()+" ; "+response.getUser().getPassword()+" ; "+response.getUser().getMail()+" ; "+response.getUser().getPseudo()+" ; ");

        if (response.getUser().getGender().equals("Homme")||response.getUser().getGender().equals("Femme")){
            this.map.put("user", response.getUser());
            pseudo = null;
            password = null;
        }
        else {
            this.addActionError(getText("error.connectError"));
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String input() throws Exception {
        return ActionSupport.SUCCESS;
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

}
