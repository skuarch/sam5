package model.common;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.AlarmCode;
import model.dao.DAO;

/**
 * business logic for AlarmCode.
 * @author skuarch
 */
public class ModelAlarmCode {

    private static ConcurrentHashMap parameters = new ConcurrentHashMap();

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    private ModelAlarmCode() {
    } // end ModelCode

    //==========================================================================
    /**
     * return the AlarmCode or null.
     * @param id Alarm id
     * @return AlarmCode or null.
     * @throws Exception 
     */
    public static AlarmCode getCodeById(long id) throws Exception {

        AlarmCode code = null;
        List list = null;

        parameters.clear();
        parameters.put("id", String.valueOf(id));
        list = new DAO().query("getCodeById", parameters,new AlarmCode());

        if (list.size() < 1) {
            code = null;
        } else {
            code = (AlarmCode) list.get(0);
        }

        return code;

    } // end getCodeById
    
} // end class