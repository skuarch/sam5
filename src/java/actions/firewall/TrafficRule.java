package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import model.beans.Server;
import model.common.RestfulClientWrapper;
import model.util.HashMapUtilities;
import model.util.JSONUtilities;
import model.util.ServerConfigurationUtilities;
import model.util.SessionUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
public class TrafficRule extends ActionSupport {

    private static final Logger logger = Logger.getLogger(TrafficRule.class);
    private int id;
    private String chain = null;
    private String table = null;
    private String message = null;
    private Server server = null;

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String returnAction = Action.SUCCESS;
        HashMap hm = null;
        JSONObject returnedJson = null;

        try {

            server = SessionUtilities.getServer();

            hm = HashMapUtilities.getHashFirewall();
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("timeout", ServerConfigurationUtilities.getTimeWaitMessage());
            hm.put("chain", chain);
            hm.put("id", id);
            hm.put("table", table);
            hm.put("request", "get traffic rule");

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());            
            
            if (returnedJson == null) {
                message = getText("application.error.server.remote");
            }

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                message = returnedJson.getString("error");
            } else {
                message = getText("firewall.rules.details.packets") + returnedJson.getString("packets")+ " - " + getText("firewall.rules.details.bytes") + " " +  returnedJson.getString("bytes");
            }

        } catch (Exception e) {
            message = getText("application.error");
            logger.error("execute", e);
            return returnAction;
        }

        return returnAction;
    } // end execute

    //==========================================================================
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
} // end class