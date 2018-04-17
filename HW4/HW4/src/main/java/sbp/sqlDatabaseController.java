/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.sql.*;
//import com.mysql.jdbc.Driver;
/**
 *
 * @author Jeffrey
 */
import java.util.UUID;
import java.util.ArrayList;

public class sqlDatabaseController {

    private Connection connect = null;
    private PreparedStatement stmt = null;
    private ResultSet r = null;

    public sqlDatabaseController() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mywebapp?useSSL=false", "myuser", "xxxx");
    }

    public Boolean authenticate (String au) throws SQLException {
       String query= "SELECT * from 'users' where ID=?";
      stmt =connect.prepareStatement(query);
       stmt.setString(1, au);
       r = stmt.executeQuery();
       if (r.getString("ID").equals(au)) {
           return true;
       } else {
           return false;
       }
    }
    public ArrayList searchSneaker(Query k) throws SQLException {
        ArrayList<Sneaker> snkList = new ArrayList<Sneaker>();
        String queryParam;
        String type;
        if (k.getBrand() != null) {
            queryParam = k.getBrand();
            type= "brand";
                    String quer = "SELECT * " + "from `sneakers` where " + type + "=?";
                    stmt= connect.prepareStatement(quer);
                    stmt.setString(1, queryParam);
                    r= stmt.executeQuery();
        while (r.next()) {
                String name = r.getString("name");
                String image = r.getString("image");
                String brand = r.getString("brand");
                String releaseDate = r.getString("releaseDate");
                String model = r.getString("model");
                String sku = r.getString("sku");
                String color = r.getString("color");
                String itemCondition = r.getString("itemCondition");
                String description = r.getString("description");
                Sneaker s = new Sneaker();
                s.setBrand(brand);
                s.setName(name);
                s.setColor(color);
                s.setDescription(description);
                s.setPic(image);
                s.setSKU(sku);
                s.setreleaseDate(releaseDate);
                s.setModel(model);
                s.setItemCondition(itemCondition);
                snkList.add(s);
                
           }
            return snkList;
        }
        else if (k.getSKUQuery() != null) {
            queryParam = k.getSKUQuery();
            type= "sku";
                    String quer = "SELECT * " + "from `sneakers` where " + type + "=?";
                    stmt= connect.prepareStatement(quer);
                    stmt.setString(1, queryParam);
                    r= stmt.executeQuery();
        while (r.next()) {
                String name = r.getString("name");
                String image = r.getString("image");
                String brand = r.getString("brand");
                String releaseDate = r.getString("releaseDate");
                String model = r.getString("model");
                String sku = r.getString("sku");
                String color = r.getString("color");
                String itemCondition = r.getString("itemCondition");
                String description = r.getString("description");
                Sneaker s = new Sneaker();
                s.setBrand(brand);
                s.setName(name);
                s.setColor(color);
                s.setDescription(description);
                s.setPic(image);
                s.setSKU(sku);
                s.setreleaseDate(releaseDate);
                s.setModel(model);
                s.setItemCondition(itemCondition);
                snkList.add(s);
           }
            return snkList;
        }
        else if (k.getModelQuery() != null) {
            queryParam = k.getModelQuery();
            type= "brand";
                    String quer = "SELECT * " + "from `sneakers` where " + type + "=?";
                    stmt= connect.prepareStatement(quer);
                    stmt.setString(1, queryParam);
                    if (stmt.executeQuery()!=null) 
                    r= stmt.executeQuery();
        while (r.next()) {
                String name = r.getString("name");
                String image = r.getString("image");
                String brand = r.getString("brand");
                String releaseDate = r.getString("releaseDate");
                String model = r.getString("model");
                String sku = r.getString("sku");
                String color = r.getString("color");
                String itemCondition = r.getString("itemCondition");
                String description = r.getString("description");
                Sneaker s = new Sneaker();
                s.setBrand(brand);
                s.setName(name);
                s.setColor(color);
                s.setDescription(description);
                s.setPic(image);
                s.setSKU(sku);
                s.setreleaseDate(releaseDate);
                s.setModel(model);
                s.setItemCondition(itemCondition);
                snkList.add(s);
           }
            return snkList;
        } else {
//    else {
     return null;   
    }
    }

    public Boolean insertSneaker(String name, String image, String releasedate, String brand,
            String model, String SKU, String color, String itemCond, String description) throws SQLException {
        String quer = "INSERT into `sneakers` (`name`, `image`, `releaseDate`,"
                + "`brand`, `model`, `sku`, `color`, `itemCondition`, `description`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        stmt = connect.prepareStatement(quer);
        stmt.setString(1, name);
        stmt.setString(2, image);
        stmt.setString(3, releasedate);
        stmt.setString(4, brand);
        stmt.setString(5, model);
        stmt.setString(6, SKU);
        stmt.setString(7, color);
        stmt.setString(8, itemCond);
        stmt.setString(9, description);
try{
        int res = stmt.executeUpdate();
        if (res > 0) {
            connect.close();
            return true;
        } else {
            connect.close();
            return false;
        }
        
                    } catch (SQLIntegrityConstraintViolationException e) {
               return false;
            }

    }

    /*
    NOT WORKING RIGHT NOW...
    Need to handle case where duplicate usernames have been added 
     */
    public String addNewUser(String usn, String pssw) throws SQLException {
        String checkDup = "SELECT `username` from `users` where username= ?";
        stmt = connect.prepareStatement(checkDup);
        stmt.setString(1, usn);

        Boolean mm = stmt.execute();
        if (mm == false) {
            connect.close();
            return "already exists";
        } else {
            UUID u1 = UUID.randomUUID();
            String id = u1.toString();
            String quer = "insert into `users` (`username`, `password`, `id`) VALUES (?, ?, ?) ";
            stmt = connect.prepareStatement(quer);
            stmt.setString(1, usn);
            stmt.setString(2, pssw);
            stmt.setString(3, id);
            try{
            int returnv = stmt.executeUpdate();
            
            if (returnv > 0) {
                connect.close();
                return "success";
            } else {
                connect.close();
                return "failed";
            }
            } catch (SQLIntegrityConstraintViolationException e) {
               return "duplicates";
            }
        }
        
    }

    /*
    Times out when post requests are being made. I have no idea how to fix it,
    besides deleting and starting over from scratch...
     */
    public String valLogin(String usn, String pssw) throws SQLException {
        String lookup = "SELECT `username`, `password` from `users` where username=? and password=? ";
        stmt = connect.prepareStatement(lookup);
        stmt.setString(1, usn);
        stmt.setString(2, pssw);
        r = stmt.executeQuery();
        if (!r.next()) {
            connect.close();
            return "invalid";
        } else {
//            String id=r.getString("id");
            connect.close();
//            return "valid";
            return "valid";
        }
    }
    

}
