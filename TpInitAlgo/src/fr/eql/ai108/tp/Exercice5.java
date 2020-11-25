package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice5 {

	
	/*Ecrire un programme qui demande à l’utilisateur un login etun mot de passe. 
	 * Si le login renseigné est «admin» et le mot de passe «123Soleil»,
	 * le programme souhaite la bienvenue à l’utilisateur sur le Super Calculateur; 
	 * autrement, l’utilisateur reçoit un message «Login et/ou Password incorrect(s)». 
	 * Arrivé sur le Super Calculateur, le programme demande à l’utilisateur deux opérandes 
	 * ainsi qu’une opération (addition, soustraction, multiplication, division). 
	 * Enfin, le programme affiche le résultat de l’opération.
	 */
	
	
	
	public static void main(String[] args) {
		
		//Variables et objects à instancier
		String login;
		String mdp;
		
		String REALLOGIN = "admin";
		String REALMDP = "123Soleil";
		Scanner scan = new Scanner(System.in);
		
		double nb1;
		double nb2;
		String operation="";

		//Afficher message demandant un login
		System.out.println("Veuillez entrer votre login");
		//saisir le login
		login = scan.nextLine();
		
		//Afficher message demandant un mdp
		System.out.println("Veuillez entrer votre mot de passe");
		//saisir le mdp
		mdp = scan.nextLine();		
		
		//if login ET mdp != constantes
		if(!login.equals(REALLOGIN) || !mdp.equals(REALMDP)) {
			//affiche "Login et/ou Password incorrect(s)"
			System.out.println("Login et/ou Password incorrect(s)");
			//Else
			
		} else {
			// affiche "bienvenue sur le Super Calculateur"
			System.out.println("Bienvenue sur le Super Calculateur");
			
			// affiche la demande de deux operandes (double)
			System.out.println("Veuillez maintenant indiquer deux opérandes");
			
			// saisir les operandes 
			nb1 = scan.nextDouble();
			nb2 = scan.nextDouble();
			scan.nextLine();
			// affiche la demande d'operation(addition, soustraction, multiplication, division)
			System.out.println("Veuillez indiquer un type d'opération "
					+ "(addition, soustraction, multiplication, division)");
			
			//saisie du type d'opération
			operation = scan.nextLine();	
			//test that correction input.nextLine();.
			//switch addition, soustraction, multiplication, division
			switch(operation) {
			
			case "addition" :
				System.out.println("La somme est " + (nb1+nb2));
				break;
			case "soustraction" :
				System.out.println("Le résultat de la soustraction est " + (nb1 - nb2));
				break;
				
			case "multiplication" :
				System.out.println("Le résultat de la multiplication est " + (nb1*nb2));
				break;
			case "division" :
				System.out.println("Le résultat de la division est " + (nb1/nb2));
				break;
			
			}
			
		}
		
		scan.close();
	}

}