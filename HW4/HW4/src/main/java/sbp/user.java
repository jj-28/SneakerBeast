package sbp;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeffrey
 */
public class user implements Serializable{
    @Expose
   private String username;
    @Expose
   private String password;
   public user ()  {
   }
   public void setPassword(String p) {
       password= p;
   }
      public void setUsername(String u) {
          username= u;
   }
   
    public String getUsername () {
        return username;
    }
        public String getSPassword () {
        return password;
    }
        public String toString(){
            return username + "," + password;
        }
}
