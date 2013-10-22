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
public class DeleteFirewallRule extends ActionSupport {

    private static final Logger logger = Logger.getLogger(DeleteFirewallRule.class);
    private String message = null;
    private Server server = null;
    private int id;
    private String chain = null;
    private String table = null;
    private boolean deleted = false;

    //==========================================================================
    public DeleteFirewallRule() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        HashMap hm = null;
        JSONObject jsonReturned = null;
        String actionReturn = Action.SUCCESS;

        try {

            server = SessionUtilities.getServer();

            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "delete rule");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("id", id);
            hm.put("chain", chain);
            hm.put("table", table);

            jsonReturned = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (jsonReturned == null) {
                message = getText("firewall.rules.error.delete");
                return actionReturn;
            }


            if (JSONUtilities.checkErrorJson(jsonReturned)) {
                message = "error: " + jsonReturned.getString("error");
                return actionReturn;
            }

            //check if everithing is ok
            deleted = jsonReturned.getBoolean("deleted");

            if (deleted) {
                message = getText("firewall.rules.deleted");
            } else {
                message = jsonReturned.getString("error");
            }

        } catch (Exception e) {
            message = getText("firewall.rules.error.delete");
            logger.error("execute", e);
            return actionReturn;
        }

        return Action.SUCCESS;


    } // end execute    

    //==========================================================================
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
} // end class