package action.privacy;

import client.Authentication;
import client.Book.BookClient;
import client.Book.SoapClientBookConfig;
import com.javainuse.Book;
import com.javainuse.OutputSOABook;
import com.javainuse.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Connected extends Connect {


    public User user ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBookToRent() {
        return bookToRent;
    }

    public void setBookToRent(List<Book> bookToRent) {
        this.bookToRent = bookToRent;
    }

    public List<Book> bookToRent;

    public String execute() throws Exception {

        user = (User) this.map.get("user");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));

        for (int i = 0; i <response.getResult().size() ; i++) {
            if (response.getResult().get(i).isDispo()) {
                bookToRent.add(response.getResult().get(i));
            }
        }

        return SUCCESS;
    }


}
