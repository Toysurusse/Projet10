package client.rent;

import client.Authentication;
import client.SecurityHeader;
import com.javainuse.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class Rent extends WebServiceGatewaySupport {

    public OutputSOARentbook getRentbook(Authentication authentication) {
        InputSOARentbook request = new InputSOARentbook();
        request.setTest("Test");
        return (OutputSOARentbook) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOARentbookById getRentbookById(Authentication authentication, int id) {
        InputSOARentbookById request = new InputSOARentbookById();
        request.setId(id);
        return (OutputSOARentbookById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAddConfirm getRentbookAdd(Authentication authentication, Rentbook rentbook) {
        InputSOARentbookAdd request = new InputSOARentbookAdd();
        request.setRentbook(rentbook);
        return (OutputSOAddConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSODelConfirm getRentbookDel(Authentication authentication, Rentbook rentbook) {
        InputSOARentbookDel request = new InputSOARentbookDel();
        request.setRentbook(rentbook);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

}
