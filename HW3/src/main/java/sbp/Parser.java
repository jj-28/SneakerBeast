/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jeffrey
 */
public class Parser {
//    HttpServletRequest rq;
String jsonResponse;

public Parser() {
//   br= r;
}
public String parseBody(BufferedReader br) throws IOException {
//   BufferedReader br= rq.getReader();
     String contents = null;
            StringBuilder con = new StringBuilder();
//            BufferedReader reader = request.getReader();
            String ln;
            while ((ln = br.readLine()) != null) {
                con.append(ln);
            }
            br.close();
            jsonResponse= con.toString();
            contents =jsonResponse;         
            if (contents != null) return contents;
            else return "null";
}
}
