package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.TreeMap;
import model.beans.Server;
import model.beans.User;
import model.common.RestfulClientWrapper;
import model.util.HashMapUtilities;
import model.util.JSONUtilities;
import model.util.SessionUtilities;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
public class AppendAdvancedRule extends ActionSupport {

    private static final Logger logger = Logger.getLogger(AppendAdvancedRule.class);
    private Server server = null;
    private String ruleName = null;
    private String negativeSourceHostNet = null;
    private String sourceHostNet = null;
    private String negativeSourcePort = null;
    private String sourcePort = null;
    private String negativeDestinationHostNet = null;
    private String destinationHostNet = null;
    private String negativeDestinationPort = null;
    private String destinationPort = null;
    private String negativeInterfaceIncoming = null;
    private String interfaceIncoming = null;
    private String negativeInterfaceOutgoing = null;
    private String interfaceOutgoing = null;
    private String searchInPacket = null;
    private String comments = null;
    private String negativeProtocol = null;
    private String protocol = null;
    private String negativeIcmpType = null;
    private String icmpType = null;
    private String fragmentation = null;
    private String negativeMac = null;
    private String mac = null;
    private String limitBurts = null;
    private String limitRate = null;
    private String limitPeriod = null;
    private String state = null;
    private String negativeState = null;
    private String tos = null;
    private String negativeTos = null;    
    private String negativeFlag = null;
    private String flag = null;
    private String[] tcpFlagUnset;
    private String[] tcpFlagSet;
    private String set;
    private String unset;
    private String rejectIcmp = null;
    private String target = null;
    private String json = null;

    //==========================================================================
    public AppendAdvancedRule() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        JSONObject returnedJson = null;
        boolean created = false;
        String actionReturn = Action.SUCCESS;
        HashMap hm = null;
        User user = null;

