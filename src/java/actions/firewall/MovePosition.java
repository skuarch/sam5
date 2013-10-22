package actions.firewall;

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
public class MovePosition extends ActionSupport{

    private static final Logger logger = Logger.getLogger(MovePosition.class);
    private String message = null;
    private Server server = null;private int id;
    private String chain = null;
    private String table = null;
    private int position = 0;
    private boolean moved = false;
    
    //==========================================================================
    public MovePosition() {
    } // end MovePosition
    
    
    //==========================================================================
    @Override
    public String execute() throws Exception {
        
        HashMap hm = null;
        JSONObject jsonReturned = null;
        String actionReturn = Action.SUCCESS;
        
        try {
            
            server = SessionUtilities.getServer();
            
            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "move rule");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("id", id);
            hm.put("chain", chain);
            hm.put("table", table);
            hm.put("position", position);
            
            jsonReturned = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (jsonReturned == null) {
                message = getText("firewall.rules.error.move");
                return actionReturn;
            }

            if (JSONUtilities.checkErrorJson(jsonReturned)) {
                message = "error: " + jsonReturned.getString("error");
                return actionReturn;
            }

            //check if everithing is ok
            moved = jsonReturned.getBoolean("moved");

            if (moved) {
                message = getText("firewall.rules.moved");
            } else {
                message = jsonReturned.getString("error");
            }
            
        } catch (Exception e) {            
            message = getText("firewall.rules.error.move");            
            logger.error("execute",e);            
            return actionReturn;
        }
        
        return actionReturn;
    }    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }    
    
} // end class