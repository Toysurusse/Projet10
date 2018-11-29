package action;

import client.book.BookClient;
import client.book.SoapClientBookConfig;
import client.rent.RentClient;
import client.rent.SoapClientRentConfig;
import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ListClientSoap extends ActionSupport {
    protected BookClient clientB() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        return context.getBean(BookClient.class);
    }

    protected RentClient clientR() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        return context.getBean(RentClient.class);
    }

    protected UserClient clientU() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientUserConfig.class);
        return context.getBean(UserClient.class);
    }
}
