package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nb;
		
		System.out.println("Veuillez entrer un nombre dont nous détaillerons la table de multiplication");
		nb = scan.nextInt();
		
		System.out.println("Table de " + nb + " :");
		for(int i =1; i <= 10; i++) {
			System.out.println(nb + " x " + i + " = " + (nb*i));
			
		}
		
		scan.close();
	}

}