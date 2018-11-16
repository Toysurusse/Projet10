package action.admin;

import action.IndexAction;
import action.privacy.Connect;
import client.Authentication;
import client.book.BookClient;
import client.book.SoapClientBookConfig;
import com.library.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Book  extends Connect {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexAction.class);
    public List<com.library.Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<com.library.Book> bookList) {
        this.bookList = bookList;
    }

    public List<com.library.Book> bookList;

    public com.library.Book book;

    public com.library.Book getBook() {
        return book;
    }

    public void setBook(com.library.Book book) {
        this.book = book;
    }

    public String execute() throws Exception {
        LOGGER.info("execute / Classe Java Action.privacy.Book");
        bookList=new ArrayList<>();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));
        bookList=response.getResult();

        return SUCCESS;
    }
}
