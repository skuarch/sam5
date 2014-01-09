package webservices;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.util.JSONUtilities;
import org.apache.log4j.Logger;

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

        try {

            response.setContentType("application/json;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {

                if (!request.getContentType().equalsIgnoreCase("application/json")) {
                    out.println(JSONUtilities.getJSONError("illegal content type"));
                    return;
                }

                out.print("{\"mocos\":\"mocos\"}");

            }

        } catch (Exception e) {
            logger.error(e);
        }

    } // end doPost

} // end class
