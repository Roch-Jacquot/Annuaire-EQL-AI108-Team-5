package fr.eql.ai108.annuaireEQL;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CenterPane extends VBox {


	//Utilisateur
	private Text textIntroUser = new Text("Bienvenu dans l'application de gestion des stagiaires en formation chez L'AFCEPF/EQL.\nCette application a pour but de faciliter "
			+ "la gestion la gestion et l'archivage des stagiaires étant ou ayant été en formation dans l'organisme.");
	
	private Text textExplicationUser = new Text("Le bouton \"Aide\" permet d'obtenir des informations complémentaires sur les fonctions disponibles.\n"
			+ "Le bouton \"Connexion\" permet de se connecter à l'interface administrateur\nLe bouton \"Annuaire\" permet de lancer l'affichage du tableau contenant l'annuaire et d'accéder aux"
			+ "fonctions associées.");

	
	
	//Administrateur
	private Text textIntroAdmin = new Text("Bienvenu dans la section administrateur de l'application.\nCette fenêtre a pour but de donner au gestionnaire la capacité de modifier la base de données"
			+ " des stagiaires plus en profondeur.");
	private Text textExplicationAdmin = new Text("En plus de pouvoir accéder aux fonctionnalités utilisateurs, "
			+ "l'administrateur peut effacer ou modifier un stagiaire de la base de données à partir de l'annuaire.");
	
	
	
	
	public CenterPane(String user) {
		super();
		
		if(user == "admin") {
			textIntroAdmin.setFont(Font.font (15));
			textExplicationAdmin.setFont(Font.font (15));
			getChildren().add(textIntroAdmin);
			getChildren().add(textExplicationAdmin);
			
		} else {
			textIntroUser.setFont(Font.font (15));
			textExplicationUser.setFont(Font.font (15));
			getChildren().add(textIntroUser);
			getChildren().add(textExplicationUser);
		}
			
		setPrefSize(1000, 500);
		setStyle("-fx-background-color:beige");
		
		
		
	}
	
	
	

}
