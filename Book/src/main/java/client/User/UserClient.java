package client.User;

import client.Authentication;
import client.SecurityHeader;
import com.javainuse.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UserClient extends WebServiceGatewaySupport {

    public OutputSOAUser getUser(Authentication authentication) {
        InputSOAUser request = new InputSOAUser();
        request.setTest("Test");
        return (OutputSOAUser) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAUserTest getUserTest(Authentication authentication, String pseudo, String password) {
        InputSOAUserTest request = new InputSOAUserTest();
        request.setPassword(password);
        request.setPseudo(pseudo);
        return (OutputSOAUserTest) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAUserById getUserById(Authentication authentication, int id) {
        InputSOAUserById request = new InputSOAUserById();
        request.setId(id);
        return (OutputSOAUserById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSOAddConfirm getUserAdd(Authentication authentication, User user) {
        InputSOAUserAdd request = new InputSOAUserAdd();
        request.setUser(user);
        return (OutputSOAddConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

    public OutputSODelConfirm getUserDel(Authentication authentication, User user) {
        InputSOAUserDel request = new InputSOAUserDel();
        request.setUser(user);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                authentication));
    }

}
