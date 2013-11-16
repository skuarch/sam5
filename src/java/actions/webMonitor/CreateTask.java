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
public class CreateTask extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CreateTask.class);
    private String message = null;
    private Server server = null;
    private String name = null;
    private String url = null;
    private String trigger = null;
    private String method = null;    
    private String period = null;
    private int alarmLevel = 0;

    //==========================================================================
    @Override
    public String execute() throws Exception {

        HashMap<String, Object> hm = HashMapUtilities.getHashWebMonitor();
        JSONObject returnedJson = null;

        try {

            server = SessionUtilities.getServer();

            hm.put("request", "create task");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());
            hm.put("name", name);
            hm.put("url", url);
            hm.put("trigger", trigger);
            hm.put("method", method);            
            hm.put("period", period);
            hm.put("alarmLevel", alarmLevel);
           
            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());

            if (JSONUtilities.checkErrorJson(returnedJson)) {
                message = returnedJson.getString("error");
                return Action.SUCCESS;
            }

            if (returnedJson.getBoolean("created")) {
                message = getText("text.204");
            } else {
                message = returnedJson.getString("message");
            }

        } catch (SocketTimeoutException ste) {
            logger.error("execute", ste);
            message = getText("server.bad.response");
            return Action.SUCCESS;
        } catch (NoSuchElementException nsee) {
            logger.error("execute", nsee);
            message = getText("server.bad.response");
            return Action.SUCCESS;
        } catch (ParseException pe) {
            logger.error("execute", pe);
            message = getText("server.bad.response");
            return Action.SUCCESS;
        } catch (Exception e) {
            logger.error("execute", e);
            message = getText("application.error");
            return Action.SUCCESS;
        }

        return Action.SUCCESS;

    } // end execute    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(int alarmLevel) {
        this.alarmLevel = alarmLevel;
    }    

} // end class
