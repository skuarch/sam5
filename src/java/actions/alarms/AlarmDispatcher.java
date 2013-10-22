package actions.alarms;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import model.common.ModelDispatchAlarm;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author skuarch
 */
public class AlarmDispatcher extends ActionSupport{

    private static final Logger logger = Logger.getLogger(AlarmDispatcher.class);
    
    //==========================================================================
    /**
     * create a instance.
     */
    public AlarmDispatcher() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {
        
        HttpServletRequest request = null;
        String remoteHost = null;
        String jsonString = null;
        
        try {
            
            request = ServletActionContext.getRequest();
            remoteHost = request.getRemoteHost();
            jsonString = request.getHeader("alarm");

            if (jsonString == null || jsonString.length() < 1) {
                
                logger.error("AlarmDispatcher", new NullPointerException("jsonString is null or empty from " + remoteHost));

            } else {
                
                (new ModelDispatchAlarm(remoteHost, jsonString)).start();
                
            }
            
            
        } catch (Exception e) {
            logger.error(remoteHost,e);
        }
        
        return Action.NONE;
    } // end class
    
    
} // end class