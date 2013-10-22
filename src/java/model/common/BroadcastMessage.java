package model.common;

import model.net.websockets.WebSocketAlarms;

/**
 * send message to all web browsers.
 * @author skuarch
 */
public class BroadcastMessage {
    
    //this class doesn't need a constructor.
    private BroadcastMessage(){    
    } // end BroadcastMessage
    
    //==========================================================================
    /**
     * send message to all clients
     * @param text String
     */
    public static void sendMessage(String text){
        
        if(text == null){
            throw new NullPointerException("text is null");
        }
        
        new WebSocketAlarms().onMessage(text);
    } // end sendMessage
    
} // end class