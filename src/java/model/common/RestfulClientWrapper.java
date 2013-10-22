package model.common;

import java.io.IOException;
import java.net.SocketTimeoutException;
import model.beans.ServerConfiguration;
import model.beans.WebServices;
import model.net.restful.RestfulClient;
import org.json.JSONObject;

/**
 * wrapper for RestfulClient
 *
 * @author skuarch
 */
public class RestfulClientWrapper {

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    private RestfulClientWrapper() {
    } // end RestfulClientWrapper1

    //==========================================================================
    /**
     * send String and receive Json.
     *
     * @param json String
     * @return String
     * @throws IOException
     * @throws Exception
     */
    public static JSONObject sendReceiveString(String json) throws IOException, Exception,SocketTimeoutException {

        String stringReturn = null;
        WebServices ws = ModelWebServices.getWebServiceByName("jumper");
        ServerConfiguration sc = ModelServerConfiguration.getConfiguration();
        JSONObject jsono = null;

        RestfulClient rc = new RestfulClient(ws.getUrl(), ws.getMethod());
        rc.setTimeout(sc.getTimeWaitMessage());
        rc.openConnection();
        rc.sendText(json);
        stringReturn = rc.receiveText();
        rc.closeConnection();        
        
        jsono = new JSONObject(stringReturn);

        return jsono;

    } // end sendReceiveString
} // end class