package action.privacy;


import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import client.rent.SoapClientRentConfig;
import client.shop.ShopClient;
import client.shop.SoapClientShopConfig;
import com.library.*;
import com.opensymphony.xwork2.ActionSupport;
import entity.BookAndRent;
import entity.Shopping;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class Rent extends Connect {

    public Date create_at;
    public Date end_at;
    public String today;
    public String today4W;
    public String threeWeeks;
    public List<Rentbook> rentbook;
    public List<Book> bookList;
    public List<BookAndRent> listrented = new ArrayList<>();
    public HashMap<String, Shopping> rentResult = new HashMap<>();

    public String execute() throws Exception {
        User user = (User) this.map.get("user");
        //utiliser le calendrier par défaut
        Calendar calendar = Calendar.getInstance();

        //définir le format de la date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        today = formater.format(java.util.Calendar.getInstance().getTime());
        calendar.add(calendar.MONTH, 1);
        today4W = formater.format(calendar.getTime());

        setShoppingList(initShop());

        return SUCCESS;
    }

    public String rentbook() throws Exception {

        List<Rentbook> rents = new ArrayList<>();
        User user = (User) this.map.get("user");

        List<Rentbook> rentList=new ArrayList<>();
        setShoppingList(initShop());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        client.rent.RentClient client = context.getBean(client.rent.RentClient.class);

        if (end_at != null && create_at != null) {
            if (end_at.before(create_at)) {
                this.addActionError("error.DatePost");
            } else {
                for (Shopping aShoppingList : shoppingList) {
                    Rentbook rent = new Rentbook();
                    rent.setBookId(aShoppingList.getIdBook());
                    rent.setUserId(user.getUserid());
                    rent.setCreateat(translate(create_at));
                    rent.setEndat(translate(end_at));
                    rent.setReload(false);
                    rent.setReturnbook(false);
                    System.out.println(rent.getUserId() + " ; " + rent.getBookId() + " ; " + rent.getRentid() + " ; " + rent.getCreateat() + " ; " + rent.getEndat() + " ; " + rent.isReload() + " ; " + rent.isReturnbook());

                    rentList.add(rent);

                    //rentResult.put(outputSOAddConfirm.getResult(), aShoppingList);

                    //Get Shop Line From BDD and set false
                    OutputSOAShopById shopList = createInstanceBDDShop().getShopById(new Authentication("username", "password"), aShoppingList.getIdPannier());
                    shopList.getResult().setDispo(false);
                    System.out.println("test BDD : "+shopList.getResult().isDispo());
                    OutputSOAddConfirm shopUpdate = createInstanceBDDShop().getShopAdd(new Authentication("username", "password"), shopList.getResult());
                }
                OutputSOARentbookAddConfirm outputSOAddConfirm = client.getRentbookAdd(rentList);
            }
        } else {
            this.addActionError("error.DateEmpty");
        }



        for (Map.Entry<String, Shopping> e : rentResult.entrySet()) {
            if (e.getKey().equals("Ok")) {
                rentResult.remove(e.getKey(), e.getValue());
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }


    public String rented() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        today = formater.format(java.util.Calendar.getInstance().getTime());
        User user = (User) this.map.get("user");
        int id = user.getUserid();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        client.rent.RentClient client = context.getBean(client.rent.RentClient.class);

        OutputSOARentbookByUser outputSOARentbookByUser = null;
        outputSOARentbookByUser = client.getRentbookByUser(id);

        rentbook = new ArrayList<>();

        AnnotationConfigApplicationContext contextbook = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        client.book.BookClient clientbook = contextbook.getBean(BookClient.class);
        OutputSOABook response = clientbook.getBook(new Authentication("username", "password"));

        rentbook = outputSOARentbookByUser.getResult();
        bookList = response.getResult();
        for (Rentbook r : rentbook) {
            for (Book b : bookList) {
                if (r.getBookId() == b.getId()) {
                    BookAndRent bookAndRent = new BookAndRent(b, r);
                    listrented.add(bookAndRent);
                }
            }
        }
        return SUCCESS;
    }

    public String returnBook() throws Exception {

        User user = (User) this.map.get("user");
        List<Rentbook> rentbookList = new ArrayList<>();


        //Update returnBook
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        client.rent.RentClient client = context.getBean(client.rent.RentClient.class);
        OutputSOARentbookById outputSOARentbookById = client.getRentbookById(idBook);
        outputSOARentbookById.getResult().setReturnbook(true);

        rentbookList.add(outputSOARentbookById.getResult());

        OutputSOARentbookAddConfirm outputSOARentbookAddConfirm = client.getRentbookAdd(rentbookList);

        //Update dispo Book count
        OutputSOABookById outputSOABookById = createInstanceBDDBook().getBookById(new Authentication("username", "password"), outputSOARentbookById.getResult().getBookId());
        outputSOABookById.getResult().setDispo(outputSOABookById.getResult().getDispo()+1);
        OutputSOAddConfirm outputSOAddConfirm = createInstanceBDDBook().getBookAdd(new Authentication("username", "password"), outputSOABookById.getResult());

        return SUCCESS;
    }

    public String input() throws Exception {
        User user = (User) this.map.get("user");
        setShoppingList(initShop());

        return SUCCESS;
    }

    public String deleteToRent() throws Exception {

        deleteShop ();

        return SUCCESS;
    }

    public XMLGregorianCalendar translate(Date date) {
        GregorianCalendar Gdate = new GregorianCalendar();
        Gdate.setTime(date);
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(Gdate);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return xmlDate;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }


    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Date end_at) {
        this.end_at = end_at;
    }

    public String getThreeWeeks() {
        return threeWeeks;
    }

    public void setThreeWeeks(String threeWeeks) {
        this.threeWeeks = threeWeeks;
    }

    public List<Rentbook> getRentbook() {
        return rentbook;
    }

    public void setRentbook(List<Rentbook> rentbook) {
        this.rentbook = rentbook;
    }

    public HashMap<String, Shopping> getRentResult() {
        return rentResult;
    }

    public void setRentResult(HashMap<String, Shopping> rentResult) {
        this.rentResult = rentResult;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public List<BookAndRent> getListrented() {
        return listrented;
    }

    public void setListrented(List<BookAndRent> listrented) {
        this.listrented = listrented;
    }

}
