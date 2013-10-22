package actions.application;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author skuarch
 */
public class Logout extends ActionSupport {

    private static final Logger logger = Logger.getLogger(Logout.class);
    private Map<String, Object> session = null;

    //==========================================================================
    public Logout() {
    } // logout

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String actionReturn = Action.SUCCESS;
        HttpServletResponse response;

        try {

            response = ServletActionContext.getResponse();

            session = ActionContext.getContext().getSession();
            session.put("user", null);

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0); // Proxies.

        } catch (Exception e) {
            logger.error(e);
            actionReturn =  Action.SUCCESS;
        }

        return actionReturn;
    } // end execute    
} // end class