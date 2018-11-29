package action.privacy;


import action.IndexAction;
import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import client.rent.RentClient;
import client.rent.SoapClientRentConfig;
import com.library.*;
import com.opensymphony.xwork2.ActionSupport;
import entity.BookAndRent;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reload extends Connect {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    public Date create_at;
    public Date end_at;
    public String today;
    public String today4W;
    public String threeWeeks;
    public Rentbook rentbook;
    public List<Book> bookList;
    BookAndRent listrented;
    public HashMap<String, Book> rentResult=new HashMap<>();


    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.Reload");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        RentClient client = context.getBean(RentClient.class);
        System.out.println(idBook);
        OutputSOARentbookById outputSOARentbookById = client.getRentbookById(idBook);
        rentbook = outputSOARentbookById.getResult();
        AnnotationConfigApplicationContext contextbook = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        client.book.BookClient clientbook = contextbook.getBean(BookClient.class);
        OutputSOABookById response = clientbook.getBookById(new Authentication("username","password"), rentbook.getBookId());

        listrented=new BookAndRent(response.getResult(),rentbook);

        //utiliser le calendrier par défaut
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rentbook.getEndat().toGregorianCalendar().getTime());

        //définir le format de la date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        calendar.add(calendar.MONTH,1);
        today4W =formater.format(calendar.getTime());
        calendar.setTime(rentbook.getEndat().toGregorianCalendar().getTime());
        today = formater.format(calendar.getTime());

        return SUCCESS;
    }

    public String reloadrentbook() throws Exception {
        LOGGER.info("reloadrentbook / Classe Java Action.privacy.Reload");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        RentClient client = context.getBean(RentClient.class);
        OutputSOARentbookById outputSOARentbookById = client.getRentbookById(idBook);

        System.out.println(idBook);

        rentbook = outputSOARentbookById.getResult();

        System.out.println(rentbook.getCreateat());

        rentbook.setEndat(translate(end_at));
        rentbook.setReload(true);

        OutputSOARentbookAddConfirm outputSOAddConfirm = client.getRentbookAdd(rentbook);

        return ActionSupport.SUCCESS;
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

    public XMLGregorianCalendar translateGtoD(GregorianCalendar cal) {
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
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

    public HashMap<String, Book> getRentResult() {
        return rentResult;
    }

    public void setRentResult(HashMap<String, Book> rentResult) {
        this.rentResult = rentResult;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public BookAndRent getListrented() {
        return listrented;
    }

    public void setListrented(BookAndRent listrented) {
        this.listrented = listrented;
    }


    public Rentbook getRentbook() {
        return rentbook;
    }

    public void setRentbook(Rentbook rentbook) {
        this.rentbook = rentbook;
    }

}
