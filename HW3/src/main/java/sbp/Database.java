/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Jeffrey
 */
public class Database {

    private HashMap<String, String> userHm = new HashMap<String, String>();
    static private HashMap<String, Sneaker> sneakerHm = new HashMap<String, Sneaker>();
    private final String filen = "users.ser";
    private final String sfile = "skrhm.ser";
//    private final String snkr2= "snkrlibr.txt";
    String workingDirectory = System.getProperty("user.dir");
    File myin = new File(workingDirectory, filen);

    public boolean addSneaker(Sneaker m) throws ClassNotFoundException {
        if (m != null) {
            this.loadStatus(sfile, sneakerHm);
            sneakerHm.put(m.displayName(), m);
            this.saveStatus(sfile, sneakerHm);
            return true;
        } else {
            return false;
        }
    }
    
        public boolean lookupSneaker(Sneaker m) throws IOException, ClassNotFoundException {
        this.loadStatus(sfile, sneakerHm);
        if (sneakerHm.containsKey((String) m.displayName())) {
            return true;
        } else {
            return false;
        }
    }
    

    public void saveStatus(String s, HashMap hm) {
        try {
            FileOutputStream saveFile = new FileOutputStream(s);
            ObjectOutputStream out = new ObjectOutputStream(saveFile);
            out.writeObject(hm);
            out.close();
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStatus(String s, HashMap hm) throws ClassNotFoundException {
//   HashMap<String,String> result = null;
        try {
            FileInputStream saveFile = new FileInputStream(s);

            ObjectInputStream in = new ObjectInputStream(saveFile);
            hm = (HashMap<String, String>) in.readObject();
            in.close();
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//    return result;
    }
//
//    public String addNewUser(user u) throws IOException, ClassNotFoundException {
//        this.loadStatus(filen, userHm);
//        if (!userHm.containsKey((String) u.getUsername())) {
//            userHm.put(u.getUsername(), u.getSPassword());
//            String app = "";
//            for (String s : userHm.keySet()) {
//                app += s;
//            }
//            this.saveStatus(filen, userHm);
//            return app;
//        } else {
//            return "fail";
//        }
//    }
//
//    public boolean lookupUser(user u) throws IOException, ClassNotFoundException {
//        this.loadStatus(filen, userHm);
//        if (userHm.containsKey((String) u.getUsername())) {
//
//            return true;
//        } else {
//            return false;
//        }
//    }

    boolean lookupUser(user newUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
