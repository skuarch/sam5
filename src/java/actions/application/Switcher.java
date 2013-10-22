package actions.application;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.beans.Server;
import model.common.ModelServers;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class Switcher extends ActionSupport {

    private static final Logger logger = Logger.getLogger(Switcher.class);
    private Map<String, Object> session = null;
    private Server server = null;
    private String nextAction = null;
    private String action = null;
    private long id = 0;

    //==========================================================================
    @Override
    public String execute() throws Exception {

        try {
            
            server = ModelServers.getServer(id);            

            session = ActionContext.getContext().getSession();
            session.put("server", server);
            nextAction = action;
            
        } catch (Exception e) {
            logger.error("Switcher", e);
        }

        return Action.SUCCESS;
    } // end execute

    //==========================================================================
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }   
    
} // end class