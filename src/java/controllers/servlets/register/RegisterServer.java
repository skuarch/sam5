package controllers.servlets.register;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.Server;
import model.beans.ServerType;
import model.common.BroadcastMessage;
import model.common.ModelServerType;
import model.common.ModelServers;
import model.util.JSONUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Register a new Server.
 * @author skuarch
 */
@WebServlet(name = "registerServer", urlPatterns = {"/registerServer"})
public class RegisterServer extends HttpServlet {

    private static final Logger logger = Logger.getLogger(RegisterServer.class);
    private String remoteHost = null;
    private String jsonString = null;

    //==========================================================================
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out =null;
        JSONObject jsono = null;
        String[] fields = {"name", "ip", "port", "type", "status", "description"};        
        String name;
        String ip;
        int port;
        int type;
        int status;
        String description;
        Server server = null;
        ServerType st = null;

        try {

            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            remoteHost = request.getRemoteHost();
            jsonString = request.getHeader("register");
            
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


            name = jsono.getString("name");
            ip = jsono.getString("ip");
            port = jsono.getInt("port");
            type = jsono.getInt("type");
            status = jsono.getInt("status");
            description = jsono.getString("description");
            st = ModelServerType.getServerTypeById(type);

            //check if server already exists
            server = ModelServers.getServer(name);

            if (server == null) {

                //create the new server
                server = new Server();
                server.setIp(ip);
                server.setName(name);
                server.setPort(port);
                server.setStatus(status);
                server.setDescription(description);
                server.setServerType(st);
                ModelServers.createServer(server);

                //send message to all clients
                response.getWriter().println(new ActionSupport().getText("server.new"));
                BroadcastMessage.sendMessage(new ActionSupport().getText("server.new"));

            } else {

                //server already exists
                response.getWriter().println("the server '" + jsono.getString("name") + "' already exists");

            }
            
        } catch (ParseException ex) {
            logger.error(remoteHost, ex);
        } catch (Exception e) {
            logger.error(remoteHost, e);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
