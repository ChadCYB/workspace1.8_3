package application;
/*	Author: ³¯«³§e
 * 	Student ID: 103021076
 * 	Date: 2015/09/16
 * 	Uses: JavaFX µøµ¡½m²ß
 *  Java JDK: 1.8
 */
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    
    // constructing our scene
    URL url = getClass().getResource("HelloWorldScene.fxml");
    AnchorPane pane = FXMLLoader.load( url );
    Scene scene = new Scene( pane );
    
    
    // setting the stage
    primaryStage.setScene( scene );
    primaryStage.setTitle( "Hello World 103021076" );
    primaryStage.setX(249);
    primaryStage.setY(135);
    primaryStage.show();
    
  }

  public static void main(String[] args) {
    launch(args);
  }
}