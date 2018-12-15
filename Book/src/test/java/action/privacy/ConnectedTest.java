package action.privacy;

import action.IndexActionTest;
import client.Authentication;
import com.library.OutputSOABookById;
import com.library.OutputSOAddConfirm;
import com.library.User;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectedTest extends Connected {


    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexActionTest.class);

    private ConnectTry connectTry;

    @Test
    public void testConnected() throws Exception {

        user= new User();

        user.setPseudo("Protected");
        user.setRole(3);
        user.setMail("maxlbdu75@gmail.com");
        user.setUserid(108);

        this.map.put("user",user);

        execute();
        setIdBook(1);
        addToShop();
        OutputSOABookById bookToShop = createInstanceBDDBook().getBookById(new Authentication("username", "password"), idBook);
        bookToShop.getResult().setDispo(bookToShop.getResult().getDispo() + 1);
        OutputSOAddConfirm bookUpdate = createInstanceBDDBook().getBookAdd(new Authentication("username", "password"), bookToShop.getResult());
    }
}
