package actions.webMonitor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import model.beans.Server;
import model.common.RestfulClientWrapper;
import model.util.HashMapUtilities;
import model.util.JSONUtilities;
import model.util.SessionUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
public class DeleteTask extends ActionSupport{

    private static final Logger logger = Logger.getLogger(DeleteTask.class);
    private String message = null;
    private Server server = null;
    private long id = 0;
    
    //==========================================================================
    @Override
    public String execute() throws Exception {
        
        HashMap<String, Object> hm = HashMapUtilities.getHashWebMonitor();
        JSONObject returnedJson = null;        

        try {

            if(id < 1){
                return Action.SUCCESS;
            }
            
            server = SessionUtilities.getServer();

            hm.put("request", "deleteTask");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("id", id);

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                message = returnedJson.getString("error");
                return Action.SUCCESS;
            }

            if (returnedJson.getBoolean("deleted")) {
                message = getText("text.223");
            } else {
                message = returnedJson.getString("message");
            }

        } catch (Exception e) {
            logger.error("execute", e);
        }

        return Action.SUCCESS;
    }    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
} // end class
