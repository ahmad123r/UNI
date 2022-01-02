package DBpr;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.sun.jdi.connect.spi.Connection;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class FXMLController implements Initializable {
	public static void main(String[] args) {
		Application.launch(args);
	}

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
    private TextField Iname;
    @FXML
    private TextField price;
    
    public void Add_users (){    
        conn = connenc.ConnectDb();
        String sql = "INSERT INTO item (Iname, Id, price) VALUES(?,?,?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Id.getText());
            pst.setString(2, Iname.getText());
            pst.setString(3, price.getText());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Users Add succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void Delete_users (){    
        conn = connenc.ConnectDb();
        
       
        String sql = "DELETE FROM item WHERE (Id =?)";
        try {
          
        	pst = conn.prepareStatement(sql);
        	 pst.setString(1, Iname.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Item Delete succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
