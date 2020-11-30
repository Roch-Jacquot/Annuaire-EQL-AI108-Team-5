package fr.eql.ai108.annuaireEQL;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpConnexion {

	public static void display(String title, String message) {
		
		Stage fenetre = new Stage();
		Label identifiant = new Label("Identifiant");
		Label motDePasse = new Label("Mot de passe");
		TextField id = new TextField();
		TextField mdp = new TextField();
		Button connexion = new Button("Connexion");
		
		fenetre.initModality(Modality.APPLICATION_MODAL);
		fenetre.setTitle("Connexion");
		fenetre.setMinWidth(250);
		
		VBox vb = new VBox(20);
		vb.getChildren().addAll(identifiant, id, motDePasse, mdp, connexion);
		vb.setAlignment(Pos.CENTER);
		
		Scene login = new Scene(vb);
		fenetre.setScene(login);
		fenetre.showAndWait();
	}
}
