package DBpr;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import javafx.stage.Stage;

public class FXMLcontroller3 implements Initializable {

	
	 java.sql.Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
    @FXML
    private TableColumn<customer, String> addr;

    @FXML
    private TableColumn<customer, String> name;

    @FXML
    private TableColumn<customer, String> phone;

    @FXML
    private TableColumn<customer, String> Cid;

    @FXML
    private TableView<customer> tabel;
    
    @FXML
    private TextField Name;

    @FXML
    private TextField adder;
    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Button butt3;	
    @FXML
    private TextField phonee;
    
    
    
    @FXML
    void addpop(ActionEvent event) throws IOException {
   	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("cusadd.fxml"));
  	  Parent root2=root1.load();
  				// TODO Auto-generated catch block
  				
  			
          	Stage stage = new Stage();
          	stage.setTitle("ADD customer");
          	stage.setScene(new Scene(root2));
          	stage.show();
    }

    
    @FXML
    void Delete_customer(ActionEvent event) throws IOException {
    	 FXMLLoader root1 =new  FXMLLoader(getClass().getResource("cusdelete.fxml"));
     	  Parent root2=root1.load();
     				// TODO Auto-generated catch block
     				
     			
             	Stage stage = new Stage();
             	stage.setTitle("Delete customer");
             	stage.setScene(new Scene(root2));
             	stage.show();

    }

    @FXML
    void updatecus(ActionEvent event) throws IOException {
     	 FXMLLoader root1 =new  FXMLLoader(getClass().getResource("cusupdate.fxml"));
    	  Parent root2=root1.load();
    				// TODO Auto-generated catch block
    				
    			
            	Stage stage = new Stage();
            	stage.setTitle("Update customer");
            	stage.setScene(new Scene(root2));
            	stage.show();
    }
    
	
    
    ObservableList<customer> listM;
    ObservableList<customer> dataList;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		name.setCellValueFactory(new PropertyValueFactory<customer,String>("Cname"));
		addr.setCellValueFactory(new PropertyValueFactory<customer,String>("Cadderes"));
		phone.setCellValueFactory(new PropertyValueFactory<customer,String>("Cphone"));
		Cid.setCellValueFactory(new PropertyValueFactory<customer,String>("Id"));
		listM= connenc.getDatacos();
		tabel.setItems(listM);
		
		
		
	}

}
