package fr.eql.ai108.annuaireEQL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class PopUpConnexion {

	
	public static void display(String title, String message) {
		
		Stage popup = new Stage();
		GridPane fenetre = new GridPane();
		Label identifiant = new Label("Identifiant");
		GridPane.setConstraints(identifiant, 0, 0);
		Label motDePasse = new Label("Mot de passe");
		GridPane.setConstraints(motDePasse, 1, 0);
		TextField id = new TextField();
		GridPane.setConstraints(id, 0, 1);
		TextField mdp = new TextField();
		GridPane.setConstraints(mdp, 1, 1);
		Button connexion = new Button("Connexion");
		GridPane.setConstraints(connexion, 1, 2);
		
		connexion.setOnAction(e -> System.out.println(id.getText()));
		connexion.setOnAction(e -> System.out.println(mdp.getText()));
		
		fenetre.setPadding(new Insets(10, 10, 10, 10));
		fenetre.setVgap(8);
		fenetre.setHgap(10);
		
		fenetre.getChildren().addAll(identifiant, motDePasse, id, mdp, connexion);
		
		Scene scene = new Scene(fenetre, 300, 200);
		popup.setScene(scene);
		popup.show();
		
	}
}
