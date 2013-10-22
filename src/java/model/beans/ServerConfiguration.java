
package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "server_configuration")
public class ServerConfiguration implements Serializable {

    @Id
    @Column(name = "server_configuration_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "server_configuration_ip")
    private String ip;
    
    @Column(name = "server_configuration_context")
    private String context;
    
    @Column(name = "server_configuration_port")
    private int port;
    
    @Column(name = "server_configuration_time_wait_message")
    private int timeWaitMessage;
    
    //==========================================================================
    public ServerConfiguration() {
    } // end ServerConfiguration

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }    

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeWaitMessage() {
        return timeWaitMessage;
    }

    public void setTimeWaitMessage(int timeWaitMessage) {
        this.timeWaitMessage = timeWaitMessage;
    }
   
    
} // end class