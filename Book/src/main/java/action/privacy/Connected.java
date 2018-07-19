package action.privacy;

import client.Authentication;
import client.Book.BookClient;
import client.Book.SoapClientBookConfig;
import com.javainuse.Book;
import com.javainuse.OutputSOABook;
import com.javainuse.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Book> bookToRent=new ArrayList<>();

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
        this.map.put("books",bookToRent);
        this.map.put("shop",shoppingList);
        return SUCCESS;
    }

    public String addToShop() throws Exception {
        bookToRent=new ArrayList<>();
        bookToRent= (List<Book>) this.map.get("books");

        shoppingList=(List<Book>) this.map.get("shop");

        for (int i = 0; i <bookToRent.size() ; i++) {
            if (bookToRent.get(i).getId()==idBook) {
                shoppingList.add(bookToRent.get(i));
                bookToRent.remove(i);
            }
        }
        this.map.remove("shop");
        this.map.put("shop",shoppingList);


        return SUCCESS;
    }

    public String deleteToShop() throws Exception {
        bookToRent=new ArrayList<>();
        bookToRent= (List<Book>) this.map.get("books");
        shoppingList=(List<Book>) this.map.get("shop");
        System.out.println(bookToRent.size());
        System.out.println(shoppingList.size());
        for (int i = 0; i <shoppingList.size() ; i++) {
            if (shoppingList.get(i).getId()==idBook) {
                bookToRent.add(shoppingList.get(i));
                shoppingList.remove(i);
            }
        }
        System.out.println(bookToRent.size());
        System.out.println(shoppingList.size());
        this.map.remove("books");
        this.map.put("books", bookToRent);
        this.map.remove("shop");
        this.map.put("shop",shoppingList);
        return SUCCESS;
    }
}
