package test;

import classes.stagiaire.Stagiaire;
import classes.utilitaires.FileFormator;

public class testStagiaire {
	

	public static void main(String[] args) {
		
		Stagiaire bob = new Stagiaire("Zaza", "Bob", 75, "AI 666", 2060);
		Stagiaire raph = new Stagiaire("Lvt", "Raph", 91, "AI 108", 2020);
		
		new FileFormator("C:/Users/formation/Downloads/stagiaires.txt", "Test2");
		
		Stagiaire [] stag = {bob, raph};
		
		for (Stagiaire stagiaire : stag) {
			System.out.println(stagiaire);
		}

	}

}
