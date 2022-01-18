package DBpr;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addItemcont implements Initializable {

	@FXML
    private ComboBox<Integer> id;
	
    final ObservableList<Integer> list1 = FXCollections.observableArrayList();
	   
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
            pst.setInt(2, id.getValue());
           // pst.setString(4, price.getText());
            pst.setString(3, qan.getText());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "order Add succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }
    
    
    
    
    public void update_Order (){    
        conn = connenc.ConnectDb();
        String sql = "UPDATE order_line SET Qan = ? WHERE (NO_order = ?) and (Id = ?)";
        		
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(2, order.getText());
            //pst.setString(2, name.getText());
            pst.setInt(3, id.getValue());
           // pst.setString(4, price.getText());
            pst.setString(1, qan.getText());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "order Update succes");
           
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
            pst.setInt(2, id.getValue());
           // pst.setString(4, price.getText());
           
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "order Delete succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void Delete1_Order (){    
        conn = connenc.ConnectDb();
        String sql = "DELETE FROM order_line WHERE (NO_order = ?) ";
        		
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, order.getText());
         
           
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "order Delete succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println();
		
		String sql="SELECT Id FROM item";
		 
		 conn = connenc.ConnectDb();
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				list1.add(rs.getInt("Id"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list1.get(1));
		
		for(int i =0; i<list1.size();i++) {
id.getItems().add(list1.get(i));

	}
		
	}

}
