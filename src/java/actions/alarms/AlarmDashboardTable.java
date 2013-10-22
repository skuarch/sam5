package actions.alarms;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import model.beans.Alarm;
import model.common.ModelAlarm;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class AlarmDashboardTable extends ActionSupport {

    private static final Logger logger = Logger.getLogger(AlarmDashboardTable.class);
    private ArrayList<Alarm> alarms = null;
    private String js = null;
    private int level = 0;
    
    //==========================================================================
    public AlarmDashboardTable(){

    } // end AlarmDashboardTable

    //==========================================================================
    @Override
    public String execute() throws Exception {

        try {
            
            alarms = ModelAlarm.getLastAlarmsByLevel(50,level);    
           
        } catch (Exception e) {
            logger.error("AlarmDashboardTable",e);
            js = "alertify.log(\""+e.getMessage()+"\");";
        }
        
        return Action.SUCCESS;

    } // end execute

    //==========================================================================
    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public void setAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
    }    

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
} // end class
