package fr.eql.ai108.annuaireEQL;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopUpAnnuaire /*extends AnchorPane*/ {
	
	
	private TableView<Stagiaire> tableView;
	private ObservableList<Stagiaire> observablesStagiaires;
	private ObservableList<Stagiaire> observablesStagiairesRecherches;
	private StagiaireDao dao = new StagiaireDao();
	
	public PopUpAnnuaire() {
		//super();
		
		Stage annuairePopUp = new Stage();
		
		AnchorPane anchorPane = new AnchorPane();
		BorderPane borderPane = new BorderPane();
		
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
		//tableView
		
		anchorPane.getChildren().add(tableView);
		
		anchorPane.setPrefSize(1000, 5000);
		anchorPane.setMinSize(1000, 5000);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		
		//Création d'une VBox qui contient l'ensemble des commandes
		VBox vBox = new VBox();
		GridPane gridPaneButtons = new GridPane();
		HBox hBoxButtons = new HBox();
		GridPane gridPaneLabels = new GridPane();
		HBox hBoxLbl = new HBox();
		
		//Création de la HBox des bouttons
		Button btnRechercher = new Button("Rechercher");
		Button btnAjouter = new Button("Ajouter");
		Button btnMettreAJour = new Button("Mettre à jour");
		Button btnSupprimer = new Button("Supprimer");
		Button btnRetour = new Button("Retour");
		
		btnRechercher.setPrefSize(150., 10.);
		btnAjouter.setPrefSize(150., 10.);
		btnMettreAJour.setPrefSize(150., 10.);
		btnSupprimer.setPrefSize(150., 10.);
		btnRetour.setPrefSize(150., 10.);
		
		gridPaneButtons.addRow(0, btnRechercher, btnAjouter, btnMettreAJour, btnSupprimer, btnRetour);
		gridPaneButtons.setHgap(100);
		hBoxButtons.getChildren().add(gridPaneButtons);
		
		hBoxButtons.setAlignment(Pos.CENTER);
		hBoxButtons.setPadding(new Insets(10));
		hBoxButtons.setPrefWidth(400);
		
		//Création de la HBox des textfield
		Label lblNom = new Label("Nom :");
		Label lblPrenom = new Label("Prénom :");
		Label lblDepartement = new Label("Département :");
		Label lblPromotion = new Label("Promotion :");
		Label lblAnnee = new Label("Année :");
		
		TextField tfNom = new TextField();
		TextField tfPrenom = new TextField();
		TextField tfDepartement = new TextField();
		TextField tfPromotion = new TextField();
		TextField tfAnnee = new TextField();
		
		gridPaneLabels.addRow(0, lblNom, lblPrenom, lblDepartement, lblPromotion, lblAnnee);
		gridPaneLabels.addRow(1, tfNom, tfPrenom, tfDepartement, tfPromotion, tfAnnee);
		gridPaneLabels.setHgap(100);
		hBoxLbl.getChildren().add(gridPaneLabels);
		
		hBoxLbl.setAlignment(Pos.CENTER);
		hBoxLbl.setPadding(new Insets(10));
		hBoxLbl.setPrefWidth(300);
		
		vBox.getChildren().addAll(hBoxButtons, hBoxLbl);
		vBox.setAlignment(Pos.CENTER);
		//vBox.setPrefHeight(200);
		vBox.setMaxHeight(200);
		borderPane.setTop(vBox);
		borderPane.setBottom(anchorPane);
		
		//Création d'une VBox pour aligner mes HBox
		
		Scene scene = new Scene(borderPane, 1000, 500);
		annuairePopUp.setScene(scene);
		annuairePopUp.setTitle("Annuaire");
		annuairePopUp.show();
		
		//To do :créer un bouton recherche qui enclenche la deuxième scene
		
		//Création d'une nouvelle scene pour la recherche de stagiaires lorsque l'on appuit sur le bouton recherche
		
		//Instanciation d'un nouveau stagiire a partir des textFiled
		
//		Stagiaire stagiaireRecherche = new Stagiaire();
//		
//		AnchorPane anchorPaneRecherche = new AnchorPane();
//		observablesStagiairesRecherches = FXCollections.observableArrayList(dao.getAllRecherche(stagiaireRecherche));
//		
//		tableView = new TableView<>(observablesStagiairesRecherches);
//		
//		TableColumn<Stagiaire, String> colNomRecherche = new TableColumn("Nom");
//		colNomRecherche.setCellValueFactory(new PropertyValueFactory<>("nom"));
//		
//		TableColumn<Stagiaire, String> colPrenomRecherche = new TableColumn("Prenom");
//		colPrenomRecherche.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//		
//		TableColumn<Stagiaire, Integer> colDepartementRecherche = new TableColumn("Departement");
//		colDepartementRecherche.setCellValueFactory(new PropertyValueFactory<>("departement"));
//		
//		TableColumn<Stagiaire, String> colPromotionRecherche = new TableColumn("Promotion");
//		colPromotionRecherche.setCellValueFactory(new PropertyValueFactory<>("promotion"));
//		
//		TableColumn<Stagiaire, Integer> colAnneeRecherche = new TableColumn("Annee");
//		colAnneeRecherche.setCellValueFactory(new PropertyValueFactory<>("annee"));
//		
//		tableView.getColumns().addAll(colNomRecherche, colPrenomRecherche, colDepartementRecherche, colPromotionRecherche, colAnneeRecherche);
//		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		
//		anchorPane.getChildren().add(tableView);
//		
//		anchorPane.setPrefSize(1000, 500);
//		AnchorPane.setTopAnchor(tableView, 5.);
//		AnchorPane.setLeftAnchor(tableView, 5.);
//		AnchorPane.setRightAnchor(tableView, 5.);
//		AnchorPane.setBottomAnchor(tableView, 5.);
//		
//
//		annuairePopUp.setScene(scene);
//		annuairePopUp.show();
//		
//		affichageRecherche = new Scene(anchorPaneRecherche);
		
	}
}
