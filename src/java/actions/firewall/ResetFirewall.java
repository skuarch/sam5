package actions.firewall;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import model.beans.Server;
import model.beans.User;
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
public class ResetFirewall extends ActionSupport{
    
    private static final Logger logger = Logger.getLogger(ResetFirewall.class);
    private Server server = null;
    private String message = null;

    @Override
    public String execute() throws Exception {
        
        HashMap<String, Object> hm = HashMapUtilities.getHashFirewall();
        JSONObject returnedJson = null;
        User user = null;
        
        try {
            
            server = SessionUtilities.getServer();
            user = (User) ActionContext.getContext().getSession().get("user");
            
            hm.put("request", "resetRules");
            hm.put("host", server.getIp());
            hm.put("port", server.getPort());   
            hm.put("user", user.getName());
            
            returnedJson = RestfulClientWrapper.sendReceiveString(new JSONObject(hm).toString());
            
            if(returnedJson == null || returnedJson.length()< 1){
                message = getText("server.bad.response");
                return Action.SUCCESS;
            }
            
            if (JSONUtilities.checkErrorJson(returnedJson)) {
                message = returnedJson.getString("error");
                return Action.SUCCESS;
            }            
            
            if(returnedJson.getBoolean("reseted")){
                message = getText("text.13");
            }else{
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
            message = getText("server.bad.response");
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
    
} // end ResetFirewall