package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "server_type")
@NamedQueries({
    @NamedQuery(
            name = "getServerTypeById",
            query = "from ServerType s where s.id = :id"),
    @NamedQuery(
            name = "getServerTypeByName",
            query = "from ServerType s where s.name = :name")
})
public class ServerType implements Serializable {

    @Id
    @Column(name = "server_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "server_type_name")
    private String name;
    @Column(name = "server_type_action")
    private String action;

    //==========================================================================
    public ServerType() {
    } // end ServerType

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "[id=" + id + " name=" + name + " action=" + action + "]";
    }
} // end class