package model.util;

import model.common.ModelServerConfiguration;

/**
 *
 * @author skuarch
 */
public class ServerConfigurationUtilities {

    private ServerConfigurationUtilities() {
    }
    
    //==========================================================================
    public static int getTimeWaitMessage() throws Exception{
        
        int timeout = 0;
        timeout = ModelServerConfiguration.getConfiguration().getTimeWaitMessage();
        return timeout;
        
    }
    
    
} // end class