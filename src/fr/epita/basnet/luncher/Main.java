package fr.epita.basnet.luncher;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * this is the main class to lunch the program
 * @author basnet
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 Parent root=FXMLLoader.load(getClass().getResource("/fr/epita/basnet/luncher/Login.fxml"));
	  		
		        Scene scene = new Scene(root,600,500);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	    	  
		} catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {    
		launch(args);
	}
}
