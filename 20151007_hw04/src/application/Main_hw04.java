package application;
/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/10/08
 * 	Uses: JavaFX 簡易計算機(事件觸發運用)
 *  Java JDK: 1.8
 */
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main_hw04 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = getClass().getResource("hw04_Scene.fxml");
			BorderPane pane = FXMLLoader.load(url);
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("103021076 陳奕呈 HW04");
			primaryStage.setX(200);
			primaryStage.setY(100);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
