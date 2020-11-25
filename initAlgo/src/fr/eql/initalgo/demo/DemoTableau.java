package fr.eql.initalgo.demo;

public class DemoTableau {

	public static void main(String[] args) {
		// Les TABLEAUX
		
		//Déclaration et l'instanciation d'un tableau
		
		String[] saisons = new String[4];

		//Ecrire dans le tableau
		saisons[0] = "Printemps";
		saisons[1] = "Ete";
		saisons[2] = "Automne";
		saisons[3] = "Hiver";
		
		
		//Lire une valeur dans le tableau
		System.out.println(saisons[2]);
		
		//Taille du tableau
		System.out.println(saisons.length);
		
		//parcours du tableau
		for(int i = 0; i < saisons.length; i++) {
			System.out.println(saisons[i]);
			
		}
		/*
		int[] fibonaci = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
		
		for(int j = 0; j < fibonaci.length; j++) {System.out.println(fibonaci[j]);}
		
		*/
		//ecrire un tableau à deux dimensions
		
		
		int [][] matrice = {
				{1, 2, 3}, 
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12, 13}
		};
		
		//Taile des dimensions
		/*
		System.out.println(matrice.length);
		//System.out.println(matrice[0].length);
		for(int i = 0; i < matrice.length; i++) {
			System.out.println(matrice[i].length);
			
		}*/
		
		
		//parcourir toutes les valeurs
		
		
		for(int x = 0; x < matrice.length; x++) {
			for(int y = 0; y < matrice[x].length; y++) {
				System.out.print( matrice[x][y] + " ");
			}
			System.out.println();
		}
		
		//acceder à valeur
		
		System.out.println(matrice[1][1]);
	}

}