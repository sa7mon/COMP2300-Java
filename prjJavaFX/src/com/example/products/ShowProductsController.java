package com.example.products;

import com.example.model.Product;

import employee.mainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ShowProductsController
{
//Connect the .fxml table and table columns to this code
   
   @FXML
   private TableView<Product> employeeTable;
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
      firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
      lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
   }
   
   // Called by the main application to give a reference to itself
   public void setMainApp (mainApp mainApp) {
      this.mainApp = mainApp;
      employeeTable.setItems(mainApp.getEmployeeData());
   }
}
