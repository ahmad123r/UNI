package DBpr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class addcus1 {
	  @FXML
	    private TextField Name;

	    @FXML
	    private TextField adder;

	    @FXML
	    private TextField id;

	    @FXML
	    private TextField phonee;
	    
	    java.sql.Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
    public void Add_cos (){    
        conn = connenc.ConnectDb();
        String sql = "INSERT INTO customer (Cname, Cadderes, Cphone) VALUES (?, ?, ?)";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, Name.getText());
            pst.setString(2, adder.getText());
            pst.setString(3, phonee.getText());
           
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Customer Add succes");
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

}
