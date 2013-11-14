package actions.webMonitor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
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
public class TaskTable extends ActionSupport{

    private static final Logger logger = Logger.getLogger(TaskTable.class);
    private String js = null;    
    private Server server = null;
    private int rows;
    private List names = null;
    private List url = null;
    private List method = null;
    private List trigger = null;
    private List status = null;
    private List period = null;
    private List timeout = null;    
    
    //==========================================================================
    public TaskTable() {
    } // end taskTable

    //==========================================================================
    @Override
    public String execute() throws Exception {        
              
        HashMap<String, Object> hm = HashMapUtilities.getHashWebMonitor();
        JSONObject returnedJson = null;
        
        try {
            
            server = SessionUtilities.getServer();
            
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            
            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString()); 
            
            if (JSONUtilities.checkErrorJson(returnedJson)) {
                
                js = "alertify.alert('error: " + returnedJson.getString("error") + "')";
                
            }else{
            
                System.out.println("moos: " + returnedJson);
                rows = returnedJson.getInt("rows");
                names = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("names"));
                url = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("url"));
                method = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("method"));
                trigger = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("trigger"));
                status = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("status"));
                period = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("period"));
                timeout = JSONUtilities.jsonArrayToArrayList(returnedJson.getJSONArray("timeout"));
                
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

    public List getNames() {
        return names;
    }

    public void setNames(List names) {
        this.names = names;
    }

    public List getUrl() {
        return url;
    }

    public void setUrl(List url) {
        this.url = url;
    }

    public List getMethod() {
        return method;
    }

    public void setMethod(List method) {
        this.method = method;
    }

    public List getTrigger() {
        return trigger;
    }

    public void setTrigger(List trigger) {
        this.trigger = trigger;
    }

    public List getStatus() {
        return status;
    }

    public void setStatus(List status) {
        this.status = status;
    }

    public List getPeriod() {
        return period;
    }

    public void setPeriod(List period) {
        this.period = period;
    }

    public List getTimeout() {
        return timeout;
    }

    public void setTimeout(List timeout) {
        this.timeout = timeout;
    }
    
} // end class