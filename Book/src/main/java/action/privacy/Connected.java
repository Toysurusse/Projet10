package action.privacy;

import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import client.shop.ShopClient;
import client.shop.SoapClientShopConfig;
import client.user.SoapClientUserConfig;
import client.user.UserClient;
import com.library.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Connected extends Connect {

    public List<Book> getBookToRent() {
        return bookToRent;
    }

    public void setBookToRent(List<Book> bookToRent) {
        this.bookToRent = bookToRent;
    }

    public String idPannier;

    public List<Book> bookToRent = new ArrayList<>();

    public Shop shop = new Shop();

    public String execute() throws Exception {
        User user = (User) this.map.get("user");

        OutputSOABook response = createInstanceBDDBook().getBook(new Authentication("username", "password"));
        setBookToRent(response.getResult());

        setShoppingList(initShop());

        return SUCCESS;
    }

    public String addToShop() throws Exception {
        User user = (User) this.map.get("user");

        //Create ShopLine
        shop.setDispo(true);
        shop.setIdbookshop(idBook);
        shop.setIdpannier(panierGen());
        shop.setIdusershop(user.getUserid());
        shop.setCreateat(translate(System.currentTimeMillis()));
        shop.setEndat(translate(new Long(System.currentTimeMillis() + 172800000)));

        //Update book dispo and create ShopLine
        OutputSOABookById bookToShop = createInstanceBDDBook().getBookById(new Authentication("username", "password"), idBook);
        bookToShop.getResult().setDispo(bookToShop.getResult().getDispo() - 1);
        OutputSOAddConfirm bookUpdate = createInstanceBDDBook().getBookAdd(new Authentication("username", "password"), bookToShop.getResult());

        System.out.println("Shopping List : "+shop.getId()+" ; "+shop.isDispo()+" ; "+shop.getIdbookshop()+" ; "+shop.getIdusershop()+" ; "+shop.getIdpannier()+" ; "+shop.getCreateat()+" ; ");

        OutputSOAddConfirm ShopList = createInstanceBDDShop().getShopAdd(new Authentication("username", "password"), shop);

        return SUCCESS;
    }

    public String deleteToShop() throws Exception {

        deleteShop ();

        return SUCCESS;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public XMLGregorianCalendar translate(Long time) {
        Timestamp timestamp = new Timestamp(time);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(java.sql.Timestamp.valueOf(timestamp.toString()).getTime());
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return xmlDate;
    }

    public String panierGen() {
        User user = (User) this.map.get("user");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        idPannier = String.format("%010d", user.getUserid()) + "/" + date + "/" + LocalDateTime.now().getHour();
        return idPannier;
    }

}
