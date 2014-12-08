package com.example.products;

import java.io.IOException;
import com.example.products.ShowProductsController;
import com.example.model.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/* MainApp.java - The main Java source file.
 * 
 * Includes all of the calls to everything that compiles the program.
 * 
 * Project includes source from other people:
 * https://github.com/farrukh-obaid/javafx-skins/tree/master/src/MistSilver
 */
public class MainApp extends Application {
   
 //=========================== VARIABLES ============================//
   private Stage primaryStage;
   // Must match the pane type in the .fxml
   private AnchorPane rootLayout;
   
   //Declare list that displays employees
   private ObservableList<Product> products = FXCollections.observableArrayList();
   
   //============================ CONSTRUCTORS ========================//
   
   // Default constructor
   public MainApp() {
      products.add(new Product("Bonsai Tree", "40","$23.95","Get it for your desk!"));
      products.add(new Product("Apple Tree", "23","$56.00","Yields in 5-15 years."));
      products.add(new Product("Shrub","10","$12","Great for hiding things in."));
      products.add(new Product("Rose Bush", "278","$78.50","Treat your lady."));
   }
   
   // Getter for the list of products
   public ObservableList<Product> getProductList() {
      return products;
   }
   
   public void initRootLayout() {
      try {
         // Load layout from .fxml file
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("/com/example/view/ProductsOverview.fxml"));
         rootLayout = (AnchorPane) loader.load();
         
         //Give controller access to the main app
         ShowProductsController controller = loader.getController();
         controller.setMainApp(this);
         
         // Show scene containing the root layout
         Scene scene = new Scene(rootLayout);
         primaryStage.setScene(scene);
         primaryStage.show();
         
      } catch(IOException e) { e.printStackTrace();}
   }
   
   public Stage getPrimaryStage () {
      return primaryStage;
   }
   
	@Override
	public void start(Stage primaryStage) {
	   this.primaryStage = primaryStage;
      this.primaryStage.setTitle("The Garden Store");
      initRootLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
