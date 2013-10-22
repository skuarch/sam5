package model.util;

import org.json.JSONObject;

/**
 * JSON utilities.
 *
 * @author skuarch
 */
public class JSONUtilities {

    //=========================================================================
    /**
     * this class doesn't need a public constructor.
     */
    private JSONUtilities() {
    }

    //==========================================================================
    /**
     * validate json.
     *
     * @param json JSONObject
     * @param fields String
     * @return boolean
     * @throws Exception
     */
    public static boolean validateJson(JSONObject json, String... fields) throws Exception {

        boolean flag = false;

        for (int i = 0; i < fields.length; i++) {
            if (!json.has(fields[i]) || json.getString(fields[i]).length() < 1) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }

        return flag;

    } // end validateJson

    //==========================================================================
    public static boolean checkErrorJson(JSONObject json) {

        if (json == null || json.length() < 1) {
            throw new IllegalArgumentException("json is null or empty");
        }

        boolean flag = false;
        flag = json.has("error");

        return flag;

    } // end checkErrorJson
    
} // end class