package model.util;

import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
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
        for (String field : fields) {
            if (!json.has(field) || json.getString(field).length() < 1) {
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

    //==========================================================================
    public static List jsonArrayToArrayList(JSONArray jsona) {

        String jsonString = jsona.toString();
        List list = null;
        jsonString = jsonString.replace("[", "");
        jsonString = jsonString.replace("]", "");
        jsonString = jsonString.replace("\"", "");
        list = Arrays.asList(jsonString.split(","));

        return list;

    } // end  
    
    
    //==========================================================================
    public static String getJSONError(String error) {

        if (error == null || error.length() < 1) {
            error = "unexpected error";
        }

        return "{\"error\":\"" + error + "\"}";
    }

} // end class
