package DBpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class orderconn {
	
	 Connection conn = null;
	    public static Connection ConnectDb(){
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project","root","root");
	           // JOptionPane.showMessageDialog(null, "Connection Established");
	            return conn;
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	        }
	    
	    }
	    
	    public static ObservableList<order_line> getDataorder_line(){
	        Connection conn = ConnectDb();
	        ObservableList<order_line> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = conn.prepareStatement("SELECT NO_order,item.Iname,item.Id,item.price,Qan FROM order_line,item where order_line.Id=item.Id");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new order_line( rs.getInt(1),rs.getString(3), rs.getString(2), rs.getString(4), rs.getInt(5)));               
	            } 
	        } catch (Exception e) {
	        }
	        return list;
	    }

}
