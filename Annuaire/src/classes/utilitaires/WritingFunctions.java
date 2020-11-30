package classes.utilitaires;

import java.io.IOException;
import java.io.RandomAccessFile;

import classes.stagiaire.Stagiaire;
import fr.eql.ai108.TestBinaryTree.NodeStagiaire;

public class WritingFunctions {

	String path;
	boolean newFile;
	static int[] tailleCategories = {5, 30, 30, 2, 10, 4, 6, 6};
	
	/*
	public WritingFunctions(String path, boolean newFile) {
		this.path = path;
		this.newFile = newFile;
	}*/
	
	
	public static void ecrireAjout(RandomAccessFile raf, String previousIndex, int current, Stagiaire stagiaire) {
    	try {
			int total = sumTableau() + 1;
			ecrireStagiaire(raf, tailleCategories, current, stagiaire);
			
			if(previousIndex.endsWith("G")) {
				
//				System.out.println(previousIndex);
//				System.out.println(Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1)));

				
				
				raf.seek((Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1))*total) + ((	total-1) -11));
				System.out.println("Mon pointeur de gauche" + raf.getFilePointer());
				raf.writeBytes(String.valueOf(current));
				
			} else if(previousIndex.endsWith("D")) {
				
				raf.seek((Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1))*total) + ((total) - 6));
				System.out.println("Mon pointeur de droite" + raf.getFilePointer());
				raf.writeBytes(String.valueOf(current));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void ecrireStagiaire(RandomAccessFile raf, int[] tailleCategories, int current, Stagiaire stagiaire) {
		int tailleDepartement = 0;
		String departement = "0";
		try {
			raf.writeBytes(current +"");
			for (int i = 0; i < (tailleCategories[0] - String.valueOf(current).length()); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(stagiaire.getNom());
			for (int i = 0; i < (tailleCategories[1] - (stagiaire.getNom().length())); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(stagiaire.getPrenom());
			for (int i = 0; i < (tailleCategories[2] - (stagiaire.getPrenom().length())); i++) {
				raf.writeBytes(" ");
			}
			tailleDepartement = String.valueOf(stagiaire.getDepartement()).length();
			if(tailleDepartement == 2) {
				raf.writeBytes(String.valueOf(stagiaire.getDepartement()));	
			}
			else {
				departement += String.valueOf(stagiaire.getDepartement());
				raf.writeBytes(departement);
			}
			raf.writeBytes(String.valueOf(stagiaire.getPromotion()));
			for (int i = 0; i < (tailleCategories[4] - stagiaire.getPromotion().length()); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(String.valueOf(stagiaire.getAnnee()));
			for (int i = 0; i < (tailleCategories[5] - String.valueOf(stagiaire.getAnnee()).length()); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes("G");
			for (int i = 0; i < tailleCategories[6]-1; i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes("D");
			for (int i = 0; i < tailleCategories[6]-1; i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes("\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		}
	
	private static int sumTableau() {
		int total = 0;
		for (int i = 0; i < tailleCategories.length; i++) {
			total += tailleCategories[i];
		}
		return total;
	}
}
	
