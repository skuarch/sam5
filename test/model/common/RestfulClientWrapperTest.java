package model.common;

import java.util.HashMap;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skuarch
 */
public class RestfulClientWrapperTest {
    
    public RestfulClientWrapperTest() {
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
     * Test of sendReceiveString method, of class RestfulClientWrapper.
     */
    @Test
    public void testSendReceiveString() throws Exception {        
        
        HashMap hm = new HashMap();
        hm.put("host", "192.168.207.21");
        hm.put("port", 8087);        
        hm.put("timeout", 8087);        
        
        RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());
        
    }
}