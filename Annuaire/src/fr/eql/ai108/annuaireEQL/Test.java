package fr.eql.ai108.annuaireEQL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		CenterPane centerPane = new CenterPane("");
		
		BorderPane root = new BorderPane(centerPane);
		root.setCenter(centerPane);
		
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("TestTableau");
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
