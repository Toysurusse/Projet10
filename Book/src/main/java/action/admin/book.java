package action.admin;

import action.privacy.Connect;
import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import com.library.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Book extends Connect {

    public List<com.library.Book> bookList;

    public int idBook;

    public com.library.Book book;

    public String execute() throws Exception {

        bookList=new ArrayList<>();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));
        bookList=response.getResult();

        return SUCCESS;
    }

    public String createBook() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOAddConfirm response = client.getBookAdd(new Authentication("username","password"),book);

        return SUCCESS;
    }

    public String deleteBook() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABookById response = client.getBookById(new Authentication("username","password"),idBook);
        response.getResult().setDispo(0);
        OutputSOAddConfirm update = client.getBookAdd(new Authentication("username","password"),response.getResult());

        return SUCCESS;
    }

    public String updateBookInit() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABookById response = client.getBookById(new Authentication("username","password"),idBook);
        book=response.getResult();

        return SUCCESS;
    }

    public String updateBook() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOAddConfirm response = client.getBookAdd(new Authentication("username","password"),book);

        return SUCCESS;
    }



    @Override
    public int getIdBook() {
        return idBook;
    }

    @Override
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public com.library.Book getBook() {
        return book;
    }

    public void setBook(com.library.Book book) {
        this.book = book;
    }

    public List<com.library.Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<com.library.Book> bookList) {
        this.bookList = bookList;
    }
}
