package action.privacy;

import action.IndexAction;
import com.library.Book;
import com.library.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Connect extends ActionSupport implements SessionAware {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    public User user ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int idBook;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public List<Book> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Book> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Book> shoppingList= new ArrayList<>();

    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.Connect");
        return SUCCESS;
    }

    public String input() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.Input");
        return SUCCESS;
    }

    /**
     * MapString to import session
     */
    protected Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getSession() {
        return map;
    }
}
