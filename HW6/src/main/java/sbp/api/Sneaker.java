package sbp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import jersey.repackaged.com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.Length;

//Representation class for a sneaker
@Entity
@Table(name = "sneakers")
@NamedQueries({
    @NamedQuery(name = "sbp.Sneaker.getAllSneakers",
            query = "select s from Sneaker s"),

    @NamedQuery(name = "Sneaker.findByBrand",
            query = "select s from Sneaker s "
            + "where s.brand like :brand "),

    @NamedQuery(name = "Sneaker.findByName",
            query = "select s from Sneaker s "
            + "where s.name like :name "),

    @NamedQuery(name = "Sneaker.findBySku",
            query = "select s from Sneaker s "
            + "where s.sku like :sku"),

    @NamedQuery(name = "Sneaker.findById",
            query = "select s from Sneaker s "
            + "where s.id like :id "),
})

public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @NotNull
    @Length(min = 0, max = 2050)
    @Column(name = "image", nullable = false)
    
    private String image;
    @NotNull
    @Column(name = "releaseDate", nullable = false)
    
    private String releaseDate;
    @NotNull
    @Column(name = "brand", nullable = false)
    
    private String brand;
    @NotNull
    @Column(name = "model", nullable = false)
    
    private String model;
    @NotNull
    @Column(name = "sku", unique = true, nullable = false)
    
    private String sku;
    @NotNull
    @Column(name = "color", nullable = false)
    
    private String color;
    @NotNull
    @Column(name = "itemCondition", nullable = false)
    
    private String itemCondition;
    @Length(min = 0, max = 2050)
    @Column(name = "description", nullable = false)
    
    private String description;

    public Sneaker() {

    }

    public Sneaker(String name, String image, String releaseDate, String brand, String model, String sku, String color, String itemCondition, String description) {
        this.name = name;
        this.image = image;
        this.releaseDate = releaseDate;
        this.brand = brand;
        this.model = model;
        this.sku = sku;
        this.color = color;
        this.itemCondition = itemCondition;
       this.description = description;

    }

    @JsonProperty
    public void setId(long r) {
        id = r;
    }

    @JsonProperty("id")
    public long returnId() {
        return id;
    }

    @JsonProperty("image")
    public String displayImage() {
        return image;
    }

    @JsonProperty("name")
    public String displayName() {
        return name;
    }

    @JsonProperty("brand")
    public String displayBrand() {
        return brand;
    }

    @JsonProperty("releaseDate")
    public String displayReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("model")
    public String displayModel() {
        return model;
    }

    @JsonProperty("sku")
    public String displaySKU() {
        return sku;
    }

    @JsonProperty("color")
    public String displayColor() {
        return color;
    }

    @JsonProperty("itemCondition")
    public String displayItemCondition() {
        return itemCondition;
    }

    @JsonProperty("description")
    public String displayDescription() {
        return description;
    }

    @JsonProperty
    public String setImage(String n) {
        image = n;
        return image;
    }

    @JsonProperty
    public String setName(String n) {
        name = n;
        return name;
    }

    @JsonProperty
    public String setBrand(String n) {
        return brand = n;
    }

    @JsonProperty
    public String setModel(String n) {
        return model = n;
    }

    @JsonProperty
    public String setSKU(String n) {
        return sku = n;
    }

    @JsonProperty
    public String setColor(String n) {
        return color = n;
    }

    @JsonProperty
    public String setItemCondition(String n) {
        return itemCondition = n;
    }

    @JsonProperty
    public String setDescription(String n) {
        return description = n;
    }

    @JsonProperty
    public String setreleaseDate(String n) {
        return releaseDate = n;
    }

//    @Override
//    public String toString () {
//        return MoreObjects.toStringHelper(this)
//                .add("brand", brand)
//                .add("name", name)
//                .add("image", image)
//                .add("releaseDate", releaseDate)
////                .brand
////        brand = brn;
////        model = mod;
////        sku= sk;
////        color = clr;
////        itemCondition= ic;
////        description = dn;
//                .toString();
//    }
    
}

