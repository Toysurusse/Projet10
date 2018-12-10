package action;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ListClientSoapTest extends ListClientSoap {



    @Test
    public void intégrationBDDClient() throws Exception {
        assertNotNull(clientB());
        assertNotNull(clientR());
        assertNotNull(clientU());
    }


}
