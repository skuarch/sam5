package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import model.beans.Server;
import model.beans.User;
import model.common.RestfulClientWrapper;
import model.util.HashMapUtilities;
import model.util.JSONUtilities;
import model.util.SessionUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * create rule preconfigured.
 *
 * @author skuarch
 */
public class CreatePreconfiguredRule extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CreatePreconfiguredRule.class);
    private String message = null;
    private Server server = null;
    private String host = null;
    private String port;
    private int p;
    private String target = null;
    private String trafficType = null;
    private String protocol = null;
    private String comments = null;

    //==========================================================================
    public CreatePreconfiguredRule() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String actionReturn = Action.SUCCESS;
        HashMap hm = null;
        User user = null;
        JSONObject returnedJson = null;
        boolean created = false;

        try {

            //validations
            if (host == null || host.length() < 1) {
                message = "incorrect host";
                return actionReturn;
            }

            // port can be empty
            if (!protocol.equalsIgnoreCase("icmp")) {

                //check if port is a number
                if (port != null) {
                    p = Integer.parseInt(port);
                    //check the range
                    if (p < 0 || p > 65535) {
                        message = "incorrect port";
                        return actionReturn;
                    }
                }
            }

            if (target == null || target.length() < 1) {
                message = "incorrect target";
                return actionReturn;
            }

            if (trafficType == null || trafficType.length() < 1) {
                message = "incorrect traffic type";
                return actionReturn;
            }

            if (comments != null) {

                if (comments.length() > 200) {
                    message = "comments are too long";
                    return actionReturn;
                }

            }

            server = SessionUtilities.getServer();
            user = (User) ActionContext.getContext().getSession().get("user");

            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "create preconfigured rule");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("hostRule", host);
            hm.put("portRule", port);
            hm.put("target", target);
            hm.put("trafficType", trafficType);
            hm.put("protocol", protocol);
            hm.put("user", user.getName());
            hm.put("comments", comments);

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (returnedJson == null) {
                message = getText("firewall.rules.no.created");
                return actionReturn;
            }

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                message = "error: " + returnedJson.getString("error");
                return actionReturn;
            }

            //check if everithing is ok
            created = returnedJson.getBoolean("created");

            if (created) {
                message = getText("firewall.rules.created");
            } else {
                message = returnedJson.getString("error");
            }

        } catch (NumberFormatException nfe) {
            message = "error: incorrect port";
            logger.error("execute", nfe);
            return actionReturn;
        } catch (Exception e) {
            message = "error: " + e.getMessage();
            logger.error("execute", e);
            return actionReturn;
        }

        return actionReturn;
    }

    //==========================================================================
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
} // end class