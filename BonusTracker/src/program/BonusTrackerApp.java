package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BonusTrackerApp extends Application {

	 @Override
	    public void start(Stage primaryStage) {
	        try {	
	
	        	FXMLLoader loader = new FXMLLoader(getClass().getResource("view/WelcomeScreen.fxml"));
	            Parent root = loader.load();
	            
	            
	            primaryStage.setTitle("Bonus Tracker");
	            primaryStage.setScene(new Scene(root, 900, 700));
	            primaryStage.show();
	        } catch (IOException e) { 
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	

}
