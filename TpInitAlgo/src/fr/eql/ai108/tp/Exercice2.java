package fr.eql.ai108.tp;

import java.util.Scanner;

public class Exercice2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Veuillez indiquer un nombre pour savoir si il est pair ou impair");
		int maVar = scan.nextInt();
		
		if(maVar % 2 == 0 ) {
			System.out.println("Ce nombre est pair");
		} else if(maVar % 2 != 0) {
			System.out.println("Ce nombre est impair");
		}

		
		scan.close();
	}

}