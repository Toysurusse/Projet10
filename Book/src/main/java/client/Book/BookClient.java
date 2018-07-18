package client.Book;

import client.Authentication;
import client.SecurityHeader;
import com.javainuse.*;
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