package action.mock;

import client.Authentication;
import client.SecurityHeader;
import com.library.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class UserClientMock extends WebServiceGatewaySupport {

    private Authentication getauthentication(){
        return new Authentication("username","password");
    }
    
    public OutputSOAUser getUser() {
        InputSOAUser request = new InputSOAUser();
        request.setTest("Test");
        return (OutputSOAUser) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOAUserTest getUserTest(String pseudo) {
        InputSOAUserTest request = new InputSOAUserTest();
        request.setPseudo(pseudo);
        return (OutputSOAUserTest) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOAUserById getUserById( int id) {
        InputSOAUserById request = new InputSOAUserById();
        request.setId(id);
        return (OutputSOAUserById) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

    public OutputSOAddConfirm getUserAdd(Authentication authentication, User user) {
        InputSOAUserAdd request = new InputSOAUserAdd();
        request.setUser(user);
        OutputSOAddConfirm outputSOAddConfirm=new OutputSOAddConfirm();
        outputSOAddConfirm.setResult("Ok");
        return outputSOAddConfirm;
    }

    public OutputSODelConfirm getUserDel( User user) {
        InputSOAUserDel request = new InputSOAUserDel();
        request.setUser(user);
        return (OutputSODelConfirm) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SecurityHeader(
                                getauthentication()));
    }

}
