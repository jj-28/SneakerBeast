/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 *
 * @author Jeffrey
 */
public interface TheInt {
    
@SqlUpdate("create table sneakers ( "
        + "id SERIAL,"
        + "name VARCHAR(250),"
        + "image VARCHAR(300),"
        + "releaseDate VARCHAR (50),"
        + "brand VARCHAR(100),"
        + "model VARCHAR(125),"
        + "sku VARCHAR(125),"
        + "color VARCHAR(50),"
        + "itemCondition VARCHAR(40),"
        + "description VARCHAR(2000)"
        + ")")
  void createSneakerTable();    
 
@SqlUpdate("create table users ("
        + "id SERIAL"
        + "username VARCHAR (20),"
        + "password VARCHAR (16)"
        + ")")  
void createUserTable();
  
@SqlUpdate("INSERT into `sneakers` (`name`, `image`, `releaseDate`,"
                + "`brand`, `model`, `sku`, `color`, `itemCondition`, `description`) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ")
  void insert(@Bind("id") int id, @Bind("name") String name);



}
