package application;
import java.net.URL;

/*	Author: �����e
 * 	Student ID: 103021076
 * 	Date: 2015/09/23
 * 	Uses: JavaFX �����m��(BMI�p��)
 *  Java JDK: 1.8
 */
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/* BMI�p���*/
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    try{
        // constructing our scene
        URL url = getClass().getResource("Scene1.fxml");
        AnchorPane pane = FXMLLoader.load( url );
        Scene scene = new Scene( pane );
        
        
        // setting the stage
        primaryStage.setScene( scene );
        primaryStage.setTitle( "103021076 �����e" );
        primaryStage.setX(320);
        primaryStage.setY(240);
        primaryStage.show();
    }catch (Exception ex){
    	ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}