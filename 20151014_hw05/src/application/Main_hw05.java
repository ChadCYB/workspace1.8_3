/* 文字編輯器(存取檔案功能) */
package application;
	
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main_hw05 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = getClass().getResource("hw05_Scene.fxml");
			BorderPane pane = FXMLLoader.load(url);
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("103021076 陳奕呈 HW05");
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
