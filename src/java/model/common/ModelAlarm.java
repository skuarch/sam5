package model.common;

import java.util.ArrayList;
import java.util.HashMap;
import model.beans.Alarm;
import model.dao.DAO;

/**
 * business logic for Alarm.
 *
 * @author skuarch
 */
public class ModelAlarm {

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    private ModelAlarm() {
    } // end ModelAlarm

    //==========================================================================
    /**
     * Create a new Alarm in the database.
     *
     * @param alarm
     * @throws Exception
     */
    public static void createAlarm(Alarm alarm) throws Exception {

        if (alarm == null) {
            throw new IllegalArgumentException("alarm is null");
        }

        new DAO().create(alarm);

    } // end createAlarm

    //==========================================================================
    /**
     * return the alarms of today (current day).
     *
     * @return ArrayList<Alarm>
     * @throws Exception
     */
    public static ArrayList<Alarm> getCurrentAlarms(int results) throws Exception {

        ArrayList<Alarm> alarms = new DAO().query(new Alarm(), "getCurrentAlarms",results);      

        if (alarms == null) {
            alarms = new ArrayList<>();
        }

        return alarms;

    } // end getAlarms

    //==========================================================================
    public static ArrayList<Alarm> getLastAlarms(int results) throws Exception {

        String hql = "from Alarm a order by a.date desc";
        ArrayList<Alarm> alarms = new DAO().hql(new Alarm(), hql, results);

        if (alarms == null) {
            alarms = new ArrayList<>();
        }

        return alarms;

    } // end getLastAlarms

    //==========================================================================
    public static ArrayList<Alarm> getLastAlarmsByLevel(int results, int level) throws Exception {

        if (level == 0) {
            ArrayList<Alarm> alarms = getCurrentAlarms(results);
            return alarms;
        }

        String hql = "from Alarm a where a.level = " + level + " order by a.date desc";
        ArrayList<Alarm> alarms = new DAO().hql(new Alarm(), hql, results);
        
        if (alarms == null) {
            alarms = new ArrayList<>();
        }

        return alarms;

    } // end getLastAlarms

    //==========================================================================
    public static ArrayList<Alarm> getCurrentAlarmsByLevel(int level,int results) throws Exception {

        if (level == 0) {
            ArrayList<Alarm> alarms = getCurrentAlarms(results);
            return alarms;
        }

        HashMap<String, String> hm = new HashMap();
        hm.put("level", String.valueOf(level));

        ArrayList<Alarm> alarms = (ArrayList<Alarm>) new DAO().query("getCurrentAlarmsByLevel", hm, new Alarm());

        if (alarms == null) {
            alarms = new ArrayList<>();
        }

        return alarms;

    } // end getAlarms
} // end class