package DBpr;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import com.sun.javafx.collections.ImmutableObservableList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import DBpr.Item;






public class Controller extends Application {
	
	
	

	
	
	   @Override
	    public void start(Stage stage) throws Exception {
	      //  Parent root = FXMLLoader.load(getClass().getResource("Itemscene.fxml"));
	        Parent root2 = FXMLLoader.load(getClass().getResource("orderlinescene.fxml"));
	        
	      //  Scene scene = new Scene(root);
	        Scene scene1 = new Scene(root2);
	        //stage.setScene(scene);
	        stage.setScene(scene1);
	        stage.show();
	    }

	  
	    public static void main(String[] args) {
	        launch(args);
	    } 


}