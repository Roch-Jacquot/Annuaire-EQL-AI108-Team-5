package exo.mastermind;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		//PARAMETRES :
			//tableau GuessJoueur : Char
			//tableau actualOrdi char[]
			//nombre de tours : int
			//gagner : boolean
			//boolean : quitter
		//Bleu,  Jaune,  Vert,  Rouge,  Marron  et  Noir
		
		
		//TRAITEMENTS
			// 1 - initialiser le tableau ordi 
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		
		char[] actualOrdi;
		char[] guessJoueur;
		int place;
		int trouve;
		boolean gagne = false;
		
		//String actualOrdi = scan.nextLine();
		//String declareDevine = "BJBJ";
		String declareDevine = selectOrdi(scan, rand);
		System.out.println(declareDevine);
		 actualOrdi = selectChaine(declareDevine);
		 System.out.println("\nLa machine a déclaré " + actualOrdi.length + " lettes");
				// 1.1 - afficher le lenght pour que le joueur ne se trompe pas
		
		
		
		
			// 2 - répéter
		do {
					// 2.1 - Demander au joueur d'entrer un String et leconvertir en tableau
			
			System.out.println("Veuillez constuire une suite de " + actualOrdi.length + " couleurs à l'aide des couleurs suivantes : "
					+ "Bleu,  Jaune,  Vert,  Rouge,  Marron  et  Noir. Entrez la première lettre des couleurs choisies");
			
			String monGuess = scan.nextLine();
			
			guessJoueur = selectChaine(monGuess);
			System.out.print("\nLe joueur a déclaré " + guessJoueur.length + " lettes et elles sont :");
			/*
			for (char c : guessJoueur) {
				System.out.print(c);
			}
			*/
					// 2.2 - boucler sur les deux tableaux
					place = 0;
					trouve = 0;
					char[] indexesJoueur = new char[guessJoueur.length];
					char[] indexesOrdi = new char[actualOrdi.length];
			
					for (int i = 0; i < actualOrdi.length; i++) {
						// 2.2.1 - si tabA[i] == tabB[i] : Place ++
						if(actualOrdi[i] == guessJoueur[i]) {
							place ++;
							indexesJoueur[i] = ' ';
							indexesOrdi[i] = ' ';
							
							
						} else if(actualOrdi[i] != guessJoueur[i]) {
							indexesJoueur[i] = guessJoueur[i];
							indexesOrdi[i] = actualOrdi[i];
							}
							
						}

					System.out.println();
					for (int j = 0; j < indexesJoueur.length; j++) {
						for (int j2 = 0; j2 < indexesOrdi.length; j2++) {
							if(indexesJoueur[j] != ' ' && indexesJoueur[j] == indexesOrdi[j2]) {
								System.out.println(" Currently j = "+ j + " indexesJoueur " + indexesJoueur[j] + 
										" et indexesOrdi j2 = " + j2 + " à " + indexesOrdi[j2]);
								trouve ++;
								System.out.println("Trouve est " + trouve);
								indexesOrdi[j2] = ' ';
								indexesJoueur[j] = ' ';
							}
						}
						
					}

					
					for (int i = 0; i < guessJoueur.length; i++) {
						System.out.print(guessJoueur[i]);
					}
					System.out.print(" -> " + place + " Placés " + trouve + " Trouvés\n");
	
					// 2.3 - Si place == tab.length : gagner = true;
					if(place == actualOrdi.length) {
						gagne = true;
						System.out.println("\nFelicitations, vous avez gagné");
					}
			
					// 2.4 - incrémenter tours;
			
					
		} while(!gagne);
				scan.close();
	}
	

	public static char[] selectChaine(String declareDevine) {
		
		char[] tabDeclare = declareDevine.toUpperCase().trim().toCharArray();
		
		return tabDeclare;
	}
	
	public static String selectOrdi(Scanner scan, Random rand) {
		System.out.println("Combien de caractères ?");
		int combien = scan.nextInt();
		scan.nextLine();
		String couleurs = "BJVRMN";
		String selection = "";
		
		for (int i = 0; i < combien; i++) {
			int val = rand.nextInt(couleurs.length());
			selection += couleurs.charAt(val);
		}
		return selection;
	}
}