package action.privacy;

import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import client.shop.ShopClient;
import client.shop.SoapClientShopConfig;
import com.library.*;
import com.opensymphony.xwork2.ActionSupport;
import entity.Shopping;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Connect extends ActionSupport implements SessionAware {

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

    public List<Shopping> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Shopping> shoppingList=new ArrayList<>();

    public int idShop;

    public String execute() throws Exception {

        return SUCCESS;
    }

    public String input() throws Exception {

        return SUCCESS;
    }

    /**
     * MapString to import session
     */
    protected Map<String, Object> map = new HashMap<>();

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getSession() {
        return map;
    }


    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public List<Shopping> initShop(){
        User user = (User) this.map.get("user");
        OutputSOAShopSearch shoppingListUser = createInstanceBDDShop().getSearch(new Authentication("username", "password"), user.getUserid());
        List<Shopping> shopList=new ArrayList<>();
        for (int i = 0; i < shoppingListUser.getResult().size(); i++) {
            Book book = createInstanceBDDBook().getBookById(new Authentication("username", "password"), shoppingListUser.getResult().get(i).getIdbookshop()).getResult();
            shopList.add(new Shopping(book, shoppingListUser.getResult().get(i).getId()));
        }
        return shopList;
    }

    protected void deleteShop (){
        //Get Shop Line From BDD and set false / after set Book dispo +1
        OutputSOAShopById shopList = createInstanceBDDShop().getShopById(new Authentication("username", "password"), idShop);
        shopList.getResult().setDispo(false);
        OutputSOABookById bookToShop = createInstanceBDDBook().getBookById(new Authentication("username", "password"), shopList.getResult().getIdbookshop());
        bookToShop.getResult().setDispo(bookToShop.getResult().getDispo() + 1);

        //Update BDD
        OutputSOAddConfirm bookUpdate = createInstanceBDDBook().getBookAdd(new Authentication("username", "password"), bookToShop.getResult());
        OutputSOAddConfirm shopUpdate = createInstanceBDDShop().getShopAdd(new Authentication("username", "password"), shopList.getResult());
    }

    protected ShopClient createInstanceBDDShop() {
        AnnotationConfigApplicationContext contextS = new AnnotationConfigApplicationContext(SoapClientShopConfig.class);
        ShopClient clientS = contextS.getBean(ShopClient.class);
        return clientS;
    }

    protected BookClient createInstanceBDDBook() {
        AnnotationConfigApplicationContext contextB = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient clientB = contextB.getBean(BookClient.class);
        return clientB;
    }
}
