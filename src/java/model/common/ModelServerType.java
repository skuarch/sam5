package model.common;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.ServerType;
import model.dao.DAO;

/**
 * Business logic for ServerType.
 *
 * @author skuarch
 */
public class ModelServerType {

    private static ConcurrentHashMap parameters = new ConcurrentHashMap();

    //==========================================================================
    /**
     * this class doesn't need a public constructor.
     */
    private ModelServerType() {
    } // end ModelServerType

    //==========================================================================
    /**
     * return a ServerType or null.
     *
     * @param id long
     * @return ServerType or null
     * @throws Exception
     */
    public static ServerType getServerTypeById(long id) throws Exception {

        if (id < 0) {
            throw new IllegalArgumentException("id is incorrect");
        }

        ServerType st = null;
        List<ServerType> list = null;

        parameters.clear();
        parameters.put("id", String.valueOf(id));
        list = new DAO().query("getServerTypeById", parameters, new ServerType());

        if (list == null) {
            st = null;
        } else {
            st = list.get(0);
        }

        return st;

    } // end getServerTypeById

    //==========================================================================
    /**
     * return a ServerType or null.
     *
     * @param name String
     * @return ServerType or null
     * @throws Exception
     */
    public static ServerType getServerTypeByName(String name) throws Exception {

        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("name is incorrect");
        }


        ServerType st = null;
        List<ServerType> list = null;

        parameters.clear();
        parameters.put("name", name);
        list = new DAO().query("getServerTypeByName", parameters, new ServerType());

        if (list == null) {
            st = null;
        } else {
            st = list.get(0);
        }

        return st;

    } // end getServerTypeByName
} // end class