package fr.eql.ai108.transition;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FirstPan root = new FirstPan();
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premiere transition");
		primaryStage.sizeToScene();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
