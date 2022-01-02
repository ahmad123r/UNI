package DBpr;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author amir
 */
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
    
}
