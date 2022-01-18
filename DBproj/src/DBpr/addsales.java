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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class addsales implements Initializable{


	java.sql.Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
	    @FXML
	    private TextField cus;
	  

	    @FXML
	    private TextField date;

	 
	   // private TextField order;
	    @FXML
	    private Button upd;
	  final ObservableList<Integer> list1 = FXCollections.observableArrayList();
	    @FXML
	    private ComboBox<Integer> order;
	    
	  


	    
	   public void Add_Order () throws SQLException{  
	
		   order_line mn= new order_line();
		  
		   order.setId(mn.getId());
	        conn = connenc.ConnectDb();
	      //  String sql = "INSERT INTO saels_oreder (NO_order, Cid, ODate) VALUES (?, ?,?)";
	        String sql=" INSERT INTO saels_oreder (NO_order, Cid, ODate) VALUES (?, ?, ?)";
	        
	        

	        		
	        
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(1, order.getValue());
	            //pst.setString(2, name.getText());
	            pst.setString(2, cus.getText());
	           // pst.setString(4, price.getText());
	            pst.setString(3, date.getText());
	           
	            pst.execute();
	            
	            JOptionPane.showMessageDialog(null, "order Add succes");
	           
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	       
	        
	    }
	   
	   
	
	   
	 
	   
	   
	   public void Delte_Order (){    
	        conn = connenc.ConnectDb();
	      //  String sql = "INSERT INTO saels_oreder (NO_order, Cid, ODate) VALUES (?, ?,?)";
	        String sql=" DELETE FROM saels_oreder WHERE (NO_order = ?)";
	        
	        
	       

	        		
	        
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(1, order.getValue());
	        System.out.println(order.getValue());
	            pst.execute();
	            
	            JOptionPane.showMessageDialog(null, "order Delete succes");
	           
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	       
	        
	    }
	   
	   public void update_Order (){    
	        conn = connenc.ConnectDb();
	      //  String sql = "INSERT INTO saels_oreder (NO_order, Cid, ODate) VALUES (?, ?,?)";
	        String sql=" UPDATE saels_oreder SET Cid = ?, ODate = ? WHERE (NO_order =?)";
	        
	        

	        		
	        
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(3, order.getValue());
	            //pst.setString(2, name.getText());
	            pst.setString(1, cus.getText());
	           // pst.setString(4, price.getText());
	            pst.setString(2, date.getText());
	           
	            pst.execute();
	            
	            JOptionPane.showMessageDialog(null, "order update succes");
	           
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	       
	        
	    }
	   
	   public void tot() {
		   
		   order_line mn= new order_line();
		   Item item=new Item();
		   System.out.println(item.getId()+"><><><><><><");
		   
		   
	   }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cus.setText("1");
		tot();
		String sql="SELECT NO_order FROM order_line GROUP BY NO_order ORDER BY NO_order";
		 
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
				list1.add(rs.getInt("NO_order"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list1);
		for(int i =0; i<list1.size();i++) {
order.getItems().add(list1.get(i));

		}
	}
	   
	   
	   
	   
	   
	   

	  

	   
}
