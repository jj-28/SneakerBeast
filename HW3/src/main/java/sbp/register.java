package sbp;

/*
This servlet adds users to the database.
Credentials are spplied via a post request to the servlet, 
and an authorization token is given 
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import javax.servlet.http.Cookie;

//@WebServlet("/register")
public class register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                "{'response' : 'You need to do a POST request in order to log in'}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            View v = new View(response, request);
            response.setContentType("application/json;charset=UTF-8");
//            if (request.getSession(false) == null) {
                sqlDatabaseController sqldb = new sqlDatabaseController();
                Parser p = new Parser();               
                String body = p.parseBody(request.getReader());
                Gson gson = new Gson();
                //deserialize json string into a user object
                user newUser = gson.fromJson(body, user.class);
                String d = sqldb.addNewUser(newUser.getUsername(), newUser.getSPassword());
                //add sql statements to take uuid from sql user table and store value in cookie
               
                if (d.equals("success")) {
                    response.setStatus(HttpServletResponse.SC_CREATED);
                    HttpSession newSess = request.getSession();
                    newSess.setAttribute("isloggedIn", (boolean) false);
                   }else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "{'error': 'an error has occured in the response body. Please cheack and try again'}");
                }

        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
