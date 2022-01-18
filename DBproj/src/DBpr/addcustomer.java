package DBpr;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class addcustomer implements Initializable{
    @FXML
    private TextField Name;

    @FXML
    private TextField adder;
    @FXML
    private Button butt1;
    @FXML
    private TextField id;
    @FXML
    private Button butt2;

    @FXML
    private Button butt3;	
    @FXML
    private ComboBox<Integer> upd;
    @FXML
    private TextField phonee;
    
    java.sql.Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    final ObservableList<Integer> list1 = FXCollections.observableArrayList();
    
   
    
    public void Delete_customer (){    
        conn = connenc.ConnectDb();
        
       
        String sql = "DELETE FROM customer WHERE (`Cid` = ?)";
        try {
          
        	pst = conn.prepareStatement(sql);
        	 pst.setInt(1, upd.getValue());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "customer Delete succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }}
    
    
    public void update_cos (){    
        conn = connenc.ConnectDb();
        String sql = "UPDATE customer SET Cname = ?, Cadderes = ?, Cphone = ? WHERE (Cid = ?)"
        		+ "";
        
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, Name.getText());
            pst.setString(2, adder.getText());
            pst.setString(3, phonee.getText());
            pst.setInt(4, upd.getValue());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Costmer Update succes");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String sql="SELECT Cid FROM customer";
		 
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
				list1.add(rs.getInt("Cid"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list1.get(1));
		
		for(int i =0; i<list1.size();i++) {
upd.getItems().add(list1.get(i));

	}
		
	}
    

}
