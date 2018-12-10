package action;

import action.privacy.Connect;
import com.library.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

public class CreateAccountTest extends CreateAccount {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexActionTest.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAccount() throws Exception {
        execute();

        user= new User();
        User usertest = new User();

        user.setPseudo("Test");
        user.setDelete(true);
        user.setRole(1);
        user.setSalt("test");
        user.setPassword("test");
        user.setGender("Homme");
        user.setMail("test@gmail.com");
        user.setUserid(900);

        usertest=user;
        user.setPseudo("test");
        this.map.put("user",user);

        /*
        OutputSOAUser outputSOAUser=new OutputSOAUser();
        outputSOAUser.getResult().add(usertest);
        when(client.getUser()).thenReturn(outputSOAUser);
        when(client.getUser()).thenReturn(outputSOAUser);
        */

        updateInit();
        updateAccount();

    }


}
