package model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.Server;
import model.dao.DAO;

/**
 * Business logic for Server
 *
 * @author skuarch
 */
public class ModelServers {

    private static ConcurrentHashMap parameters = new ConcurrentHashMap();

    //==========================================================================
    /**
     * this class doesn't need a public constructor.
     */
    private ModelServers() {
    } // end ModelServers

    //==========================================================================
    /**
     * return an ArrayList<Server>.
     */
    public static ArrayList<Server> getServers() throws Exception {

        ArrayList<Server> servers = null;
        servers = new DAO().getArrayList(new Server());

        if (servers == null || servers.size() < 1) {
            servers = new ArrayList();
        }

        return servers;

    } // end getServers    

    //==========================================================================
    /**
     * return a Server or null.
     *
     * @param id Server id
     * @return Server or null
     * @throws Exception
     */
    public static Server getServer(long id) throws Exception {

        if(id < 1){
            throw new IllegalArgumentException("id is less than 1");
        }
        
        Server server = null;
        server = new DAO().get(id, new Server());
        return server;

    } // end getServer

    //==========================================================================
    /**
     * return a Server or null.
     *
     * @param serverName String
     * @return Servers or null
     * @throws Exception
     */
    public static Server getServer(String serverName) throws Exception {

        if (serverName == null || serverName.length() < 1) {
            throw new IllegalArgumentException("serverName is incorrect");
        }

        parameters.clear();
        parameters.put("name", serverName);
        List list = new DAO().query("getServerByName", parameters, new Server());
        Server server = null;

        if (list == null || list.size() < 1) {
            server = null;
        } else {
            server = (Server) list.get(0);
        }

        return server;

    } // end getServer

    //==========================================================================
    /**
     * return a Server or null.
     *
     * @param ip String
     * @param typeName String name of serverType
     * @return Server or null
     * @throws Exception
     */
    public static Server getServerByIp(String ip, String typeName) throws Exception {

        if (ip == null || ip.length() < 0 || typeName == null || typeName.length() < 1) {
            throw new IllegalArgumentException("the arguments are incorrect");
        }

        Object object = null;
        Server server = null;

        parameters.clear();
        parameters.put("ip", ip);
        parameters.put("typeName", typeName);

        object = new DAO().query("getServersByIp", parameters).get(0);

        if (object == null) {
            server = null;
        } else {
            server = (Server) object;
        }

        return server;

    } // end getServerByName

    //==========================================================================
    /**
     * check if the server exists in the db.
     *
     * @param serverName String
     * @return boolean
     * @throws Exception
     */
    public static boolean existsServer(String serverName) throws Exception {

        if (serverName == null || serverName.length() < 0) {
            throw new IllegalArgumentException("server name is null or empty");
        }

        boolean flag = false;
        List list = null;

        parameters.clear();
        parameters.put("name", serverName);
        list = new DAO().query("getServerByName", parameters, new Server());

        if (list == null || list.size() < 1) {
            flag = false;
        } else {
            flag = true;
        }

        return flag;
    } // end existsServer
    
    //==========================================================================
    /**
     * create a server in the database.
     * @param server Server
     * @return long id of the new server
     */
    public static long createServer(Server server) throws Exception {
    
        return new DAO().create(server);
        
    } // end createServer
    
} // en class