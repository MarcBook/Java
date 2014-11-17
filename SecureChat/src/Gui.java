import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Gui extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Secure Chat");
		
		StackPane root = new StackPane();
		root.getChildren().addAll();
		primaryStage.setScene(new Scene(root, 300, 500));
		primaryStage.show();
	}

}
