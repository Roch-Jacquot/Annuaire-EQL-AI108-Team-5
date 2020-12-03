package fr.eql.ai108.annuaireEQL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InterfaceAdmin extends Application{

	static Stage fenetre;
	static Scene admin;

	public static void display(String title, String message) {
		// TODO Auto-generated method stub

		fenetre = new Stage();

		//Disposition des boutons page utilisateur
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 10, 10, 10));

		//TOP

		Button aide = new Button("Aide");
		aide.setPadding(new Insets(5, 5, 5, 5));
		Button fichier = new Button("Annuaire");
		fichier.setPadding(new Insets(5, 5, 5, 5));

		aide.setOnAction(e -> PageAide.display("Aide", "Didacticiel"));
		fichier.setOnAction(e -> new PopUpAnnuaire(true));
		
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.getChildren().addAll(aide, fichier);
		root.setTop(hbox);
		root.setCenter(new CenterPane("admin"));

		//Page d'accueil = accueil utilisateur

		admin = new Scene(root, 950, 300);
		fenetre.setScene(admin);
		fenetre.setTitle("Page administrateur");
		fenetre.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
