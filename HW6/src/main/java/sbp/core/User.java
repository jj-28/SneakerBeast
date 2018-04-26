package sbp.core;


import java.io.Serializable;
import java.security.Principal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeffrey
 */
public class User implements Principal{
   private String username;

   private String password;
   public User (String name)  {
   
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

    @Override
    public String getName() {
        return username;
    }
}
