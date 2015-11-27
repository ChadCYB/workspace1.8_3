/* 簡易文字編輯器 */
package application;
	
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main_ex05 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = getClass().getResource("ex05_Scene.fxml");
			BorderPane pane = FXMLLoader.load(url);
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("103021076 陳奕呈 EX05");
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
