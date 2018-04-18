package TripDisplay;


import java.text.ParseException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    
    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {  
        //FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("SearchDisplay.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("SearchDisplay.fxml"));
        //Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
           
}