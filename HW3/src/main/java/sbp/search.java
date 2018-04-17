package sbp;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeffrey
 */

/*takes a single query from the user, and outputs it in text
*/
//@WebServlet("/search")
public class search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        View v = new View(response,request);
                try {
                    response.setContentType("application/json");
        PrintWriter out = response.getWriter();
            String app="";
            ArrayList<Sneaker> sneakerArr;
            Parser p = new Parser();
            sqlDatabaseController sdb = new sqlDatabaseController();
            String body = p.parseBody(request.getReader());
            Gson gson = new Gson();
            Query q= gson.fromJson(body,Query.class);
//            out.println(q.getModelQuery());
//            out.println(body);
            if (!sdb.searchSneaker(q).isEmpty())  {
            sneakerArr= sdb.searchSneaker(q);       
            for (Sneaker m : sneakerArr) {
                app +=gson.toJson(m) + " ";
            }
           v.sneakerDisplay(app);
//            response.setStatus(HttpServletResponse.SC_FOUND);
//            out.println(app);
            }else {
//                response.sendError(HttpServletResponse.SC_NOT_FOUND, "the desired sneaker(s) could not be found. Check your search parameters and try again");
            v.sendError();
            }
    }catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
