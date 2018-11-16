package client.book;

import client.Authentication;
import client.SecurityHeader;
import com.library.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BookClient extends WebServiceGatewaySupport {

    private Authentication getauthentication(){
        return new Authentication("username","password");
    }
    
    public OutputSOABook getBook() {
        InputSOABook request = new InputSOABook();
        request.setTest("Test");
        return (OutputSOABook) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOABookSearch getSearch( String search) {
        InputSOABookSearch request = new InputSOABookSearch();
        request.setTest(search);
        return (OutputSOABookSearch) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOABookById getBookById( int id) {
        InputSOABookById request = new InputSOABookById();
        request.setId(id);
        return (OutputSOABookById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOAddConfirm getBookAdd( Book book) {
        InputSOABookAdd request = new InputSOABookAdd();
        request.setBook(book);
        return (OutputSOAddConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSODelConfirm getBookDel( Book book) {
        InputSOABookDel request = new InputSOABookDel();
        request.setBook(book);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

}