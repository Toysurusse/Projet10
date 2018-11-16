package com.library.endpoint;

import com.library.*;
import com.library.config.Authentication;
import com.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.List;

@Endpoint
public class WebServiceEndpointBook {




    private static final String NAMESPACE_URI = "http://library.com";

    @Autowired
    BookService bookService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOABook")
    @ResponsePayload
    public OutputSOABook getBeer(@RequestPayload InputSOABook request,
                                 @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {
        OutputSOABook response = null;
        List<Book> output = bookService.findAll();
        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOABook();
        response.getResult().addAll(output);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOABookSearch")
    @ResponsePayload
    public OutputSOABookSearch getSearch(@RequestPayload InputSOABookSearch request,
                                         @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {


        OutputSOABookSearch response = null;

        List<Book> output = bookService.findBySearch(request.getTest());

        ObjectFactory factory = new ObjectFactory();
        response = factory.createOutputSOABookSearch();
        response.getResult().addAll(output);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOABookById")
    @ResponsePayload
    public OutputSOABookById hello(@RequestPayload InputSOABookById request,
                                   @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {


        Book output = bookService.findById(request.getId());

        ObjectFactory factory = new ObjectFactory();
        OutputSOABookById response = factory.createOutputSOABookById();
        response.setResult(output);

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOABookAdd")
    @ResponsePayload
    public OutputSOAddConfirm Add(@RequestPayload InputSOABookAdd request,
                                  @SoapHeader("{" + Authentication.AUTH_NS + "}authentication") SoapHeaderElement auth) {


        ObjectFactory factory = new ObjectFactory();
        OutputSOAddConfirm response = factory.createOutputSOAddConfirm();
        String result;

        bookService.add(request.getBook());

        response.setResult("Ok");
        return response;
    }
}
