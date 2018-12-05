package com.library.endpoint;

import com.library.OutputSOABook;

import com.library.client.Authentication;
import com.library.client.book.BookClient;
import com.library.client.book.SoapClientBookConfig;
import com.library.entity.Rent;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

import static org.junit.Assert.assertTrue;

public class WebServiceEndopintBookTest {


    @Test
    public void testRentBook() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);
        OutputSOABook response = client.getBook(new Authentication("username","password"));

    }


}
