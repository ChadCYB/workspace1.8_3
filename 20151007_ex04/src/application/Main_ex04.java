package application;
/*	Author: 陳奕呈
 * 	Student ID: 103021076
 * 	Date: 2015/10/08
 * 	Uses: JavaFX 視窗練習(Listener運用)
 *  Java JDK: 1.8
 */
import java.io.IOException;
import java.net.*;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyEvent;

public class Main_ex04 extends Application {
	boolean goNorth, goSouth, goEast, goWest, goBig, goSmall;
	int dx = 200, dy = 100, h = 500, w = 400;
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = getClass().getResource("ex04_Scene.fxml");
			BorderPane pane;
			pane = FXMLLoader.load(url);
			Scene scene = new Scene(pane);
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                switch (event.getCode()) {
	                    case UP:
	                    	goNorth = true; break;
	                    case DOWN:
	                    	goSouth = true; break;
	                    case LEFT:
	                    	goWest  = true; break;
	                    case RIGHT:
	                    	goEast  = true; break;
	                    case ADD:
	                    	goBig  = true; break;
	                    case SUBTRACT:
	                    	goSmall  = true; break;
	                    default:
	                    	System.out.println(event.getCode());
	                    	break;
	                }
	            }
	        });

	        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                switch (event.getCode()) {
	                    case UP:
	                    	goNorth = false; break;
	                    case DOWN:
	                    	goSouth = false; break;
	                    case LEFT:
	                    	goWest = false; break;
	                    case RIGHT:
	                    	goEast = false; break;
	                    case ADD:
	                    	goBig = false; break;
	                    case SUBTRACT:
	                    	goSmall = false; break;
	                    default:
	                }
	            }
	        });
	        AnimationTimer timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	            	
	                if (goNorth) dy -= 1;
	                if (goSouth) dy += 1;
	                if (goEast)  dx += 1;
	                if (goWest)  dx -= 1;
	                if (goBig){
	                	h += 1;
	                	w += 1;
	                }
	                if (goSmall){
	                	h -= 1;
	                	w -= 1;
	                }
	                if(dx <= 0) dx = 0;
	                if(dy <= 0) dy = 0;
	                
	                primaryStage.setX(dx);
	    	        primaryStage.setY(dy);
	    	        primaryStage.setHeight(h);
	    	        primaryStage.setWidth(w);
	            }
	        };
	        timer.start();
			primaryStage.setScene(scene);
			primaryStage.setTitle( "103021076 陳奕呈 EX04" );
//	        primaryStage.setX(200);
//	        primaryStage.setY(100);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
