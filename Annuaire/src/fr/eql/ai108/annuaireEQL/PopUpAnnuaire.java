package fr.eql.ai108.annuaireEQL;

import java.io.IOException;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
import classes.utilitaires.MAJTableau;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


	private Button btnRechercher;
	private Button btnAjouter;
	private Button btnMettreAJour;
	private Button btnSupprimer;
	private Button btnRetour;
	private TextField tfNom;
	private TextField tfPrenom;
	private TextField tfDepartement;
	private TextField tfPromotion;
	private	TextField tfAnnee;
	
	private AnchorPane anchorPane;
	private BorderPane borderPane;
	
	
	private TableView<Stagiaire> tableView;
	private ObservableList<Stagiaire> observablesStagiaires;
	private ObservableList<Stagiaire> observablesStagiairesRecherches;
	private StagiaireDao dao; 
	
	public PopUpAnnuaire() {
		//super();
		
		dao = new StagiaireDao();
		Stage annuairePopUp = new Stage();
		
		anchorPane = new AnchorPane();
		borderPane = new BorderPane();
		
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
		
		anchorPane.setPrefSize(1000, 1000);
		anchorPane.setMinSize(1000, 1000);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		
		//Cr�ation d'une VBox qui contient l'ensemble des commandes
		VBox vBox = new VBox();
		GridPane gridPaneButtons = new GridPane();
		HBox hBoxButtons = new HBox();
		GridPane gridPaneLabels = new GridPane();
		HBox hBoxLbl = new HBox();
		
		//Cr�ation de la HBox des bouttons
		btnRechercher = new Button("Rechercher");
		btnAjouter = new Button("Ajouter");
		btnSupprimer = new Button("Supprimer");
		
		btnRechercher.setPrefSize(150., 10.);
		btnAjouter.setPrefSize(150., 10.);
		btnSupprimer.setPrefSize(150., 10.);
		
		gridPaneButtons.addRow(0, btnRechercher, btnAjouter, btnSupprimer);
		gridPaneButtons.setHgap(100);
		hBoxButtons.getChildren().add(gridPaneButtons);
		
		hBoxButtons.setAlignment(Pos.CENTER);
		hBoxButtons.setPadding(new Insets(10));
		hBoxButtons.setPrefWidth(400);
		
		//Cr�ation de la HBox des textfield
		Label lblNom = new Label("Nom :");
		Label lblPrenom = new Label("Prenom :");
		Label lblDepartement = new Label("Departement :");
		Label lblPromotion = new Label("Promotion :");
		Label lblAnnee = new Label("Annee :");
		
		tfNom = new TextField();
		tfPrenom = new TextField();
		tfDepartement = new TextField();
		tfPromotion = new TextField();
		tfAnnee = new TextField();
		
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
		
		//Cr�ation d'une VBox pour aligner mes HBox
		
		Scene scene = new Scene(borderPane, 1000, 500);
		annuairePopUp.setScene(scene);
		annuairePopUp.setTitle("Annuaire");
		annuairePopUp.show();
		
		//To do :cr�er un bouton recherche qui enclenche la deuxi�me scene
		
		//Cr�ation d'une nouvelle scene pour la recherche de stagiaires lorsque l'on appuit sur le bouton recherche
		
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
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Stagiaire>() {

			@Override
			public void changed(ObservableValue<? extends Stagiaire> observable, Stagiaire oldValue,
					Stagiaire newValue) {
				if(newValue != null){
					getTfNom().setText(newValue.getNom());
					getTfPrenom().setText(newValue.getPrenom());
					getTfDepartement().setText(String.valueOf(newValue.getDepartement()));
					getTfPromotion().setText((newValue.getPromotion()));
					getTfAnnee().setText(String.valueOf(newValue.getAnnee()));
				}
				
			}
			
		});
		
		btnAjouter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(getTfDepartement().getText().length() > 2  || getTfAnnee().getText().length() != 4) {
					getTfDepartement().setText(String.valueOf("00"));
					getTfAnnee().setText(String.valueOf("2020"));
				} 
				String nom = getTfNom().getText();
				String prenom = getTfPrenom().getText();
				int departement = Integer.valueOf(getTfDepartement().getText());
				String promotion = getTfPromotion().getText();
				int annee = Integer.valueOf(getTfAnnee().getText());
				Stagiaire stagiaire = new Stagiaire(nom, prenom, departement, promotion, annee);
				dao.getStagiaireTree().add(stagiaire);
				update();
			}
		});
		
		btnSupprimer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String nom = getTfNom().getText();
				String prenom = getTfPrenom().getText();
				int departement = Integer.valueOf(getTfDepartement().getText());
				String promotion = getTfPromotion().getText();
				int annee = Integer.valueOf(getTfAnnee().getText());
				Stagiaire stagiaire = new Stagiaire(nom, prenom, departement, promotion, annee);
				dao.getStagiaireTree().delete(stagiaire);
				//getBorderPane().setBottom(new MAJTableau());
				//NOTE, il faut remettre à vide les chammps après suppression
				update();
				getTfNom().setText("");
				getTfPrenom().setText("");
				getTfDepartement().setText("");
				getTfPromotion().setText("");
				getTfAnnee().setText("");
			}
		});
	}
	
	
	private void update() {

		observablesStagiaires = FXCollections.observableArrayList(dao.getAll());
		tableView.getItems().clear();
		tableView.getItems().addAll(observablesStagiaires);
		
	}

	public Button getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(Button btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	public Button getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(Button btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public Button getBtnMettreAJour() {
		return btnMettreAJour;
	}

	public void setBtnMettreAJour(Button btnMettreAJour) {
		this.btnMettreAJour = btnMettreAJour;
	}

	public Button getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(Button btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public Button getBtnRetour() {
		return btnRetour;
	}

	public void setBtnRetour(Button btnRetour) {
		this.btnRetour = btnRetour;
	}

	public TextField getTfNom() {
		return tfNom;
	}

	public void setTfNom(TextField tfNom) {
		this.tfNom = tfNom;
	}

	public TextField getTfPrenom() {
		return tfPrenom;
	}

	public void setTfPrenom(TextField tfPrenom) {
		this.tfPrenom = tfPrenom;
	}

	public TextField getTfDepartement() {
		return tfDepartement;
	}

	public void setTfDepartement(TextField tfDepartement) {
		this.tfDepartement = tfDepartement;
	}

	public TextField getTfPromotion() {
		return tfPromotion;
	}

	public void setTfPromotion(TextField tfPromotion) {
		this.tfPromotion = tfPromotion;
	}

	public TextField getTfAnnee() {
		return tfAnnee;
	}

	public void setTfAnnee(TextField tfAnnee) {
		this.tfAnnee = tfAnnee;
	}

	public TableView<Stagiaire> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<Stagiaire> tableView) {
		this.tableView = tableView;
	}

	public ObservableList<Stagiaire> getObservablesStagiaires() {
		return observablesStagiaires;
	}

	public void setObservablesStagiaires(ObservableList<Stagiaire> observablesStagiaires) {
		this.observablesStagiaires = observablesStagiaires;
	}

	public ObservableList<Stagiaire> getObservablesStagiairesRecherches() {
		return observablesStagiairesRecherches;
	}

	public void setObservablesStagiairesRecherches(ObservableList<Stagiaire> observablesStagiairesRecherches) {
		this.observablesStagiairesRecherches = observablesStagiairesRecherches;
	}

	public StagiaireDao getDao() {
		return dao;
	}

	public void setDao(StagiaireDao dao) {
		this.dao = dao;
	}

	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public void setAnchorPane(AnchorPane anchorPane) {
		this.anchorPane = anchorPane;
	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}
	
	
}
