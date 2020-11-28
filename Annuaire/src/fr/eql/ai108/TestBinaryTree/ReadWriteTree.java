package fr.eql.ai108.TestBinaryTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
import classes.utilitaires.WritingFunctions;

public class ReadWriteTree {
	
	private RandomAccessFile raf = null;
	//private FileReader fr = null;
	//private BufferedReader = null;
		
		
	private void addRecursiveStagiaire(int current, Stagiaire stagiaire, String previousIndex, RandomAccessFile raf) {

		Stagiaire stagiairePrecedent = null;
			//placer ma ligne
		
			try {
				raf.seek(current*94);
				byte[] ligneByte = new byte[93];
				raf.read(ligneByte);
				String ligne = new String(ligneByte);
				System.out.println(ligne);
//				System.out.println(ligne.length());
				
			    if (ligne.trim().length() == 0) { //if (ligne1 = readLine() == null;
			    	
			    	System.out.println("I am here ?");
			    	WritingFunctions.ecrireAjout(raf, previousIndex, current, stagiaire);
			    	
			        return;
			    } else {
			    	//System.out.println(Integer.valueOf(ligne.substring(77, 81)));
			    	System.out.println("Je suis dqns le else \n" + ligne);
			    	stagiairePrecedent = StagiaireDao.stringToStagiaire(ligne);
			    }
			    
				 
			    if (stagiaire.compareTo(stagiairePrecedent) < 0) {
			    	previousIndex = current + "G";
			    	System.out.println("Je suis dans la comparaison de Gauche");
			    	
				    if(ligne.substring(82, 87).trim().length() == 0) {
				    	System.out.println("Je suis dans le IF de la comparaison de gauche");
				    	current = (int) raf.length()/94;
				    	System.out.println(current);
				    	
				    } else {
	
				    	current = Integer.valueOf(ligne.substring(82, 87).trim());
				    }
			    
			        addRecursiveStagiaire(current, stagiaire, previousIndex, raf);
			        
			    } else if (stagiaire.compareTo(stagiairePrecedent) > 0) {
			    	
			    	previousIndex = current + "D";
			    	System.out.println("Je suis dans la comparaison de Droite");

				    if(ligne.substring(88, 93).trim().length() == 0) {
				    	current = (int) raf.length()/94;
				    } else {
				    	current = Integer.valueOf(ligne.substring(88, 93).trim());
				    }
			        addRecursiveStagiaire(current, stagiaire, previousIndex, raf);
			    } else {
			        // value already exists
			        return;
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		


		    return;
		}
		public void add(Stagiaire stagiaire, String fichier) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(fichier, "rw");
				addRecursiveStagiaire(0, stagiaire, "", raf);
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

}
