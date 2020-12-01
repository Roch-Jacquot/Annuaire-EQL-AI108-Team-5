package fr.eql.ai108.annuaireEQL;

import classes.utilitaires.FileFormator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Annuaire extends Application {	


	Stage fenetre;
	Scene accueilUtil, accueilAdmin;
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



		Button interfaceAdmin = new Button("Interface Administrateur");
		Button interfaceUtil = new Button("Retour à l'interface utilisateur");
		Button aide = new Button("Aide");
		Button fichier = new Button("Annuaire");

		interfaceAdmin.setOnAction(e -> fenetre.setScene(accueilAdmin));
		interfaceUtil.setOnAction(e -> fenetre.setScene(accueilUtil));

		//Disposition des boutons page utilisateur
		HBox hb = new HBox(15);
		hb.getChildren().addAll(aide ,interfaceAdmin, fichier);
		accueilUtil = new Scene(hb, 305, 200);
		aide.setOnAction(e -> PageAide.display("Aide", "Didacticiel"));
		fichier.setOnAction(e -> new PopUpAnnuaire());

		//Bouton 2
		Button aide2 = new Button("Aide");
		Button fichier2 = new Button("Annuaire");
		Button connexion = new Button("Connexion");
		connexion.setOnAction(e -> PopUpConnexion.display("Connexion administrateur", "Entrer identifiants"));
		aide2.setOnAction(e -> PageAide.display("Aide", "Didacticiel"));
		fichier2.setOnAction(e -> new PopUpAnnuaire());

		//Disposition page admin
		HBox hb2 = new HBox(15);
		hb2.getChildren().addAll(aide2 ,interfaceUtil, fichier2, connexion);
		accueilAdmin = new Scene(hb2, 305, 200);

		//Page d'accueil = accueil utilisateur
		fenetre.setScene(accueilUtil);
		fenetre.setTitle("Annuaire stagiaires AI");
		fenetre.show();

	}

}
