package DBpr;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLController4 implements Initializable{
	
	
    @FXML
    private TableColumn<saels_oreder,Integer> cus;

    @FXML
    private TableColumn<saels_oreder,Date > date;

    @FXML
    private TableColumn<saels_oreder,Integer> orderno;

    @FXML
    private TableView<saels_oreder> tabels;

    @FXML
    private TableColumn<saels_oreder,Integer> total;
    
    
    @FXML
    void salesadd(ActionEvent event) throws IOException, SQLException {
    	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("salesadd.fxml"));
      	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
  
    
      			
              	Stage stage = new Stage();
              	stage.setTitle("Add salesOrder");
              	stage.setScene(new Scene(root2));
              	stage.show();

    }
    
    
    @FXML
    void delelte(ActionEvent event) throws IOException {
    	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("sealsdelete.fxml"));
      	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
      				
      			
              	Stage stage = new Stage();
              	stage.setTitle("Delete salesOrder");
              	stage.setScene(new Scene(root2));
              	stage.show();
    }
    
    @FXML
    void update(ActionEvent event) throws IOException {
    	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("sealsupdate.fxml"));
      	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
      				
      			
              	Stage stage = new Stage();
              	stage.setTitle("Update salesOrder");
              	stage.setScene(new Scene(root2));
              	stage.show();
    }

    
    
    
    ObservableList<saels_oreder> listM;
    ObservableList<saels_oreder> dataList;
   int index = -1;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cus.setCellValueFactory(new PropertyValueFactory<saels_oreder,Integer>("Cid"));
		orderno.setCellValueFactory(new PropertyValueFactory<saels_oreder,Integer>("NO_order"));
		total.setCellValueFactory(new PropertyValueFactory<saels_oreder,Integer>("Total"));
		date.setCellValueFactory(new PropertyValueFactory<saels_oreder,Date>("ODate"));
		listM= connenc.getDatasales();
		System.out.println(listM);
		tabels.setItems(listM);
		
	}

}
