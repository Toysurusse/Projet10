package com.library.client.book;

import com.library.*;
import com.library.client.Authentication;
import com.library.client.SecurityHeader;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BookClient extends WebServiceGatewaySupport {

    public OutputSOABook getBook(Authentication authentication) {
        InputSOABook request = new InputSOABook();
        request.setTest("Test");
        return (OutputSOABook) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOABookSearch getSearch(Authentication authentication, String search) {
        InputSOABookSearch request = new InputSOABookSearch();
        request.setTest(search);
        return (OutputSOABookSearch) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOABookById getBookById(Authentication authentication, int id) {
        InputSOABookById request = new InputSOABookById();
        request.setId(id);
        return (OutputSOABookById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAddConfirm getBookAdd(Authentication authentication, Book book) {
        InputSOABookAdd request = new InputSOABookAdd();
        request.setBook(book);
        return (OutputSOAddConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSODelConfirm getBookDel(Authentication authentication, Book book) {
        InputSOABookDel request = new InputSOABookDel();
        request.setBook(book);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

}