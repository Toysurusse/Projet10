package action.privacy;

import action.IndexActionTest;
import org.junit.Test;
import org.slf4j.LoggerFactory;


public class ConnectTryTest extends ConnectTry {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexActionTest.class);

    @Test
    public void testConnectTry() throws Exception {


        setPseudo("Protected");
        setPassword("Protectec");

        execute();
        input();





        disconnect();
    }
}
