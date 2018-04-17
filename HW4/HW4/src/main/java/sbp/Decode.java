/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Base64;

/**
 *
 * @author Jeffrey
 */
public class Decode {

    public static boolean getCred(String cv, sqlDatabaseController sqldb) throws IOException, SQLException {
        if (cv != null && cv.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = cv.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            String[] values = credentials.split(":", 2);
            String username = values[0];
            String password = values[1];
            String res = sqldb.valLogin(username, password);
            if (res.equals("valid")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
