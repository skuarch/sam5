package model.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Bean Server
 *
 * @author skuarch
 */
@Entity
@Table(name = "server")
@NamedQueries({
    @NamedQuery(
            name = "getServerById",
            query = "from Server s where s.id = :id"),
    @NamedQuery(
            name = "getServerByName",
            query = "from Server s where s.name = :name"),    
    @NamedQuery(
            name = "getServersByIp",
            query = "from Server as s where s.ip = :ip and s.serverType.name = :typeName")
})
public class Server implements Serializable {

    @Id
    @Column(name = "server_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private long id;
    @Column(name = "server_name")
    @Basic(optional = false)
    private String name;
    @Column(name = "server_ip")
    @Basic(optional = false)
    private String ip;
    @Column(name = "server_port")
    @Basic(optional = false)
    private int port;
    @Column(name = "server_description")
    @Basic(optional = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "server_type_id")
    @Basic(optional = false)
    private ServerType serverType = null;
    @Column(name = "server_status")
    @Basic(optional = false)
    private int status;

    //==========================================================================
    public Server() {
    } // end Servers

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ServerType getServerType() {
        return serverType;
    }

    public void setServerType(ServerType serverType) {
        this.serverType = serverType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[id=" + id + " name=" + name + " ip=" + ip + " port=" + port + " serverType=" + serverType + " description=" + description + " status= " + status + "]";
    }
} // end Servers