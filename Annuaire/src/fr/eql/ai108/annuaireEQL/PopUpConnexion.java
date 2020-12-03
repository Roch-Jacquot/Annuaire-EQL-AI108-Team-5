package fr.eql.ai108.annuaireEQL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PopUpConnexion {

	
	public static void display(String title, String message) {
		
		String user = "admineql";
		String pw = "admin123";

		
		Stage popup = new Stage();
		GridPane fenetre = new GridPane();
		final Label identifiant = new Label("Identifiant");
		GridPane.setConstraints(identifiant, 0, 0);
		final Label motDePasse = new Label("Mot de passe");
		GridPane.setConstraints(motDePasse, 1, 0);
		final TextField id = new TextField();
		GridPane.setConstraints(id, 0, 1);
		final TextField mdp = new TextField();
		GridPane.setConstraints(mdp, 1, 1);
		Button connexion = new Button("Connexion");
		GridPane.setConstraints(connexion, 1, 2);
		Label messageConnexion = new Label();
		
		//Actions du bouton connexion
		

		
		fenetre.setPadding(new Insets(10, 10, 10, 10));
		fenetre.setVgap(8);
		fenetre.setHgap(10);
		
		fenetre.getChildren().addAll(identifiant, motDePasse, id, mdp, connexion);
		
		Scene scene = new Scene(fenetre, 300, 200);
		popup.setScene(scene);
		popup.show();
		
		connexion.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String checkId = id.getText();
				String checkMdp = mdp.getText();

				if(checkId.equals(user) && checkMdp.equals(pw)) {
					InterfaceAdmin.display("Fenêtre admin", "Bravo"); 
					messageConnexion.setText("Bravo");
					messageConnexion.setTextFill(Color.GREEN);;
					
				}
				else {
					messageConnexion.setText("identifiant/mot de passe incorrect");
					messageConnexion.setTextFill(Color.RED);
				}
				id.setText("");
				mdp.setText("");
			}
		});
		
	}
}
