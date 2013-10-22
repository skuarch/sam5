package model.net.restful;

import java.util.HashMap;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author skuarch
 */
public class RestfulClientTest {
    
    public RestfulClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openConnection method, of class RestfulClient.
     */
    @Test
    public void testOpenConnection() throws Exception {        
        
        RestfulClient rc = new RestfulClient("http://192.168.208.9:8080/sam5Restful/resources/jumper/link", "POST");
        
        HashMap hm = new HashMap();
        hm.put("host", "192.168.207.21");
        hm.put("port", "8087");
        hm.put("timeout", "1000");
        
        rc.openConnection();
        rc.sendText(new JSONObject(hm).toString());
        System.out.println(rc.receiveText());
        rc.closeConnection();
        
        
    }
}