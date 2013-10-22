package model.common;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.WebServices;
import model.dao.DAO;

/**
 *
 * @author skuarch
 */
public class ModelWebServices {

    //==========================================================================
    private ModelWebServices() {
    } // end ModelWebServices

    //==========================================================================
    public static WebServices getWebServiceByName(String name) throws Exception {

        ConcurrentHashMap chm = new ConcurrentHashMap();
        chm.put("name", name);
        ArrayList<WebServices> webServiceses = null;
        WebServices ws = null;

        webServiceses = new DAO().query("getWebserviceByName", new WebServices(), chm);

        if (webServiceses != null) {
            ws = webServiceses.get(0);
        }

        return ws;
    } // end getWebServiceByName
    
} // end class