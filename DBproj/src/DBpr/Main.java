package DBpr;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import DBpr.Item;






public class Main extends Application {
	
	
	
	private ArrayList<Item> data;
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "root";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "db_project";
	private Connection con;
	
	
	

    @Override
    public void start(Stage stage) {
      Parent root = null;
	try {
		root = FXMLLoader.load(getClass().getResource("Itemscene.fxml"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      Scene scene = new Scene(root); 
      stage.setScene(scene);
        stage.show();
    }
    
    
   
    
    
    
    
    

    public static void main(String[] args) {
        launch(args);
    }
    
    private void getData() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String SQL;
		data = new ArrayList<>();
				
		connectDB();
		System.out.println("Connection established");

		SQL = "select * from item";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);


		while ( rs.next() )  {
			//SimpleRecord rd = ;
			data.add(new Item(rs.getString(2),rs.getString(1),rs.getString(3)));
		}
		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + data.size());
		
		
	}


	private void connectDB() throws ClassNotFoundException, SQLException {
		
		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");
	
		con = DriverManager.getConnection (dbURL, p);

	}


}