package action.admin;

import action.privacy.Connect;
import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import com.javainuse.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class book  extends Connect {

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> bookList;

    public Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String execute() throws Exception {

        bookList=new ArrayList<>();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));
        bookList=response.getResult();

        return SUCCESS;
    }

    public String createBook() throws Exception {

        this.clearActionErrors();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);

        if (book.getId()==0) {
            book.setDispo(true);
        }
        controlBook(book);

        if(!this.hasErrors()) {
            OutputSOAddConfirm response = client.getBookAdd(new Authentication("username", "password"), book);
            System.out.println(response.getResult());
        }

        return SUCCESS;
    }

    public String updateBook() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABookById response = client.getBookById(new Authentication("username", "password"), idBook);

        book=response.getResult();

        return SUCCESS;
    }

    public String deleteBook() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABookById bookById = client.getBookById(new Authentication("username", "password"), idBook);
        OutputSODelConfirm response = client.getBookDel(new Authentication("username", "password"), bookById.getResult());

        System.out.println(response.getResult());

        return SUCCESS;
    }

    private void controlBook(Book book) {
        if (book.getBookName().equals("")) {
            this.addActionError(getText("error.NameEmpty"));
        }
        if (book.getAuthor().equals("")) {
            this.addActionError(getText("error.EditorsEmpty"));
        }
        if (book.getEditeurs().equals("")) {
            this.addActionError(getText("error.AuthorsEmpty"));
        }
        if (book.getNbPage()==0) {
            this.addActionError(getText("error.NbPageEmpty"));
        }
    }
}
