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
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class View {
HttpServletResponse resp;
HttpServletRequest req;
public View (HttpServletResponse hsresponse, HttpServletRequest hsrequest) {
   resp= hsresponse;
   req= hsrequest;
   
}    
//
//public void userCreationView(String d) throws IOException {
//                    if (d.equals("success")) {
//                    resp.setStatus(HttpServletResponse.SC_CREATED);
//                    HttpSession newSess = req.getSession();
//                    newSess.setAttribute("isloggedIn", (boolean) false);
//                   }else {
//                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "{'error': 'an error has occured in the response body. Please cheack and try again'}");
//                }
//}
//public void sendError() throws IOException {
//    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "you have already made an account. Check again");
//}
//public void sneakerDisplay(String app) {
//                resp.setStatus(HttpServletResponse.SC_FOUND, app);
//}
//public void LoginCreationView() {
//                resp.setStatus(HttpServletResponse.SC_CONTINUE);
//}
//public void invalidCredentials() throws IOException {
//    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"You have not created an account yet. Create one before continuing.");
//}
//public void sneakerAddView(Sneaker m) {
//    resp.setStatus(HttpServletResponse.SC_CREATED ,"Sneaker: " + m.displayName() + " has been added");
//}

}
