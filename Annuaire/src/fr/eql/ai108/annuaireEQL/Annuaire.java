package fr.eql.ai108.annuaireEQL;

import classes.utilitaires.FileFormator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Annuaire extends Application {	


	Stage fenetre;
	Scene accueilUtil;
	static String path = "stagiaires.txt";
	static String resultat = "MonFichierIntermediaire";
	static String resultatFinal = "MonFichierFinal";

	public static void main(String[] args) {
		//Création d'un fichier intermédiaire avec un stagiaire par ligne
		FileFormator ff = new FileFormator(path, resultat);
		//Création du fichier final
		ff.FinalFileFormator(resultat, resultatFinal);
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
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
		connexion.setPadding(new Insets(5, 5, 5, 5));
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.getChildren().addAll(aide, fichier,connexion);
		root.setTop(hbox);
		
		
		// CENTER
		
		CenterPane centerPane = new CenterPane(path);
		
		
		aide.setOnAction(e -> PageAide.display("Aide", "Didacticiel"));
		fichier.setOnAction(e -> new PopUpAnnuaire());
		connexion.setOnAction(e -> PopUpConnexion.display("Identifiez-vous", "Connexion"));
	

		//Page d'accueil = accueil utilisateur
		
		accueilUtil = new Scene(root, 300, 300);
		fenetre.setScene(accueilUtil);
		fenetre.setTitle("Annuaire stagiaires AI");
		fenetre.show();

	}

}
