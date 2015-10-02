package application;
import java.net.URL;

/*	Author: ³¯«³§e
 * 	Student ID: 103021076
 * 	Date: 2015/09/30
 * 	Uses: JavaFX µøµ¡½m²ß(ComboBox)
 *  Java JDK: 1.8
 */
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    try{
        // constructing our scene
        URL url = getClass().getResource("MainScene1.fxml");
        BorderPane pane = FXMLLoader.load( url );
        Scene scene = new Scene( pane );
        
        // setting the stage
        primaryStage.setScene( scene );
        primaryStage.setTitle( "103021076 ³¯«³§e" );
        primaryStage.setX(200);
        primaryStage.setY(100);
        primaryStage.show();
    }catch (Exception ex){
    	ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}