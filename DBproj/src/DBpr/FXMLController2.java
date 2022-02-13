package DBpr;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;



import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLController2 implements Initializable {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
    @FXML
    private TableColumn<order_line, Integer> idcol;
    @FXML
    private TableColumn<Item, String> namecol;
    @FXML
    private TableColumn<Item, String> pricecol;

    

    @FXML
    private TableColumn<order_line, Integer> ordercol;

 

    @FXML
    private TableColumn<order_line, Integer> qancol;

    @FXML
    private TableView<order_line> table;
	
    @FXML
    private TextField id;
   
    @FXML
    private TextField order;
    @FXML
    private TextField qan;
   
    

    
    
    
    @FXML
    void popadd(ActionEvent event) throws IOException {
   	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("orderadd.fxml"));
  	  Parent root2=root1.load();
  				// TODO Auto-generated catch block
  				
  			
          	Stage stage = new Stage();
          	stage.setTitle("ADD Order");
          	stage.setScene(new Scene(root2));
          	stage.show();

    }
    
    @FXML
    void orderdel(ActionEvent event) throws IOException {
    	  FXMLLoader root1 =new  FXMLLoader(getClass().getResource("orderdel.fxml"));
      	  Parent root2=root1.load();
      				// TODO Auto-generated catch block
      				
      			
              	Stage stage = new Stage();
              	stage.setTitle("DELETE Order ");
              	stage.setScene(new Scene(root2));
              	stage.show();
    }
    
    @FXML
    void orderup(ActionEvent event) throws IOException {
    	 FXMLLoader root1 =new  FXMLLoader(getClass().getResource("orderupdate.fxml"));
     	  Parent root2=root1.load();
     				// TODO Auto-generated catch block
     				
     			
             	Stage stage = new Stage();
             	stage.setTitle("UPDATE Order");
             	stage.setScene(new Scene(root2));
             	stage.show();
    }
    
    
    @FXML
    void delall(ActionEvent event) throws IOException {
   	 FXMLLoader root1 =new  FXMLLoader(getClass().getResource("orderall.fxml"));
	  Parent root2=root1.load();
				// TODO Auto-generated catch block
				
			
        	Stage stage = new Stage();
        	stage.setTitle("DElETE Order");
        	stage.setScene(new Scene(root2));
        	stage.show();
    }
    
  
    
    
	
    ObservableList<order_line> listM;
    ObservableList<order_line> dataList;
   int index = -1;
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	ordercol.setCellValueFactory(new PropertyValueFactory<order_line,Integer>("NO_order"));
	qancol.setCellValueFactory(new PropertyValueFactory<order_line,Integer>("Qan"));
	namecol.setCellValueFactory(new PropertyValueFactory<Item,String>("Iname"));
	pricecol.setCellValueFactory(new PropertyValueFactory<Item,String>("price"));
	idcol.setCellValueFactory(new PropertyValueFactory<order_line,Integer>("Id"));

	listM= orderconn.getDataorder_line();
	table.setItems(listM);
	}
	



}