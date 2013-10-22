package model.util;

import java.util.HashMap;
import model.common.ModelServerConfiguration;

/**
 *
 * @author skuarch
 */
public class HashMapUtilities {

    //==========================================================================
    private HashMapUtilities() {
    }

    //==========================================================================
    public static HashMap<String, Object> getHashMapE2E() throws Exception {

        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("host", "");
        hm.put("port", "");
        hm.put("type", "e2e");
        hm.put("source", "");
        hm.put("destination", "");
        hm.put("timeout", ModelServerConfiguration.getConfiguration().getTimeWaitMessage());

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> getHashMapPortScanner() throws Exception {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("host", "");
        hm.put("port", "");
        hm.put("type", "port scanner");
        hm.put("target", "");
        hm.put("timeout", ModelServerConfiguration.getConfiguration().getTimeWaitMessage());

        return hm;
    }

    //==========================================================================
    public static HashMap<String, Object> getHashFirewall() throws Exception {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("host", "");
        hm.put("port", "");
        hm.put("type", "firewall");
        //hm.put("table", "");
        hm.put("request", "getRules");
        hm.put("timeout", ModelServerConfiguration.getConfiguration().getTimeWaitMessage());
        
        return hm;
    }
}