        try {

            TreeMap<String, Object> tm = (TreeMap<String, Object>) ActionContext.getContext().getParameters();

            tcpFlagSet = (String[]) tm.get("tcpFlagSet[]");
            tcpFlagUnset = (String[]) tm.get("tcpFlagUnset[]");
            set = StringUtils.join(tcpFlagSet, "-");
            unset = StringUtils.join(tcpFlagUnset, "-");
            server = SessionUtilities.getServer();
            user = (User) ActionContext.getContext().getSession().get("user");
            
            hm = HashMapUtilities.getHashFirewall();
            hm.put("request", "create advanced rule");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("ruleName", ruleName);
            hm.put("negativeSourceHostNet", negativeSourceHostNet);
            hm.put("sourceHostNet", sourceHostNet);
            hm.put("negativeSourcePort", negativeSourcePort);
            hm.put("sourcePort", sourcePort);
            hm.put("negativeDestinationHostNet", negativeDestinationHostNet);
            hm.put("destinationHostNet", destinationHostNet);
            hm.put("negativeDestinationPort", negativeDestinationPort);
            hm.put("destinationPort", destinationPort);
            hm.put("negativeInterfaceIncoming", negativeInterfaceIncoming);
            hm.put("interfaceIncoming", interfaceIncoming);
            hm.put("negativeInterfaceOutgoing", negativeInterfaceOutgoing);
            hm.put("interfaceOutgoing", interfaceOutgoing);
            hm.put("searchInPacket", searchInPacket);
            hm.put("comments", comments);
            hm.put("negativeProtocol", negativeProtocol);
            hm.put("protocol", protocol);
            hm.put("negativeIcmpType", negativeIcmpType);
            hm.put("icmpType", icmpType);
            hm.put("fragmentation", fragmentation);
            hm.put("negativeMac", negativeMac);
            hm.put("mac", mac);
            hm.put("limitBurts", limitBurts);
            hm.put("limitRate", limitRate);
            hm.put("limitPeriod", limitPeriod);
            hm.put("state", state);
            hm.put("negativeState", negativeState);
            hm.put("tos", tos);
            hm.put("negativeTos", negativeTos);            
            hm.put("negativeFlag", negativeFlag);
            hm.put("flag", flag);
            hm.put("set", set);
            hm.put("unset", unset);
            hm.put("rejectIcmp", rejectIcmp);
            hm.put("target", target);
            hm.put("user", user.getName());
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());

            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (returnedJson == null) {
                json = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
                return actionReturn;
            }

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                json = "{\"error\":\"" + returnedJson.getString("error") + "\"}";
                return actionReturn;
            }

            //check if everithing is ok
            created = returnedJson.getBoolean("created");

            if (created) {
                json = returnedJson.toString();                
            } else {
                json = "{\"message\":\"" + getText("firewall.rule.no.created") + "\"}";            
            }

        } catch (SocketTimeoutException ste) {
            json = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
            logger.error("execute", ste);
            return actionReturn;
        } catch (ParseException pe) {
            json = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
            logger.error("execute", pe);
            return actionReturn;
        } catch (Exception e) {
            json = "{\"error\":\" " + getText("firewall.rules.no.created") + " " + getText("server.bad.response") + " \"}";
            logger.error("execute", e);
            return actionReturn;
        }

        return actionReturn; 
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }    

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getNegativeSourceHostNet() {
        return negativeSourceHostNet;
    }

    public void setNegativeSourceHostNet(String negativeSourceHostNet) {
        this.negativeSourceHostNet = negativeSourceHostNet;
    }

    public String getSourceHostNet() {
        return sourceHostNet;
    }

    public void setSourceHostNet(String sourceHostNet) {
        this.sourceHostNet = sourceHostNet;
    }

    public String getNegativeSourcePort() {
        return negativeSourcePort;
    }

    public void setNegativeSourcePort(String negativeSourcePort) {
        this.negativeSourcePort = negativeSourcePort;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getNegativeDestinationHostNet() {
        return negativeDestinationHostNet;
    }

    public void setNegativeDestinationHostNet(String negativeDestinationHostNet) {
        this.negativeDestinationHostNet = negativeDestinationHostNet;
    }

    public String getDestinationHostNet() {
        return destinationHostNet;
    }

    public void setDestinationHostNet(String destinationHostNet) {
        this.destinationHostNet = destinationHostNet;
    }

    public String getNegativeDestinationPort() {
        return negativeDestinationPort;
    }

    public void setNegativeDestinationPort(String negativeDestinationPort) {
        this.negativeDestinationPort = negativeDestinationPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getNegativeInterfaceIncoming() {
        return negativeInterfaceIncoming;
    }

    public void setNegativeInterfaceIncoming(String negativeInterfaceIncoming) {
        this.negativeInterfaceIncoming = negativeInterfaceIncoming;
    }

    public String getInterfaceIncoming() {
        return interfaceIncoming;
    }

    public void setInterfaceIncoming(String interfaceIncoming) {
        this.interfaceIncoming = interfaceIncoming;
    }

    public String getNegativeInterfaceOutgoing() {
        return negativeInterfaceOutgoing;
    }

    public void setNegativeInterfaceOutgoing(String negativeInterfaceOutgoing) {
        this.negativeInterfaceOutgoing = negativeInterfaceOutgoing;
    }

    public String getInterfaceOutgoing() {
        return interfaceOutgoing;
    }

    public void setInterfaceOutgoing(String interfaceOutgoing) {
        this.interfaceOutgoing = interfaceOutgoing;
    }

    public String getSearchInPacket() {
        return searchInPacket;
    }

    public void setSearchInPacket(String searchInPacket) {
        this.searchInPacket = searchInPacket;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNegativeProtocol() {
        return negativeProtocol;
    }

    public void setNegativeProtocol(String negativeProtocol) {
        this.negativeProtocol = negativeProtocol;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getNegativeIcmpType() {
        return negativeIcmpType;
    }

    public void setNegativeIcmpType(String negativeIcmpType) {
        this.negativeIcmpType = negativeIcmpType;
    }

    public String getIcmpType() {
        return icmpType;
    }

    public void setIcmpType(String icmpType) {
        this.icmpType = icmpType;
    }

    public String getFragmentation() {
        return fragmentation;
    }

    public void setFragmentation(String fragmentation) {
        this.fragmentation = fragmentation;
    }

    public String getNegativeMac() {
        return negativeMac;
    }

    public void setNegativeMac(String negativeMac) {
        this.negativeMac = negativeMac;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getLimitBurts() {
        return limitBurts;
    }

    public void setLimitBurts(String limitBurts) {
        this.limitBurts = limitBurts;
    }

    public String getLimitRate() {
        return limitRate;
    }

    public void setLimitRate(String limitRate) {
        this.limitRate = limitRate;
    }

    public String getLimitPeriod() {
        return limitPeriod;
    }

    public void setLimitPeriod(String limitPeriod) {
        this.limitPeriod = limitPeriod;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNegativeState() {
        return negativeState;
    }

    public void setNegativeState(String negativeState) {
        this.negativeState = negativeState;
    }

    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    public String getNegativeTos() {
        return negativeTos;
    }

    public void setNegativeTos(String negativeTos) {
        this.negativeTos = negativeTos;
    }

    public String getNegativeFlag() {
        return negativeFlag;
    }

    public void setNegativeFlag(String negativeFlag) {
        this.negativeFlag = negativeFlag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String[] getTcpFlagUnset() {
        return tcpFlagUnset;
    }

    public void setTcpFlagUnset(String[] tcpFlagUnset) {
        this.tcpFlagUnset = tcpFlagUnset;
    }

    public String[] getTcpFlagSet() {
        return tcpFlagSet;
    }

    public void setTcpFlagSet(String[] tcpFlagSet) {
        this.tcpFlagSet = tcpFlagSet;
    }

    public String getRejectIcmp() {
        return rejectIcmp;
    }

    public void setRejectIcmp(String rejectIcmp) {
        this.rejectIcmp = rejectIcmp;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
} // end class