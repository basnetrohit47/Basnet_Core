package fr.epita.basnet.business;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import fr.epita.basnet.datamodel.User_Identity;
import fr.epita.basnet.services.Dao;
import fr.epita.basnet.validation.Validation;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * this class is to get the data from user and pass it to DAO class 
 * @author basnet
 *
 */
public class DataAction implements Initializable { 

    @FXML TableView<User_Identity>table;
    @FXML private TableColumn<?,?>name;
    @FXML private TableColumn<?,?>age;
    @FXML private TableColumn<?,?>number;
    @FXML private TableColumn<?,?>email;
    @FXML private TableColumn<?,?>id;
    @FXML private TextField txtname;
    @FXML private TextField txtage;
    @FXML private TextField txtnumber;
    @FXML private TextField txtemail;
    @FXML private TextField txtid;
    
    @FXML private Label lblmsg;
    Dao dao=new Dao(); 
    /**
     * this methods display the all the data from tbluser table
     * @throws SQLException
     */
    public void display() throws SQLException{
    	ObservableList<User_Identity>data;
    	data=dao.ShowAll();
    	table.setItems(data);  	
    }
     
    /**
     * this create method help to insert data in table 
     * it gets data from user input and send or pass it to insert method of DAO class
     * @throws SQLException
     */
    public void create() throws SQLException{
    	
    	
    	if(Validation.validempty(txtname, txtage, txtnumber, txtemail)
    			&Validation.validage(txtage)&Validation.validname(txtname)
    			&Validation.validnumber(txtnumber)&Validation.validemail(txtemail)
    			&Validation.validid(txtid)){
    		
    	User_Identity identity=new User_Identity(txtname.getText(),
    			Long.parseLong(txtnumber.getText()),
    			txtemail.getText(),
    			Integer.parseInt(txtage.getText()),
    			Integer.parseInt(txtid.getText()));
    	dao.Insert(identity);
    	}
    	else{

    		Alert alert =new Alert(AlertType.WARNING);
    		alert.setTitle("validation");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter valid input: please click on help for input instruction");
    		alert.showAndWait();
    	}
    	
    }
    /**
     * this method pass the name value that user input to delete method of DAO class
     * 
     * @throws SQLException
     */
    public void delete() throws SQLException{
    if(Validation.validid(txtid)){
    	User_Identity identity=new User_Identity(null, 0, null, 0,Integer.parseInt(txtid.getText()));
    	dao.delete(identity);
    }
    else{

		Alert alert =new Alert(AlertType.WARNING);
		alert.setTitle("validation");
		alert.setHeaderText(null);
		alert.setContentText("Please Enter valid input: please click on help for input instruction");
		alert.showAndWait();
	}
    }
   /**
    * this update method pass all the value from text field to update method of DAO class
    * @throws SQLException
    */
    public void update() throws SQLException{
    	
    	
    	if(Validation.validempty(txtname, txtage, txtnumber, txtemail)
    			&Validation.validage(txtage)&Validation.validname(txtname)
    			&Validation.validnumber(txtnumber)&Validation.validemail(txtemail)
    			&Validation.validid(txtid)){

    	User_Identity identity=new User_Identity(txtname.getText(), 
    			Long.parseLong(txtnumber.getText()),
    			txtemail.getText(),
    			Integer.parseInt(txtage.getText()),Integer.parseInt(txtid.getText()));
    	        dao.Update(identity);	
    	}
    	else{

    		Alert alert =new Alert(AlertType.WARNING);
    		alert.setTitle("validation");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Enter valid input: please click on help for input instruction");
    		alert.showAndWait();
    	}
    }
    /**
     * this method initialize is to initialize table column from database 
     */
   	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		number.setCellValueFactory(new PropertyValueFactory<>("number"));
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		
	}
    
   	/**
   	 * this methods help is to display the help dialog box where user can find the instruction   	 
   	 * to input the data in text field
   	 * @throws IOException
   	 */
	public void help() throws IOException{
		Parent root=FXMLLoader.load(getClass().getResource("/fr/epita/basnet/business/Help.fxml"));
  		Stage primaryStage =new Stage();
        Scene scene = new Scene(root,500,300);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
}
