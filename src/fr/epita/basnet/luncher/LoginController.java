package fr.epita.basnet.luncher;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * this class is to login authentication
 * @author basnet
 *
 */

public class LoginController {
	
	@FXML private Label lblstatus;
	@FXML private TextField txtuser;
	@FXML private TextField txtpass;
	
	/**
	 * this is the login authentication method
	 * @return it returns true if username and password is correct 
	 * and get access to DataAction if username and password does not match then it return false 
	 * and show message in the label
	 * @throws IOException
	 */
	public boolean login() throws IOException{
		
		if(txtuser.getText().equals("rohit")&& txtpass.getText().equals("basnet")){
			Parent root=FXMLLoader.load(getClass().getResource("/fr/epita/basnet/business/DataAction.fxml"));
	  		Stage primaryStage =new Stage();
	        Scene scene = new Scene(root,600,500);
	        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();		
			return true;
		}
		else{
			lblstatus.setText("Please Enter the correct username and password");
			return false;
		}
	}
	
	}

