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
	
	
	public static void ecrireAjout(RandomAccessFile raf, String path, NodeStagiaire aStagiaire, String previousIndex) {
    	try {
			raf = new RandomAccessFile(path, "rw");
			raf.seek(raf.length());
			int total = sumTableau() + 1;
			System.out.println("J'ai " + total + " espaces");
			ecrireStagiaire(raf, path, aStagiaire, tailleCategories);
			
			if(previousIndex.endsWith("G")) {
				System.out.println(previousIndex);
				System.out.println(Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1)));
				//int indexDuParent = Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1));
				raf.seek((Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1))*total) + ((	total-1) -11));
				System.out.println("Mon pointeur de gauche" + raf.getFilePointer());
				raf.writeBytes(String.valueOf(aStagiaire.getIndex()));
				
			} else if(previousIndex.endsWith("D")) {
				
				raf.seek((Integer.valueOf(previousIndex.substring(0, previousIndex.length()-1))*total) + ((total) - 6));
				System.out.println("Mon pointeur de droite" + raf.getFilePointer());
				raf.writeBytes(String.valueOf(aStagiaire.getIndex()));
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
	
	public static void ecrireStagiaire(RandomAccessFile raf, String path, NodeStagiaire aStagiaire, int[] tailleCategories) {
		try {
			raf.writeBytes(aStagiaire.getIndex() +"");
			for (int i = 0; i < (tailleCategories[0] - String.valueOf(aStagiaire.getIndex()).length()); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(aStagiaire.getStagiaire().getNom());
			for (int i = 0; i < (tailleCategories[1] - (aStagiaire.getStagiaire().getNom().length())); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(aStagiaire.getStagiaire().getPrenom());
			for (int i = 0; i < (tailleCategories[2] - (aStagiaire.getStagiaire().getPrenom().length())); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(String.valueOf(aStagiaire.getStagiaire().getDepartement()));
			for (int i = 0; i < (tailleCategories[3] - String.valueOf(aStagiaire.getStagiaire().getDepartement()).length()); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(String.valueOf(aStagiaire.getStagiaire().getPromotion()));
			for (int i = 0; i < (tailleCategories[4] - aStagiaire.getStagiaire().getPromotion().length()); i++) {
				raf.writeBytes(" ");
			}
			raf.writeBytes(String.valueOf(aStagiaire.getStagiaire().getAnnee()));
			for (int i = 0; i < (tailleCategories[5] - String.valueOf(aStagiaire.getStagiaire().getAnnee()).length()); i++) {
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
	
