package model.common;

import model.beans.Alarm;
import model.beans.AlarmCode;
import model.beans.Server;
import model.beans.ServerType;
import model.util.JSONUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * All the logic of Alarms is here.
 *
 * @author skuarch
 */
public class ModelDispatchAlarm extends Thread {

    private static final Logger logger = Logger.getLogger(ModelDispatchAlarm.class);
    private String remoteHost = null;
    private String jsonString = null;

    //==========================================================================
    /**
     * create a instance
     *
     * @param remoteHost String
     * @param jsonString String
     */
    public ModelDispatchAlarm(String remoteHost, String jsonString) {

        setName("ModelDispatcherAlarm");
        this.remoteHost = remoteHost;
        this.jsonString = jsonString;

    } // end ModelDispatchAlarm

    //==========================================================================
    @Override
    public void run() {

        JSONObject jsono = null;
        Alarm alarm = null;
        Server server = null;
        ServerType serverType = null;
        AlarmCode code = null;
        String[] fields = {"level", "date", "code", "text", "serverType", "description", "serverName"};
        String serverName = null;

        try {

            //validate string
            if (jsonString == null || jsonString.length() < 1) {
                logger.error("jsonString is null or empty from: " + remoteHost);
                return;
            }

            //create a json
            jsono = new JSONObject(jsonString);

            //validate json
            if (!JSONUtilities.validateJson(jsono, fields)) {
                logger.error("", new Exception("json is incorrect " + remoteHost));
                return;
            } // end of validations

            //check if the alarm doesn't come from a zombie server            
            if (!ModelServers.existsServer(jsono.getString("serverName"))) {

                //server doesn't exist, maybe is a ghost or zombie.
                logger.error("receiving alarm from server that doesn't have register " + remoteHost);
                return;

            } else {

                //create the generic alarm
                serverName = jsono.getString("serverName");
                serverType = ModelServerType.getServerTypeById(jsono.getInt("serverType"));
                code = ModelAlarmCode.getCodeById(jsono.getInt("code"));
                server = ModelServers.getServer(serverName);

                alarm = new Alarm();
                alarm.setLevel(jsono.getInt("level"));
                alarm.setDate(jsono.getString("date"));
                alarm.setServerType(serverType);
                alarm.setServer(server);
                alarm.setDescription(jsono.getString("description"));
                alarm.setCode(code);

                ModelAlarm.createAlarm(alarm);

                //we need to create another alarm this new alarm depends of the ServerType
                //sub alarm
                new CreateSubAlarm(alarm, serverType, jsono).createSubAlarm();

                //send the alarm to all the web browsers            
                BroadcastMessage.sendMessage(jsono.getString("text"));

            }


        } catch (Exception e) {
            logger.error(remoteHost, e);
        }

    } // end run 
} // end class
