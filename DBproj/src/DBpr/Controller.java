package DBpr;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;






public class Controller extends Application {
	
	public static Stage stage = new Stage();
	public  Scene scene1;
	
	public  Parent root2;
	

	
	
	   @Override
	    public void start(Stage stage1) throws Exception {
		 
	      // Parent root2 = FXMLLoader.load(getClass().getResource("Itemscene.fxml"));
	       //Parent root2 = FXMLLoader.load(getClass().getResource("orderlinescene.fxml"));
		  // Parent root2 = FXMLLoader.load(getClass().getResource("customerscene.fxml"));
		  //Parent root2 = FXMLLoader.load(getClass().getResource("salesorder.fxml"));
		    root2 = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		    stage=stage1;
	        
	      //  Scene scene = new Scene(root);
	         scene1 = new Scene(root2);
	        //stage.setScene(scene);
	        stage.setScene(scene1);
	        stage.show();
	    }
	  
	  
	  
	    public static void main(String[] args) {
	    	
	        launch(args);
	    } 


}