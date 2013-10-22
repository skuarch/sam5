package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "alarm_e2e")
public class AlarmE2E implements Serializable {

    @Id
    @Column(name = "alarm_e2e_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "alarm_id")
    private Alarm alarm = null;
    @Column(name = "alarm_e2e_task_name", nullable = false)
    private String taskName = null;

    //==========================================================================
    public AlarmE2E(Alarm alarm) {
        this.alarm = alarm;
    } // end AlarmE2E

    //==========================================================================
    public AlarmE2E() {
    } // end AlarmE2E

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "[id= " + id + " alarm= " + alarm + " taskName= " + taskName + "]";
    }
} // end class