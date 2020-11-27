package fr.eql.ai108.annuaireEQL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InterfaceAnnuaire extends Application {
	
	Stage fenetre;
	Scene accueilUtil, accueilAdmin;

	@Override
	public void start(Stage primaryStage) throws Exception {
		fenetre = primaryStage;
		
		
		
		Button interfaceAdmin = new Button("Interface Administrateur");
		Button aide = new Button("Aide");
		Button fichier = new Button("Annuaire");
		
		interfaceAdmin.setOnAction(e -> fenetre.setScene(accueilAdmin));
		
		//Disposition des boutons page utilisateur
		HBox hb = new HBox(30);
		hb.getChildren().addAll(aide ,interfaceAdmin, fichier);
		accueilUtil = new Scene(hb, 200, 200);
		
		//Bouton 2
		Button interfaceUtilisateur = new Button("Retour à l'interface utilisateur");
		Button aide2 = new Button("Aide");
		Button fichier2 = new Button("Annuaire");
		
		//Disposition page admin
		HBox hb2 = new HBox(30);
		hb2.getChildren().addAll(aide2 ,interfaceUtilisateur, fichier2);
		accueilUtil = new Scene(hb2, 200, 200);
		
		//Page d'accueil = accueil utilisateur
		fenetre.setScene(accueilUtil);
		fenetre.setTitle("Annuaire stagiaires AI");
		fenetre.show();
		
	}
	
	
}
