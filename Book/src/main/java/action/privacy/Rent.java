package action.privacy;


import client.Authentication;
import client.rent.SoapClientRentConfig;
import com.javainuse.Book;
import com.javainuse.OutputSOAddConfirm;
import com.javainuse.Rentbook;
import com.javainuse.User;
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
    public String threeWeeks;
    public List<Rentbook> rentbook;
    public HashMap<String, Book> rentResult=new HashMap<>();


    public String execute() throws Exception {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        today = formater.format(java.util.Calendar.getInstance().getTime());
        shoppingList = (List<Book>) this.map.get("shop");
        return SUCCESS;
    }

    public String rentbook() throws Exception {

        List<Rentbook> rents = new ArrayList<>();
        System.out.println(end_at + " :b " + create_at);
        User user = (User) this.map.get("user");

        shoppingList = (List<Book>) this.map.get("shop");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientRentConfig.class);
        client.rent.Rent client = context.getBean(client.rent.Rent.class);

        if (end_at != null && create_at != null) {
            for (Book aShoppingList : shoppingList) {
                Rentbook rent = new Rentbook();
                rent.setBookId(aShoppingList.getId());
                rent.setUserId(user.getUserid());
                rent.setCreateat(translate(create_at));
                rent.setEndat(translate(end_at));
                rent.setReload(false);
                rent.setReturnbook(false);
                System.out.println(rent.getUserId()+" ; "+rent.getBookId()+" ; "+rent.getRentid()+" ; "+rent.getCreateat()+" ; "+rent.getEndat()+" ; "+rent.isReload()+" ; "+rent.isReturnbook());
                //rents.add(rent);
                OutputSOAddConfirm outputSOAddConfirm = client.getRentbookAdd(new Authentication("username","password"),rent);
                rentResult.put(outputSOAddConfirm.getResult(),aShoppingList);
            }
        }

        String key;
        String value;

        for(Map.Entry<String, Book> e : rentResult.entrySet()){
            if (e.getKey() == "Ok") {
                shoppingList.remove(e.getValue());
                rentResult.remove(e.getKey(),e.getValue());
            }
        }

        this.map.remove("shop");
        this.map.put("shop",shoppingList);

        return SUCCESS;
    }

    public String rented() throws Exception {


        System.out.println(end_at + " :c " + create_at);

        return SUCCESS;
    }

    public String input() throws Exception {

        shoppingList = (List<Book>) this.map.get("shop");
        System.out.println(end_at + " :c " + create_at);
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


    public HashMap<String, Book> getRentResult() {
        return rentResult;
    }

    public void setRentResult(HashMap<String, Book> rentResult) {
        this.rentResult = rentResult;
    }
}
