package sbp;

/*
This servlet is meant to manage how users access database
Users make a post request to the servlet in xml, and if the user exists in the db, they are
given an authorization token.
 */
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 *
 * @author Jeffrey
 */
//@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json;charset=UTF-8");
        View v = new View(response, request);
        try {
            Parser p = new Parser();
            String body = p.parseBody(request.getReader());
            Gson gson = new Gson();
            user newUser = gson.fromJson(body, user.class);
            sqlDatabaseController sdbc = new sqlDatabaseController();
            String cred= sdbc.valLogin(newUser.getUsername(), newUser.getSPassword());
            if (cred.equals((String) "invalid") == true) {
                v.sendError();
            } else {
                Cookie ck=  new Cookie("auth", cred);
                response.addCookie(ck);
                response.getStatus();
//                v.LoginCreationView();
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
