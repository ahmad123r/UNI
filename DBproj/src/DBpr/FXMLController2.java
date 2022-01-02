package DBpr;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
   
    
    java.sql.Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public void Add_Order (){    
        conn = connenc.ConnectDb();
        String sql = "INSERT INTO order_line (NO_order,  Id, Qan) VALUES (?,?,?)";
        		
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, order.getText());
            //pst.setString(2, name.getText());
            pst.setString(2, id.getText());
           // pst.setString(4, price.getText());
            pst.setString(3, qan.getText());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "order Add succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void Delete_Order (){    
        conn = connenc.ConnectDb();
        String sql = "DELETE FROM order_line WHERE (NO_order = ?) and (Id = ?)";
        		
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, order.getText());
            //pst.setString(2, name.getText());
            pst.setString(2, id.getText());
           // pst.setString(4, price.getText());
           
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "order Delete succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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