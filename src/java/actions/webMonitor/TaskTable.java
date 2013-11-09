package actions.webMonitor;

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
public class TaskTable extends ActionSupport{

    private static final Logger logger = Logger.getLogger(TaskTable.class);
    private String js = null;    
    private Server server = null;
    private int rows;
    
    
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
    
} // end class