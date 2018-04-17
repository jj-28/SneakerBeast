/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

/**
 *
 * @author Jeffrey
 */
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
//import javax.servlet.http.HttpServletResponse;
import spark.Spark;
import static spark.Spark.*;

public class Main {

    public static final int SC_NOT_FOUND = 404;
    public static final int SC_BAD_REQUEST = 400;
    public static final int SC_UNAUTHORIZED = 401;
    public static final int SC_OK = 200;
    public static final int SC_NO_CONTENT = 204;
    public static final int SC_CREATED = 201;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        post("/register", (request, response) -> {
            sqlDatabaseController sqldb = new sqlDatabaseController();
            Gson gson = new Gson();
            user newUser = gson.fromJson(request.body(), user.class);
            String ex = sqldb.addNewUser(newUser.getUsername(), newUser.getSPassword());
//                response.status();
            if (ex.equals("success")) {
                response.status(SC_CREATED);
                return View.successMessage();
            } else {
                response.status(SC_BAD_REQUEST);
                return View.genericError(ex);
            }
        });

        post("/create", (request, response) -> {
            sqlDatabaseController sqldb = new sqlDatabaseController();
            Gson gson = new Gson();
            Sneaker m = gson.fromJson(request.body(), Sneaker.class);
            if (m != null) {
                Boolean b = sqldb.insertSneaker(m.displayName(), m.displaypic(), m.releaseDate(), m.displayBrand(), m.displayModel(),
                        m.displaySKU(), m.displayColor(), m.displayItemCondition(), m.displayDescription());
                if (b) {
                    response.status(SC_CREATED);
                    //return method that displays json string
                    return View.returnSneakerMessage(m.displayName());
                } else {
                    //conflict with unique fields defined in the sqltable, such as sku and name 
                    response.status(SC_BAD_REQUEST);
                    return "";
                }
            } else {
                //sneaker was null due to bad json provided, etc.
                response.status(SC_BAD_REQUEST);
                return "";
            }

        });
        post("/search", (request, response) -> {
            sqlDatabaseController sdb = new sqlDatabaseController();
//            String body = p.parseBody(request.getReader());
            Gson gson = new Gson();
            String app = "";
            Query q = gson.fromJson(request.body(), Query.class);
            if (!sdb.searchSneaker(q).isEmpty()) {
                ArrayList<Sneaker> sneakerArr;
                sneakerArr = sdb.searchSneaker(q);
                for (Sneaker m : sneakerArr) {
                    app += gson.toJson(m) + " ";
                }
                response.status(SC_OK);
                return View.createSneakerJSON(app);
            } else {
                response.status(SC_UNAUTHORIZED);
            }
            return "";
        });

        before("/search", (request, response) -> {
           sqlDatabaseController sqldb = new sqlDatabaseController();
            String hd= request.headers("Authorization");
            if (Decode.getCred(hd,sqldb)== false ) {
                halt(SC_UNAUTHORIZED, "{login to continue}");
            }
        });
        
                before("/create", (request, response) -> {
           sqlDatabaseController sqldb = new sqlDatabaseController();
            String hd= request.headers("Authorization");
            if (Decode.getCred(hd,sqldb)== false ) {
                halt(SC_UNAUTHORIZED, "{login to continue}");
            }
        });

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

    }

}
