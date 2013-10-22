package model.common;

import model.beans.Alarm;
import model.beans.AlarmE2E;
import model.beans.ServerType;
import model.dao.DAO;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
public class CreateSubAlarm {

    private Alarm alarm;
    private ServerType serverType;
    private JSONObject jsono = null;

    //==========================================================================
    public CreateSubAlarm(Alarm alarm, ServerType serverType, JSONObject jsono) {
        this.alarm = alarm;
        this.serverType = serverType;
        this.jsono = jsono;
    }

    //==========================================================================
    public void createSubAlarm() throws Exception {

        if (alarm == null || serverType == null || jsono == null) {
            throw new IllegalArgumentException("alarm, servertype or json are incorrect");
        }

        int id = (int) serverType.getId();

        switch (id) {

            case 1:
                createAlarmE2E();
                break;

            case 2:
                createAlarmFilter();
                break;

            case 3:
                createAlarmFirewall();
                break;
            case 4:
                createAlarmIDS();
                break;
            case 5:
                createAlarmPortScanner();
                break;
            case 6:
                createAlarmSniffer();
                break;
            case 7:
                createAlarmTrafficShapper();
                break;
            case 8:
                createAlarmUrlMonitor();
                break;

        }

    }

    //==========================================================================
    private void createAlarmE2E() throws Exception {

        AlarmE2E aee = new AlarmE2E(alarm);
        aee.setTaskName(jsono.getString("taskName"));
        new DAO().create(aee);

    }

    //==========================================================================
    private void createAlarmFilter() {
    }

    //==========================================================================
    private void createAlarmFirewall() {
    }

    //==========================================================================
    private void createAlarmIDS() {
    }

    //==========================================================================
    private void createAlarmPortScanner() {
    }

    //==========================================================================
    private void createAlarmSniffer() {
    }

    //==========================================================================
    private void createAlarmTrafficShapper() {
    }
    
    //==========================================================================
    private void createAlarmUrlMonitor(){
    }
} // end class