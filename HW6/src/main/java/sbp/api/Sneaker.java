package main.java.sbp.api;

import com.fasterxml.jackson.*;

public class Sneaker {
    private String name;
    private String image;
    private String releaseDate;
    private String brand;
    private String model;
    private String sku;
    private String color;
    private String itemCondition;
    private String description;


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

