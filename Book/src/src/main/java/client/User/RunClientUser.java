package client.user;

import client.Authentication;
import com.javainuse.User;
import com.javainuse.OutputSOAUser;
import com.javainuse.OutputSOAUserById;
import com.javainuse.OutputSOAddConfirm;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunClientUser {

    public static void main(String[] args) {
       Authentication authentication=new Authentication("username","password");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        UserClient client = context.getBean(UserClient.class);
        OutputSOAUser response = client.getUser(authentication);

        for (int i=0;i<response.getResult().size();i++){
            System.out.println(response.getResult().get(i).getUserid()+" ; "+response.getResult().get(i).getPseudo()+" ; "+response.getResult().get(i).getPassword()+" ; "+response.getResult().get(i).getMail()+" ; "+response.getResult().get(i).getGender());
        }

        OutputSOAUserById outputSOAUserById = client.getUserById(authentication,0);
        System.out.println(outputSOAUserById.getResult().getUserid()+" ; "+outputSOAUserById.getResult().getPseudo()+" ; "+outputSOAUserById.getResult().getPassword()+" ; "+outputSOAUserById.getResult().getGender()+" ; "+outputSOAUserById.getResult().getMail());

        User user = new User();
        user.setUserid(12);
        user.setPseudo("Admin2");
        user.setPassword("ToysRusse");
        user.setGender("Homme");
        user.setMail("max.lb@gmx.com");


        OutputSOAddConfirm outputSOAddConfirm = client.getUserAdd(authentication,user);
        System.out.println(outputSOAddConfirm.getResult());
    }
}
