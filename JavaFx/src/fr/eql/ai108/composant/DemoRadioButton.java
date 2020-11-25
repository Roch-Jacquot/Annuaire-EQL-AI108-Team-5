package fr.eql.ai108.composant;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemoRadioButton extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox(10);
		
		//On instancie RadioButtons
		RadioButton rb1 = new RadioButton("Feminin");
		RadioButton rb2 = new RadioButton("Masculin");
		RadioButton rb3 = new RadioButton("Indetermine");
		
		Label lbl = new Label();
		
		//On lie entre eux les RadioButtons au sein d'un togglegroup pour ne permettre la selection que d'un seul d'entre eux � la fois
		
		ToggleGroup grp = new ToggleGroup();
		
		grp.getToggles().addAll(rb1, rb2, rb3);
		
		//On ajoute nos composants � la liste des composants enfants de notre panneau root/
		root.getChildren().addAll(rb1, rb2, rb3, lbl);
		
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: teal");
		
		Scene scene = new Scene(root, 550, 100);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Premiers RadioButtons");
		primaryStage.sizeToScene();
		primaryStage.show();

		grp.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				
				Labeled itemSelected = (Labeled) newValue;
				lbl.setText("Changement => " + itemSelected.getText());
				
			}
		});
	}

	public static void main(String[] args) {
		launch(args);

	}

}
