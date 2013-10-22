package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.net.SocketTimeoutException;
import java.text.ParseException;
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
public class ResponseRule extends ActionSupport {

    private static final Logger logger = Logger.getLogger(ResponseRule.class);
    private String message = null;
    private Server server = null;
    private String id = null;
    private boolean createRule = false;

    @Override
    public String execute() throws Exception {

        JSONObject returnedJson = null;
        String actionReturn = Action.SUCCESS;
        HashMap hm = null;

        try {

            server = SessionUtilities.getServer();

            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "confirmation advanced rule");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("id", id);
            hm.put("createRule", createRule);

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (returnedJson == null) {
                message = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
                return actionReturn;
            }

            if (JSONUtilities.checkErrorJson(returnedJson)) {

                if (returnedJson.getString("error") == null || returnedJson.getString("error").equalsIgnoreCase("null")) {

                    message = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
                    return actionReturn;
                }

                message = "{\"error\":\"" + returnedJson.getString("error") + "\"}";
                return actionReturn;
            }

            if (returnedJson.getBoolean("saved") == true) {
                message = "{\"message\":\"" + getText("firewall.rules.created") + "\"}";
            } else {
                message = "{\"error\":\"" + getText("firewall.rule.no.created") + "\"}";
            }

        } catch (SocketTimeoutException ste) {
            message = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
            logger.error("execute", ste);
            return actionReturn;
        } catch (ParseException pe) {
            message = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
            logger.error("execute", pe);
            return actionReturn;
        } catch (Exception e) {
            message = "{\"error\":\" " + getText("application.error") + "\"}";            
            logger.error("execute", e);
            return actionReturn;
        }


        return actionReturn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCreateRule() {
        return createRule;
    }

    public void setCreateRule(boolean createRule) {
        this.createRule = createRule;
    }
} // end class