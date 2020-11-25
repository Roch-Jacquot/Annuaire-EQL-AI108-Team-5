package fr.eql.ai108.tp;

import java.util.Scanner;
import java.util.Random;

public class Exercice11 {

	public static void main(String[] args) {
		
//		Ecrire un programme qui permet à l’utilisateur de jouer des parties de jeu de NIM 
//		à 20 allumettes contre l’ordinateur.Chacun à leur tour, le joueur et l’ordinateur ont la 
//		possibilité de prendre 1, 2 ou 3 allumettes;celuiqui prend la dernière allumette remporte la partie. 
//		L’utilisateur a la possibilité de choisir qui joue en premier. Si l’utilisateur choisitde jouer en 
//		premier, l’ordinateur applique l’algorithme de victoire systématique.
//		Si l’utilisateur choisit que l’ordinateur débute la partie, l’ordinateur pioche àchaque tout un 
//		nombre aléatoire d’allumettes compris entre 0 et 3. Cependant, l’ordinateur n’est pas si stupide;
//		s’il ne reste que 1, 2 ou 3 allumettes, il les pioche et remporte la partie.A la fin de chaque partie, 
//		le joueur ala possibilité d’arrêter de jouer ou de commencer une nouvelle partie.

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		boolean premierJoueur;
		boolean jeu = true;
		int alum;
		String dernierJoueur = "";
		int action;
		
		do {
			alum = 20;
			System.out.println("Voulez-vous jouer en premier ? (true, false)");
			premierJoueur = scan.nextBoolean();
			
			if(premierJoueur) {
				
				
				
				while(alum > 0) {
					
					//TOUR HUMAIN
					
					//action de l'humain
					System.out.println("\nChoisissez entre 1 et 3 allumettes");
					action = scan.nextInt();
					
					//retrait de Alum
					alum -= action;
					
					//sauvegarde du dernier joueur
					dernierJoueur = "Humain";
					
					//allumettes restantes
					System.out.println("Il reste " + alum + " allumettes après le tour de l'humain");
					
					if(alum <= 0) {
						break;
					}
					
					//TOUR MACHINE
					//action de la machine
					if(alum < 4) {
						action = alum;
					} else {
						action = 4-action;
					}
					
					System.out.println("\nL'ordinateur a pris " + action + " allumettes");
					//retrait de Alum
					alum -= action;
					
					//sauvegarde du dernier joueur
					dernierJoueur = "Ordinateur";
					
					//allumettes restantes
					System.out.println("\nIl reste " + alum + " allumettes");
					
					if(alum <= 0) {
						break;
					}

					
				}
				
			} else {
				
				while(alum > 0) {
				
					//TOUR MACHINE
					//action de la machine
					if(alum < 4) {
						action = alum;
					} else {
						action = rand.nextInt(3)+1;
					}
					
					System.out.println("\nL'ordinateur a pris " + action + " allumettes");
					//retrait de Alum
					alum -= action;
					
					//sauvegarde du dernier joueur
					dernierJoueur = "Ordinateur";
					
					//allumettes restantes
					System.out.println("\nIl reste " + alum + " allumettes");
					
					if(alum <= 0) {
						break;
					}
					
					//TOUR HUMAIN
					
					//action de l'humain
					System.out.println("\nChoisissez entre 1 et 3 allumettes");
					action = scan.nextInt();
					
					//retrait de Alum
					alum -= action;
					
					//sauvegarde du dernier joueur
					dernierJoueur = "Humain";
					
					//allumettes restantes
					System.out.println("Il reste " + alum + " allumettes après le tour de l'humain");
					
					if(alum <= 0) {
						break;
					}
				
				}
				
				

			}
			
			
			System.out.println("Le gagnant est " + dernierJoueur);
			
			System.out.println("La partie est finie, voulez-vous en rejouer une ? (true, false)");
			
			jeu = scan.nextBoolean();
			
		} while (jeu);
		
		
		scan.close();
		
	}

}