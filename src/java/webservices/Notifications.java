package webservices;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.NoSuchElementException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.common.BroadcastMessage;
import model.util.IOUtilities;
import model.util.JSONUtilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author skuarch
 */
@WebServlet(name = "Notifications", urlPatterns = {"/notifications"})
public class Notifications extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Notifications.class);

    //==========================================================================
    /**
     * Processes requests<code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = null;
        response.setContentType("application/json;charset=UTF-8");
        JSONObject jsono = null;

        try {
            
            if (!request.getContentType().equalsIgnoreCase("application/json")) {
                logger.error("illegal content type", new Exception());
                out.println(JSONUtilities.getJSONError("illegal content type"));
                return;
            }

            if (request.getContentLength() < 1) {
                //nothing to read
                logger.error("nothing to read", new Exception());
                return;
            }

            jsono = new JSONObject(readContent(request));            
            
            BroadcastMessage.sendMessage(jsono.getString("description"));

            out = response.getWriter();
            out.print("{\"received\":\"true\"}");

        } catch (IOException | ParseException | NoSuchElementException e) {
            logger.error("doPost", e);
        } finally {
            IOUtilities.closePrintWriter(out);
        }

    } // end doPost

    //==========================================================================
    private String readContent(HttpServletRequest request) {

        int contentLenght = 0;
        ServletInputStream sis = null;
        byte[] buffer = null;
        int len;
        String string = null;

        try {

            contentLenght = request.getContentLength();
            sis = request.getInputStream();
            buffer = new byte[contentLenght];
            len = sis.readLine(buffer, 0, buffer.length);

            string = new String(buffer, 0, len);

        } catch (Exception e) {
            IOUtilities.closeInputStream(sis);
        }

        return string;

    } // end readContent

} // end class
