package com.example.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Product.java - Contains all the functions and variables related to the Product class.
 * 
 * Will contain setters/getters/constructors.
 * 
 * Created: 12/3/14
 */
public class Product
{

   //============================= Declare variables ===============================//
   private final StringProperty productname;
   private final StringProperty quantity;
   private final StringProperty price;
   private final StringProperty description;
   
   
   //=============================== Constructors =================================//
   
   // Default constructor
   // Number of nulls must match the number of arguments in the following constructor
   public Product () {
      this(null, null,null,null);
   }
   
   public Product (String inProductName, String inQuantity, String inPrice, String inDesc) {
      this.productname = new SimpleStringProperty(inProductName);
      this.quantity = new SimpleStringProperty(inQuantity);
      this.price = new SimpleStringProperty(inPrice);
      this.description = new SimpleStringProperty(inDesc);
   }
   
   //================================ Getters/Setters ==============================//
   
   // Have to add the StringProperty object for every string
   // so that we get added functionality such as listeners on those
   // objects to fire events when the string changes.
   public String getProductName () { return this.productname.get(); }
   public void setProductName(String productName) {this.productname.set(productName);}
   public StringProperty productNameProperty() { return productname; }
   
   public String getQuantity () { return this.quantity.get(); }
   public void setQuantity(String quantity) {this.quantity.set(quantity);}
   public StringProperty quantityProperty() { return quantity; }
   
   public String getPrice () { return this.price.get(); }
   public void setPrice(String price) {this.price.set(price);}
   public StringProperty priceProperty() { return price; }
   
   public String getDescription () { return this.description.get(); }
   public void setDescription(String description) {this.description.set(description);}
   public StringProperty descriptionProperty() { return description; }
   
}
