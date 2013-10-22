package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import model.beans.Server;
import model.common.RestfulClientWrapper;
import model.util.HashMapUtilities;
import model.util.SessionUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
public class ResetRule extends ActionSupport{

    private static final Logger logger = Logger.getLogger(ResetRule.class);
    private int id;
    
    //==========================================================================
    public ResetRule() {
    } // end ResetRule

    //==========================================================================
    @Override
    public String execute() throws Exception {
        
        Server server = null;
        HashMap hm = null;
        
        try {
            
            server = SessionUtilities.getServer();
            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "reset rule");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("id", id);
            
            RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());
            
        } catch (Exception e) {
            logger.error("execute",e);
            return Action.NONE;
        }
        
        
        return Action.NONE;
    } // end execute    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
} // end class