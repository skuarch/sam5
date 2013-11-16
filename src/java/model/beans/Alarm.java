package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "alarm")
@NamedQueries({
    @NamedQuery(
            name = "alarmStatusChart",
            query = "select count(a.level) from Alarm a where a.date > :date group by a.level order by a.level asc"),
    @NamedQuery(
            name = "getCurrentAlarms",
            query = "from Alarm a where a.date >= current_date() order by a.date desc"),
    @NamedQuery(
            name = "getCurrentAlarmsByLevel",
            query = "from Alarm a where a.date >= current_date() and a.level = :level order by a.date desc"),
     @NamedQuery(
            name = "getLastAlarmsByLevel",
            query = "from Alarm a where a.level = :level order by a.date desc")
})
public class Alarm implements Serializable {

    @Id
    @Column(name = "alarm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Column(name = "alarm_level")
    private int level = 0;
    @OneToOne
    @JoinColumn(name = "server_type_id")
    private ServerType serverType = null;
    @Column(name = "alarm_date", nullable = false)
    private String date = null;
    @Column(name = "alarm_description")
    private String description = null;
    @OneToOne
    @JoinColumn(name = "code_id")
    private AlarmCode code = null;
    @OneToOne
    @JoinColumn(name = "server_id")
    private Server server = null;    

    //==========================================================================
    public Alarm() {
    } // end Alarm

    //==========================================================================
    public Alarm(Alarm alarm) {
        this.id = alarm.getId();
        this.level = alarm.getLevel();
        this.serverType = alarm.getServerType();
        this.date = alarm.date;
        this.description = alarm.getDescription();
        this.code = alarm.getCode();
        this.server = alarm.getServer();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ServerType getServerType() {
        return serverType;
    }

    public void setServerType(ServerType serverType) {
        this.serverType = serverType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlarmCode getCode() {
        return code;
    }

    public void setCode(AlarmCode code) {
        this.code = code;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "[id=" + id + " level=" + level + " date=" + date + " description=" + description + " code=" + code + " server " + server + " serverType=" + serverType + "]";
    }
} // end class