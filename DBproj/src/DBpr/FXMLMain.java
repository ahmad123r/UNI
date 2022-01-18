package DBpr;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLMain implements Initializable{
    @FXML
    void showitem(ActionEvent event) throws IOException {
    	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("Itemscene.fxml"));
      	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
  
    
      			
              	Stage stage = new Stage();
              	stage.setTitle("Item");
              	stage.setScene(new Scene(root2));
              	stage.show();

    }
    
    @FXML
    void pickitems(ActionEvent event) throws IOException {
     	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("orderlinescene.fxml"));
      	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
  
    
      			
              	Stage stage = new Stage();
              	stage.setTitle("orderline");
              	stage.setScene(new Scene(root2));
              	stage.show();
    }

    
    @FXML
    void custo(ActionEvent event) throws IOException {
    	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("customerscene.fxml"));
    	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
  
    
      			
              	Stage stage = new Stage();
              	stage.setTitle("Customers");
              	stage.setScene(new Scene(root2));
              	stage.show();
    }

    @FXML
    void order(ActionEvent event) throws IOException {
  	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("salesorder.fxml"));
  	  Parent root2=root1.load();
    				// TODO Auto-generated catch block

  
    			
            	Stage stage = new Stage();
            	stage.setTitle("SalesOrder");
            	stage.setScene(new Scene(root2));
            	stage.show();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
