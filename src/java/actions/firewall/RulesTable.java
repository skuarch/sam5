package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.ArrayList;
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
 * table of rules.
 *
 * @author skuarch
 */
public class RulesTable extends ActionSupport {

    private static final Logger logger = Logger.getLogger(RulesTable.class);
    private Server server = null;
    private String js = null;
    private int rows;
    private String[] id;
    private String[] tableType;
    private String[] ruleName;
    private String[] direction;
    private String[] target;
    private String[] protocol;
    private String[] inInterface;
    private String[] outInterface;
    private String[] sourceAddress;
    private String[] destinationAddress;
    private String[] sourcePort;
    private String[] destinationPort;
    private String[] creationDate;
    private String[] user;
    private String[] extraInfo;
    private String[] comments;
    private String[] arraySlots = null;
    private ArrayList<String[]> slots;
    private String[] description = null;
    private String firewallStatus = "";

    //==========================================================================
    @Override
    public String execute() throws Exception {

        HashMap<String, Object> hm = HashMapUtilities.getHashFirewall();
        JSONObject returnedJson = null;

        try {

            server = SessionUtilities.getServer();

            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("timeout", ServerConfigurationUtilities.getTimeWaitMessage());

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                js = "alertify.alert('error: " + returnedJson.getString("error") + "')";
            } else {

                //setVariables                
                firewallStatus = returnedJson.getString("firewallStatus");
                rows = returnedJson.getInt("rows");
                id = returnedJson.getString("id").split(",");
                tableType = returnedJson.getString("tableType").split(",");
                ruleName = returnedJson.getString("ruleName").split(",");
                direction = returnedJson.getString("direction").split(",");
                target = returnedJson.getString("target").split(",");
                protocol = returnedJson.getString("protocol").split(",");
                inInterface = returnedJson.getString("inInterface").split(",");
                outInterface = returnedJson.getString("outInterface").split(",");
                sourceAddress = returnedJson.getString("sourceAddress").split(",");
                destinationAddress = returnedJson.getString("destinationAddress").split(",");
                sourcePort = returnedJson.getString("sourcePort").split(",");
                destinationPort = returnedJson.getString("destinationPort").split(",");
                creationDate = returnedJson.getString("creationDate").split(",");
                user = returnedJson.getString("user").split(",");
                extraInfo = returnedJson.getString("extraInfo").split(",");
                comments = returnedJson.getString("comments").split(",");
                arraySlots = returnedJson.getString("slots").toString().split(",");
                description = returnedJson.getString("descriptions").toString().split(",");
                slots = new ArrayList();
                
                for (String arraySlot : arraySlots) {
                    slots.add(arraySlot.split("-"));
                }

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

    //==========================================================================
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

    public String[] getTableType() {
        return tableType;
    }

    public void setTableType(String[] tableType) {
        this.tableType = tableType;
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

    public String[] getProtocol() {
        return protocol;
    }

    public void setProtocol(String[] protocol) {
        this.protocol = protocol;
    }

    public String[] getInInterface() {
        return inInterface;
    }

    public void setInInterface(String[] inInterface) {
        this.inInterface = inInterface;
    }

    public String[] getOutInterface() {
        return outInterface;
    }

    public void setOutInterface(String[] outInterface) {
        this.outInterface = outInterface;
    }

    public String[] getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String[] sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String[] getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String[] destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String[] getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String[] sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String[] getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String[] destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String[] getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String[] creationDate) {
        this.creationDate = creationDate;
    }

    public String[] getUser() {
        return user;
    }

    public void setUser(String[] user) {
        this.user = user;
    }

    public String[] getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String[] extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public ArrayList<String[]> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<String[]> slots) {
        this.slots = slots;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String getFirewallStatus() {
        return firewallStatus;
    }

    public void setFirewallStatus(String firewallStatus) {
        this.firewallStatus = firewallStatus;
    }
    
} // end class