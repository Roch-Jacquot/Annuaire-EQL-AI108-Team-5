package fr.eql.ai108.annuaireEQL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InterfaceAdmin extends Application{

	Stage fenetre;
	Scene admin;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		fenetre = primaryStage;

		//Disposition des boutons page utilisateur
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 10, 10, 10));

		//TOP

		Button aide = new Button("Aide");
		aide.setPadding(new Insets(5, 5, 5, 5));
		Button fichier = new Button("Annuaire");
		fichier.setPadding(new Insets(5, 5, 5, 5));
		Button connexion = new Button("Connexion");

		aide.setOnAction(e -> PageAide.display("Aide", "Didacticiel"));
		fichier.setOnAction(e -> new PopUpAnnuaire());

		//Page d'accueil = accueil utilisateur

		admin = new Scene(root, 300, 300);
		fenetre.setScene(admin);
		fenetre.setTitle("Annuaire stagiaires AI");
		fenetre.show();
	}

}
