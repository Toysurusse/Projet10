package action.privacy;

import com.javainuse.Book;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Connect extends ActionSupport implements SessionAware {

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

        return SUCCESS;
    }

    public String input() throws Exception {

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
