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
import model.util.ServerConfigurationUtilities;
import model.util.SessionUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
public class RulesStatusInterval extends ActionSupport{

    
    private static final Logger logger = Logger.getLogger(RulesTable.class);
    private Server server = null;
    private String js = null;
    private int rows;
    private String[] id;
    private String[] ruleName;    
    private String[] direction;
    private String[] target;    
    private String[] packets;    
    private String[] bytes;    

    //==========================================================================
    @Override
    public String execute() throws Exception {

        HashMap<String, Object> hm = HashMapUtilities.getHashFirewall();
        JSONObject returnedJson = null;

        try {

            server = SessionUtilities.getServer();

            hm.put("request", "get rules status");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("timeout", ServerConfigurationUtilities.getTimeWaitMessage());            
            
            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());            
            
            if(returnedJson == null){
                js = "alertify.alert('error: " + returnedJson.getString("error") + "')";
            }
            

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                js = "alertify.alert('error: " + returnedJson.getString("error") + "')";
            } else {

                //setVariables
                rows = returnedJson.getInt("rows");
                id = returnedJson.getString("id").split(",");                
                ruleName = returnedJson.getString("ruleName").split(",");
                direction = returnedJson.getString("direction").split(",");
                target = returnedJson.getString("target").split(",");                
                packets = returnedJson.getString("packets").split(",");                
                bytes = returnedJson.getString("bytes").split(",");                

            }

        } catch (SocketTimeoutException ste) {
            logger.error("execute", ste);
            js = "alertify.alert('" + getText("server.bad.response") + "')";
            return Action.SUCCESS;
        } catch (NoSuchElementException nsee) {
            logger.error("execute", nsee);
            js = "alertify.alert('" + getText("server.bad.response") + "')";
            return Action.SUCCESS;
        } catch (ParseException pe) {
            logger.error("execute", pe);
            js = "alertify.alert('" + getText("server.bad.response") + "')";
            return Action.SUCCESS;
        } catch (Exception e) {
            logger.error("execute", e);
            js = "alertify.alert('" + getText("application.error") + "')";
            return Action.SUCCESS;
        }

        return Action.SUCCESS;

    } // end execute

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public String[] getRuleName() {
        return ruleName;
    }

    public void setRuleName(String[] ruleName) {
        this.ruleName = ruleName;
    }

    public String[] getDirection() {
        return direction;
    }

    public void setDirection(String[] direction) {
        this.direction = direction;
    }

    public String[] getTarget() {
        return target;
    }

    public void setTarget(String[] target) {
        this.target = target;
    }

    public String[] getPackets() {
        return packets;
    }

    public void setPackets(String[] packets) {
        this.packets = packets;
    }

    public String[] getBytes() {
        return bytes;
    }

    public void setBytes(String[] bytes) {
        this.bytes = bytes;
    }

} // end class