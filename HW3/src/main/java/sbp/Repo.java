/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeffrey
 */
//@WebServlet(name = "create", urlPatterns = {"/create"})
public class Repo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        View v = new View(response,request);
        try {
            PrintWriter out = response.getWriter();
            Parser p = new Parser();
            sqlDatabaseController sdb = new sqlDatabaseController();
//            BufferedReader br = request.getReader();
            String body = p.parseBody(request.getReader());
            Gson gson = new Gson();
            Sneaker m = gson.fromJson(body,Sneaker.class);
            if (m != null ) {
                   Boolean b = sdb.insertSneaker(m.displayName(),m.displaypic(),m.releaseDate(),m.displayBrand(),m.displayModel(), m.displaySKU(), m.displayColor(),m.displayItemCondition(),m.displayDescription());
                   if (b)
//                    response.setStatus(HttpServletResponse.SC_CREATED ,"Sneaker: " + m.displayName() + " has been added");
                       v.sneakerAddView(m);
                   else {
//                       response.sendError(HttpServletResponse.SC_NOT_FOUND);
                        v.sendError();
                   }
                    
            }else {
//                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                   v.sendError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
