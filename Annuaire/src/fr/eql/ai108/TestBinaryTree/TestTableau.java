package fr.eql.ai108.TestBinaryTree;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
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
	private StagiaireDao dao = new StagiaireDao();
	
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		
		
		observablesStagiaires = FXCollections.observableArrayList(dao.getAll());
		
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
		
		tableView.getColumns().addAll(colNom, colPrenom, colDepartement, colPromotion, colAnnee);
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
