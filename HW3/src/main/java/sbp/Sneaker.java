/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

import java.util.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.annotations.Expose;
/**
 *
 * @author Jeffrey
 */
public class Sneaker {
@Expose
private String name;
@Expose
private String image;
@Expose
private String releaseDate;
@Expose
private String brand;
@Expose
private String model;
@Expose
private String sku;
@Expose
private String color;
@Expose
private String itemCondition;
@Expose
private String description;
//HashMap sizeInfo = new  <String, ArrayList> HashMap();

public Sneaker() {
    
}

public String displaypic() {
    return image; 
}
public String displayName (){
    return name;
}
public String displayBrand (){
    return brand;
}
public String releaseDate() {
    return releaseDate;
}

public String displayModel (){
    return model;
}
public String displaySKU (){
    return sku;
}
public String displayColor (){
    return color;
}
public String displayItemCondition (){
    return itemCondition;
}
public String displayDescription (){
    return description;
}


public String setPic(String n) {
    image = n;
    return image;
}
public String setName (String n){
    name = n;
    return name;
}
public String setBrand (String n){
    return brand = n;
}

public String setModel (String n){
    return model= n;
}
public String setSKU (String n){
    return sku = n;
}
public String setColor (String n){
    return color= n;
}
public String setItemCondition (String n){
    return itemCondition = n;
}
public String setDescription (String n){
    return description= n;
}
public String setreleaseDate(String n) {
    return releaseDate = n;
}
}
