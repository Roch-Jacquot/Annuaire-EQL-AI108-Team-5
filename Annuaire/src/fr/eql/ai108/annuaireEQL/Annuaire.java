package fr.eql.ai108.annuaireEQL;

import java.io.File;

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
		//Cr�ation du fichier de sauvegarde s'il n'existe pas
		File f = new File(resultatFinal);
		
		if(!f.exists()) { 
			FileFormator ff = new FileFormator(path, resultat);
			ff.FinalFileFormator(resultat, resultatFinal);
		}
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
		
		
		
		
		aide.setOnAction(e -> PageAide.display("Aide", "Didacticiel"));
		fichier.setOnAction(e -> new PopUpAnnuaire(false));
		connexion.setOnAction(e -> PopUpConnexion.display("Identifiez-vous", "Connexion"));
	

		//Page d'accueil = accueil utilisateur
		
		accueilUtil = new Scene(root, 300, 300);
		fenetre.setScene(accueilUtil);
		fenetre.setTitle("Annuaire stagiaires AI");
		fenetre.show();

	}

}
