package com.library.endpoint;

import com.library.InputSOABook;
import com.library.OutputSOABook;

import com.library.SpringBootLibraryApplication;
import com.library.client.Authentication;
import com.library.client.SecurityHeader;
import com.library.client.book.BookClient;
import com.library.client.book.SoapClientBookConfig;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringBootLibraryApplication.class)
public class WebServiceEndpointBookiTest {

    @Test
    public void testRentBook() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientBookConfig.class);
        BookClient client = context.getBean(BookClient.class);

        WebServiceEndpointBook wBook= new WebServiceEndpointBook();
        InputSOABook request = new InputSOABook();
        request.setTest("Test");
    }
}
