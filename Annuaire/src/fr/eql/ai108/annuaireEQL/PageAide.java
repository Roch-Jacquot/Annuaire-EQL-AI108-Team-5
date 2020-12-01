package fr.eql.ai108.annuaireEQL;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PageAide {

	public static void display(String title, String message) {
		
		Stage fenetre = new Stage();
		
		Label aide1 = new Label("Cliquer sur Interface Administrateur pour accéder aux fonctions administrateurs");
		Label aide2 = new Label("Cliquer sur Annuaire pour accéder à la liste des stagiaires");
		Label aide3 = new Label("Cliquer sur connexion pour entrer ses identifiants administrateurs");
		
		VBox aide = new VBox(10);
		aide.getChildren().addAll(aide1, aide2, aide3);
		aide.setAlignment(Pos.TOP_LEFT);
		
		Scene help = new Scene(aide);
		fenetre.setScene(help);
		fenetre.show();
		
		
	}
}
