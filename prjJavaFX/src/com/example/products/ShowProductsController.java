package com.example.products;

import com.example.model.Product;
import com.example.products.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ShowProductsController
{
//Connect the .fxml table and table columns to this code
   
   @FXML
   private TableView<Product> productsTable;
   @FXML
   private TableColumn<Product, String> productNameColumn;
   @FXML
   private TableColumn<Product, String> quantityColumn;
   @FXML
   private TableColumn<Product, String> priceColumn;
   @FXML
   private TableColumn<Product, String> descriptionColumn;
   
   // Reference to the main application
   private MainApp MainApp;
   
   //Constructor
   public ShowProductsController() {}
   
   // Initialize the controller class using Java 8 lambdas
   // This will automatically be called after the FXML file is loaded
   @FXML
   private void initialize() {
      productNameColumn.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
      quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
      priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
      descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
   }
   
   // Called by the main application to give a reference to itself
   public void setMainApp (MainApp mainApp) {
      this.MainApp = mainApp;
      productsTable.setItems(mainApp.getProductList());
   }
}
