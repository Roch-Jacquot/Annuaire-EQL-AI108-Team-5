package rechercheV1;

import java.util.Scanner;

public class ExempleAnalyse {

	static String nomJoueur;

	public static void main(String[] args) {
		
		
		// 1 - identifier le joueur
		
		nomJoueur = identifierJoueur();
		
		do {		

			jouerUnTour();
			
		} while(true);
	}
	
	private static int comparerChoix(int choixOrdi, int choixJoueur) {
		// TODO Auto-generated method stub
		// -1 ordi; 0 egalite; 1 joueur
		return 0;
	}

	private static int determinerChoixJoueur() {
		//2.2.1 - demander choix
		
		//2.2.2 - récupérer la valeur
	
		//2.2.3 - vérifier la valeur
		
		return 0;
	}

	private static int determinerChoixOrdi() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void jouerUnTour() {
		// 2.1 - déterminer le choix du ordi
		
				int choixOrdi = determinerChoixOrdi();

				
				// 2.2 - déterminer le choix du joueur
				int choixJoueur = determinerChoixJoueur();
				
				// 2.3 - comparer résultats
				// -1 ordi; 0 egalite; 1 joueur
				
				int resultat = comparerChoix(choixOrdi, choixJoueur);
				// 2.4 - mettre à jour le score
				
				// 3 - afficher le score
		
	}

	public static String identifierJoueur() {
		System.out.println("Votre nom :");
		Scanner scan = new Scanner(System.in);
		String nom = scan.nextLine();
		return nom;
	}

}