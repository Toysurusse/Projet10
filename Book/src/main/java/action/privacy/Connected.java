package action.privacy;

import action.IndexAction;
import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import com.library.Book;
import com.library.OutputSOABook;
import com.library.User;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Connected extends Connect {


    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);

    public List<Book> getBookToRent() {
        return bookToRent;
    }

    public void setBookToRent(List<Book> bookToRent) {
        this.bookToRent = bookToRent;
    }

    public List<Book> bookToRent=new ArrayList<>();

    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.Connected");
        user = (User) this.map.get("user");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));

        for (int i = 0; i <response.getResult().size() ; i++) {
            if (response.getResult().get(i).getDispo()>0) {
                bookToRent.add(response.getResult().get(i));
            }
        }
        this.map.put("books",bookToRent);
        this.map.put("shop",shoppingList);
        return SUCCESS;
    }

    public String addToShop() throws Exception {
        LOGGER.info("addToShop / Classe Java Action.privacy.Connected");
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
        LOGGER.info("deleteToShop / Classe Java Action.privacy.Connected");
        bookToRent=new ArrayList<>();
        bookToRent= (List<Book>) this.map.get("books");
        shoppingList=(List<Book>) this.map.get("shop");
        for (int i = 0; i <shoppingList.size() ; i++) {
            if (shoppingList.get(i).getId()==idBook) {
                bookToRent.add(shoppingList.get(i));
                shoppingList.remove(i);
            }
        }
        this.map.remove("books");
        this.map.put("books", bookToRent);
        this.map.remove("shop");
        this.map.put("shop",shoppingList);
        return SUCCESS;
    }
}
