/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author Jeffrey
 */
@WebFilter
/* 
Filter that check to see if the user is has a session, and has already loggeed in...
If those a rebo
Note: This is only useful for when the user wants to make some sort of request to the SEARCH servlet
(ie: GET request-for getting sneaker info... POST- for writing a new sneaker... etc, etc0
(and if I have time, change their username and password, or delete their account)

*/

public class loginFilter implements Filter {
    
        public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
    throws IOException, ServletException {
//        HttpServletRequest session = (HttpServletRequest) request ;
//        HttpServletResponse res = (HttpServletResponse) response;
////        Boolean checkStatus =(Boolean) session.getSession().getAttribute("isLoggedIn");
////        if (session.getSession(false)==null || checkStatus == false) {
//            /*DO NOT do a redirect, because you dont want the request to be POSTed or verbed to the wrong servlet
//             Just do a forbidden
//            
//            */
////            res.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have access to this server.");
//        }else {
//            filterChain.doFilter(request, response);
//           }

    }

    public void destroy() {
    }
}
    

