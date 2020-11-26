package fr.eql.ai108.TestBinaryTree;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestTableau extends Application {
	private TableView<Stagiaire> tableView;
	private ObservableList<Stagiaire> observablesStagiaires;
	
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		Stagiaire stagiaire1 = new Stagiaire("Jean", "Marc", 75, "AI108", 2020);
		Stagiaire stagiaire2 = new Stagiaire("Durant", "Julie", 91, "AI108", 2020);
		Stagiaire stagiaire3 = new Stagiaire("Dupont", "Romain", 92, "AI108", 2020);
		Stagiaire stagiaire4 = new Stagiaire("Dupond", "Kevin", 93, "AI108", 2020);
		Stagiaire stagiaire5 = new Stagiaire("Trump", "Marc", 94, "AI108", 2020);
		Stagiaire stagiaire6 = new Stagiaire("Bidden", "Antoine", 94, "AI108", 2020);
		Stagiaire stagiaire7 = new Stagiaire("Louvet", "William", 94, "AI108", 2020);
		Stagiaire stagiaire8 = new Stagiaire("Deschamps", "Marcus", 94, "AI108", 2020);
		BinaryTreeStagiaire btst = new BinaryTreeStagiaire();
		btst.add(stagiaire1);
		btst.add(stagiaire2);
		btst.add(stagiaire3);
		btst.add(stagiaire4);
		btst.add(stagiaire5);
		btst.add(stagiaire6);
		btst.add(stagiaire7);
		btst.add(stagiaire8);
		observablesStagiaires = FXCollections.observableArrayList(btst.traverseToList());
		
		tableView = new TableView<>(observablesStagiaires);
		TableColumn<Stagiaire, String> colNom = new TableColumn("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<Stagiaire, String> colPrenom = new TableColumn("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		
		TableColumn<Stagiaire, Integer> colDepartement = new TableColumn("Departement");
		colDepartement.setCellValueFactory(new PropertyValueFactory<>("departement"));
		
		TableColumn<Stagiaire, String> colPromotion = new TableColumn("Promotion");
		colPromotion.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		
		TableColumn<Stagiaire, Integer> colAnnee = new TableColumn("Annee");
		colAnnee.setCellValueFactory(new PropertyValueFactory<>("annee"));
		
		tableView.getColumns().addAll(colNom, colPrenom, colDepartement, colAnnee);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		root.getChildren().add(tableView);
		AnchorPane.setTopAnchor(tableView, 5.); 
		AnchorPane.setBottomAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TestTableau");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
