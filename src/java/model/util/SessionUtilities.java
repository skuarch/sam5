
package model.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.beans.Server;

/**
 *
 * @author skuarch
 */
public class SessionUtilities extends ActionSupport{

    private SessionUtilities() {
    }
    
    //==========================================================================
    public static Server getServer() throws Exception{
        return (Server) ActionContext.getContext().getSession().get("server");
    }
    
}
