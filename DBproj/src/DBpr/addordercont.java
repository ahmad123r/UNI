package DBpr;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addordercont implements Initializable {
	 @FXML
	    private TextField Iname;
	    @FXML
	    private TextField price;

	    @FXML
	    private TextField id;
	    
	    @FXML
	    private Button hhh;
	    

	    java.sql.Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
	    public void Add_users (){    
	        conn = connenc.ConnectDb();
	        String sql = "INSERT INTO item (Iname, price) VALUES(?,?) ";
	        try {
	            pst = conn.prepareStatement(sql);
	     
	            pst.setString(1, Iname.getText());
	            pst.setString(2, price.getText());
	           
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
	        	 pst.setString(1,id.getText());
	            pst.execute();
	            
	            JOptionPane.showMessageDialog(null, "Item Delete succes");
	           
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	    }
	    //UPDATE `db_project`.`item` SET `Iname` = 'rado', `price` = '30' WHERE (`Id` = '2');
	    public void Update_item (){    
	        conn = connenc.ConnectDb();
	        
	       
	        String sql = "UPDATE item SET Iname = ?, price = ? WHERE (Id = ?)";
	        try {
	          
	        	pst = conn.prepareStatement(sql);
	        	 pst.setString(3,id.getText());
	        	 pst.setString(1, Iname.getText());
		            pst.setString(2, price.getText());
	            pst.execute();
	            
	            JOptionPane.showMessageDialog(null, "Item Update succes");
	           
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
