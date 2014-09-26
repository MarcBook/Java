import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Gui extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("JavaFX");
		
		Image image = new Image("http://bc01.rp-online.de/polopoly_fs/1.4087532.1394113726!httpImage/118577339.jpg_gen/derivatives/d950x950/118577339.jpg");
		System.out.println(EditImage.getAverage(image));
		
		Circle circle = new Circle();
		circle.setCenterX(100.0f);
		circle.setCenterY(100.0f);
		circle.setRadius(50.0f);
		circle.setFill(EditImage.getAverage(image));
		
		StackPane root = new StackPane(); 
		root.getChildren().add(circle);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
