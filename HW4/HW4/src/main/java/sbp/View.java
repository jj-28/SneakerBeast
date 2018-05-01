/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.util.ArrayList;

/**
 *
 * @author Jeffrey
 */
public class View {
    
    public static String returnSneakerMessage(String snkrName) {
       return "{ message' : 'sneaker " + snkrName + " was created' }";
    }
    public static String createSneakerJSON(String app) {
        return app;
    }
    public static String successMessage() {
        return "{'message': 'success'}";
    }
    public static String genericError(String x) {
        return x;
    }
}
