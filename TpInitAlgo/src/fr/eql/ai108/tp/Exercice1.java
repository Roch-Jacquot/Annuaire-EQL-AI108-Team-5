package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Veuillez m'indiquer un nombre à analyser");
		int var = scan.nextInt();
		
		if(var > 0) {
			System.out.println("Ce nombre est positif");
		} else if(var < 0) {
			System.out.println("Ce nombre est négatif");
		} else if(var ==0) {
			System.out.println("ni l’un ni l’autre");
		}
		
		scan.close();
	}

}