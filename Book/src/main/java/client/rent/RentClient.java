package client.rent;

import client.Authentication;
import client.SecurityHeader;
import com.library.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class RentClient extends WebServiceGatewaySupport {

    private Authentication getauthentication(){
        return new Authentication("username","password");
    }
    
    public OutputSOARentbook getRentbook() {
        InputSOARentbook request = new InputSOARentbook();
        request.setTest("Test");
        return (OutputSOARentbook) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOARentbookById getRentbookById(int id) {
        InputSOARentbookById request = new InputSOARentbookById();
        request.setId(id);
        return (OutputSOARentbookById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOARentbookAddConfirm getRentbookAdd(Rentbook rentbook) {
        InputSOARentbookAdd request = new InputSOARentbookAdd();
        request.setRentbook(rentbook);
        return (OutputSOARentbookAddConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOARentbookByUser getRentbookByUser(int id) {
        InputSOARentbookByUser request = new InputSOARentbookByUser();
        request.setId(id);
        return (OutputSOARentbookByUser) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSODelConfirm getRentbookDel(Rentbook rentbook) {
        InputSOARentbookDel request = new InputSOARentbookDel();
        request.setRentbook(rentbook);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

}
