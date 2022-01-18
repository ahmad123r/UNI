package DBpr;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


public class connenc {
    
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
    
    public static ObservableList<Item> getDataItem(){
        Connection conn = ConnectDb();
        ObservableList<Item> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Item");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Item(rs.getString("Id"), rs.getString("Iname"), rs.getString(3)));               
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<customer> getDatacos(){
        Connection conn = ConnectDb();
        ObservableList<customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new customer(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(1)));               
            }
        } catch (Exception e) {
        	System.out.println("hel yeah");
        }
        return list;
    }
    
    public static ObservableList<saels_oreder> getDatasales(){
    	 Connection conn = ConnectDb();
         ObservableList<saels_oreder> list = FXCollections.observableArrayList();
         try {
             PreparedStatement ps = conn.prepareStatement("select saels_oreder.NO_order, SUM(item.price * order_line.Qan) as Total ,saels_oreder.Cid,saels_oreder.ODate\r\n"
             		+ " from item,saels_oreder ,order_line \r\n"
             		+ " where item.Id=order_line.Id and order_line.NO_order=saels_oreder.NO_order\r\n"
             		+ " GROUP BY NO_order");
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){   
                 list.add(new saels_oreder(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4)));               
             }
         } catch (Exception e) {
         	System.out.println("hel yeah");
         }
         return list;
    }
    
}
