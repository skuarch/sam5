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
@Table(name = "alarm_code")
@NamedQueries({
    @NamedQuery(
        name="getCodeById",
        query="from AlarmCode a where a.id = :id")
})
public class AlarmCode implements Serializable {

    @Id
    @Column(name = "code_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Column(name = "code_description")
    private String description = null;

    //==========================================================================
    public AlarmCode() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[id=" + id + " description=" + description +"]";
    }
} // end class