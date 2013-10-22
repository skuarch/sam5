package model.common;

import model.beans.ServerConfiguration;
import model.dao.DAO;

/**
 *
 * @author skuarch
 */
public class ModelServerConfiguration {
    
    //==========================================================================
    private ModelServerConfiguration(){
    
    }
    
    //==========================================================================
    public static ServerConfiguration getConfiguration() throws Exception{
    
        return new DAO().get(1, new ServerConfiguration());
        
    }
    
} // end class