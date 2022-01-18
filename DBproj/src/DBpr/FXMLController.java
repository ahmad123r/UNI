package DBpr;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.sun.jdi.connect.spi.Connection;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class FXMLController implements Initializable {
	

    @FXML
    private TableColumn<Item, String> item_id;

    @FXML
    private TableColumn<Item, String> item_name;

    @FXML
    private TableColumn<Item, String> item_price;

    @FXML
    private TableView<Item> item_table;
    
    @FXML
    private TextField Id;


    
 
    
    
    @FXML
 public   void ahmad(ActionEvent event) throws IOException {
  	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("additem.fxml"));
  	  Parent root2=root1.load();
  				// TODO Auto-generated catch block
  				

          	Stage stage = new Stage();
          	stage.setTitle("ADD new Item");
          	stage.setScene(new Scene(root2));
          	stage.show();
          	

    }
    @FXML
    void delo(ActionEvent event) throws IOException {
   	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("Deleteitem1.fxml"));
  	  Parent root2=root1.load();
  				// TODO Auto-generated catch block
  				
  			
          	Stage stage = new Stage();
          	stage.setTitle("Delete  Item");
          	stage.setScene(new Scene(root2));
          	stage.show();
    }

    @FXML
    void update(ActionEvent event) throws IOException {
   	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("updateitem.fxml"));
  	  Parent root2=root1.load();
  				// TODO Auto-generated catch block
  				
  			
          	Stage stage = new Stage();
          	stage.setTitle("Update Item");
          	stage.setScene(new Scene(root2));
          	stage.show();

    }

    
    


 
    
    

    
    ObservableList<Item> listM;
    ObservableList<Item> dataList;
   int index = -1;
    
    java.sql.Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	//connenc
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		item_name.setCellValueFactory(new PropertyValueFactory<Item,String>("Iname"));
		item_id.setCellValueFactory(new PropertyValueFactory<Item,String>("Id"));
		item_price.setCellValueFactory(new PropertyValueFactory<Item,String>("price"));
		listM= connenc.getDataItem();
		item_table.setItems(listM);
	}
	

}
