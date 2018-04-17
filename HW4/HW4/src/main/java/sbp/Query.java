/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp;

/**
 *
 * @author Jeffrey
 */
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class Query implements Serializable{
    @Expose
    private String brand;
    @Expose
    private String sku;
    @Expose
    private String model;
//@Expose 
//private String query;

    
    public Query () {
        
    }
    public String getBrand() {
        return brand;
    }

    public String getSKUQuery() {
        if (sku != null)
        return sku;
        else return null;
    }

    public String getModelQuery() {
        return model;
    }

}
