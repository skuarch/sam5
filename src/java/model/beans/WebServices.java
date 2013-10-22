package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "webservices")
@NamedQueries({
        @NamedQuery(name = "getWebserviceByName", query = "from WebServices ws where ws.name = :name")
})
public class WebServices implements Serializable {

    @Id
    @Column(name = "webservice_id")
    private long id;
    @Column(name = "webservice_name")
    private String name;
    @Column(name = "webservice_url")
    private String url;
    @Column(name = "webservice_method")
    private String method;

    public WebServices() {
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
} // end class