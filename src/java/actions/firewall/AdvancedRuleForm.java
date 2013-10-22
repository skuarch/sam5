package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.NoSuchElementException;
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
public class AdvancedRuleForm extends ActionSupport {

    private static final Logger logger = Logger.getLogger(AdvancedRuleForm.class);
    private String js = null;
    private String[] interfaces = null;
    private boolean error = false;
    private String firewallStatus = "enabled";

    //==========================================================================
    public AdvancedRuleForm() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        JSONObject returnedJson = null;
        String actionReturn = Action.SUCCESS;
        Server server = null;
        HashMap hm = null;

        try {

            server = SessionUtilities.getServer();
            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "get interfaces and status");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (returnedJson == null || returnedJson.length() < 1) {
                js = "alertify.alert('" + getText("firewall.no.interfaces") + "')";
                error = true;
                return actionReturn;
            }

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                js = "alertify.alert('" + returnedJson.getString("error") + "')";
                error = true;
                return actionReturn;
            }

            interfaces = returnedJson.getString("interfaces").split(",");
            firewallStatus = returnedJson.getString("firewallStatus");

        } catch (SocketTimeoutException ste) {
            js = "alertify.alert('" + getText("server.bad.response") + "')";
            error = true;
            logger.error("execute", ste);
            return Action.ERROR;
        } catch (NoSuchElementException nsee) {
            js = "alertify.alert('" + getText("server.bad.response") + "')";
            error = true;
            logger.error("execute", nsee);
            return Action.ERROR;
        } catch (ParseException pe) {
            js = "alertify.alert('" + getText("server.bad.response") + "')";
            error = true;
            logger.error("execute", pe);
            return Action.ERROR;
        } catch (Exception e) {
            js = "alertify.alert('" + getText("application.error") + "')";
            error = true;
            logger.error("execute", e);
            return Action.ERROR;
        }

        return actionReturn;
    } // end execute

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String[] interfaces) {
        this.interfaces = interfaces;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getFirewallStatus() {
        return firewallStatus;
    }

    public void setFirewallStatus(String firewallStatus) {
        this.firewallStatus = firewallStatus;
    }    
    
} // end class