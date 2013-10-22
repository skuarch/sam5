package actions.servers;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import model.beans.Server;
import model.common.ModelServers;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class ServersTable extends ActionSupport {

    private final Logger logger = Logger.getLogger(ServersTable.class);
    private String js = null;
    private ArrayList<Server> servers = new ArrayList<>();

    //==========================================================================
    public ServersTable() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String returnAction = Action.SUCCESS;

        try {
            
            servers = ModelServers.getServers();
            
        } catch (Exception e) {            
            logger.error("ServersTable", e);
            js = "alertify.alert(\"" + e.getMessage() + "\")";
        }

        return returnAction;
    } // end execute

    public ArrayList<Server> getServers() {
        return servers;
    }

    public void setServers(ArrayList<Server> servers) {
        this.servers = servers;
    }    
    
    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }   
    
} // end class