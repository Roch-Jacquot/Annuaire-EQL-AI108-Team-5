package fr.eql.ai108.annuaireEQL;

import java.util.ArrayList;
import java.util.List;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RechercheTableau {
	public static void main(String[] args) {
		StagiaireDao dao = new StagiaireDao();
		ObservableList<Stagiaire> observablesStagiaires;
		List<Stagiaire> stagiairesRecherches;
		observablesStagiaires = FXCollections.observableArrayList(dao.getAll());
		
		Stagiaire stagiaireRecherche = new Stagiaire("", "", 0, "", 0);
		
		stagiairesRecherches = stagiairesRecherches(stagiaireRecherche);
		System.out.println(stagiairesRecherches);
	}
	
	public static List<Stagiaire> stagiairesRecherches(Stagiaire stagiaire){
		
		StagiaireDao dao = new StagiaireDao();
		Stagiaire currentStagiaire;
		ObservableList<Stagiaire> observablesStagiaires;
		observablesStagiaires = FXCollections.observableArrayList(dao.getAll());
		
		String nomStagiaireRecherche = stagiaire.getNom();
		String prenomStagiaireRecherche = stagiaire.getPrenom();
		int departementStagiaireRecherche = stagiaire.getDepartement();
		String departementString = intToString(departementStagiaireRecherche);
		String promotionStagiaireRecherche = stagiaire.getPromotion();
		int anneeStagiaireRecherche = stagiaire.getAnnee();
		String anneeString = intToString(anneeStagiaireRecherche);

		List<Stagiaire> stagiairesCorrespondants = new ArrayList<>();
		
		for (int i = 0; i < observablesStagiaires.size(); i++) {
			currentStagiaire = observablesStagiaires.get(i);
			
			String nomCurrentStagiaire = currentStagiaire.getNom();
			String prenomCurrentStagiaire = currentStagiaire.getPrenom();
			int departementCurrentStagiaire = currentStagiaire.getDepartement();
			String departementStringStagiaire = intToString(departementCurrentStagiaire);
			String promotionCurrentStagiaire = currentStagiaire.getPromotion();
			int anneeCurrentStagiaire = currentStagiaire.getAnnee();
			String anneeStringStagiaire = intToString(anneeCurrentStagiaire);
			String indiceBoucle = null;
			
			boolean validation = true;
			boolean validation1 = false;
			boolean validation2 = false;
			boolean validation3 = false;
			boolean validation4 = false;
			boolean validation5 = false;
			
			//On test les valeurs recherchés par rapport à celle du stagiaire courant
			validation1 = verification(validation, nomCurrentStagiaire, nomStagiaireRecherche);
			validation2 = verification(validation1, prenomCurrentStagiaire, prenomStagiaireRecherche);
			validation3 = verification(validation2, departementStringStagiaire, departementString);
			validation4 = verification(validation, promotionCurrentStagiaire, promotionStagiaireRecherche);
			validation5 = verification(validation, anneeStringStagiaire, anneeString);
			
			if(validation1 == true && validation2 == true && validation3 == true && validation4 == true && validation5 == true) {
				stagiairesCorrespondants.add(currentStagiaire);
			}
		}
		return stagiairesCorrespondants;
	}
	
	public static boolean verification(boolean validation, String currentStagiaire, String stagiaireRecherche) {
			int nbCaractere = stagiaireRecherche.length();
			int nbCaractereCurrent = currentStagiaire.length();
			boolean validationN = false;
			if(validation = true && nbCaractere <= nbCaractereCurrent) {
				
				validationN = true;
				for(int i = 0; i < nbCaractere; i++) {
						if (currentStagiaire.charAt(i) != stagiaireRecherche.charAt(i)) {
							validationN = false;
						}
					}
			}
			if (nbCaractere > nbCaractereCurrent) {
				validationN = false;
			}
		return validationN;
	}
	
	private static String intToString(int unNombre) {
		String resultat = null;
		if(unNombre != 0 && unNombre != 00) {
			resultat = String.valueOf(unNombre);
		}
		else {
			resultat = "";
		}
		return resultat;
	}
}
