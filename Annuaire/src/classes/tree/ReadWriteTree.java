package classes.tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
import classes.utilitaires.WritingFunctions;

public class ReadWriteTree {
	
	String fichier;
	
	public ReadWriteTree(String path) {
		this.fichier = path;
		
	}
	
	public ReadWriteTree() {
		
	}
	
	
	private RandomAccessFile raf = null;
		
		
	private void addRecursiveStagiaire(int current, Stagiaire stagiaire, String previousIndex, RandomAccessFile raf) {

		Stagiaire stagiairePrecedent = null;
			//placer ma ligne
		
			try {
				raf.seek(current*94);
				/*
				byte[] ligneByte = new byte[93];
				raf.read(ligneByte);
				String ligne = new String(ligneByte);
				*/
				String ligne = ReadtoString(raf);
				
			    if (ligne.trim().length() == 0) { //if (ligne1 = readLine() == null;
			    	

			    	WritingFunctions.ecrireAjout(raf, previousIndex, current, stagiaire);
			    	
			        return;
			    } else {
			    	//System.out.println(Integer.valueOf(ligne.substring(77, 81)));
			    	stagiairePrecedent = StagiaireDao.stringToStagiaire(ligne);
			    }
			    
				 
			    if (stagiaire.compareTo(stagiairePrecedent) < 0) {
			    	previousIndex = current + "G";
			    	
				    if(ligne.substring(82, 87).trim().length() == 0) {
				    	current = (int) raf.length()/94;
				    	
				    } else {
	
				    	current = Integer.valueOf(ligne.substring(82, 87).trim());
				    }
			    
			        addRecursiveStagiaire(current, stagiaire, previousIndex, raf);
			        
			    } else if (stagiaire.compareTo(stagiairePrecedent) > 0) {
			    	
			    	previousIndex = current + "D";


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
		public void add(Stagiaire stagiaire/*, String fichier*/) {
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
		
		
		//Méthode pour supprimer un élèment
		//De même, méthode qui parcourt l'arbre jusqu'à trouver le bon élèment
	    private void deleteRecursive(int current, Stagiaire stagiaire, String previousIndex, RandomAccessFile raf) {
	    	
	    	Stagiaire stagiairePrecedent = null;
	    	System.out.println(stagiaire);
	    	
	    	try {
				raf.seek(current*94);
				String ligne = ReadtoString(raf);

	    	
	    if (ligne.trim().length() == 0) {
	    	
	        return;
	    }
	    

		stagiairePrecedent = StagiaireDao.stringToStagiaire(ligne);
		String gaucheEnfant = ligne.substring(82, 87).trim();
		String droiteEnfant = ligne.substring(88, 93).trim();
		
	    
//	    System.out.println("Je vais rentrer dans mes conditions");
//	    System.out.println(stagiaire);
//	    System.out.println(stagiairePrecedent);
	    
	    
	    if (stagiaire.compareTo(stagiairePrecedent) == 0) {
	    	
	    	// S'il n'a aucun enfant il suffit de lui affecter la valeur null
	    	if (gaucheEnfant.length() == 0 && droiteEnfant.length() ==0) {
	    		raf.seek(current*94);
				for (int i = 0; i <  93; i++) {
					raf.writeBytes(" ");
	    	}
//				System.out.println("Effacement sans enfant");
				
				raf.seek((Integer.valueOf(previousIndex.trim())*94) + 82);
				for (int i = 0; i <  5; i++) {
					raf.writeBytes(" ");
	    	}
				
	    	    return;
	    	}
	        // S'il n'a qu'un seul enfant, il suffit de le remplacer par celui-ci
	    	if (droiteEnfant.length() == 0) {
	    		
	    		//Si il n'a pas d'enfant à droite, on saute à son enfant de gauche
	    		raf.seek(Integer.valueOf(gaucheEnfant) * 94);
	    		
	    		//on lit la ligne de l'enfant
				String ligneEnfant = ReadtoString(raf);
				
				//on retourne au début de la ligne de l'enfant et on l'efface
				
				raf.seek(Integer.valueOf(gaucheEnfant) * 94);
				for (int i = 0; i <  93; i++) {
					raf.writeBytes(" ");
	    	}
				
				//finallement, on retourne à la ligne du parent qu'on efface et on y écrit la ligne de l'enfant
				raf.seek(current * 94);
				raf.writeBytes(ligne.substring(0, 5));
				raf.writeBytes(ligneEnfant.substring(5));
				
//				System.out.println("Effacement si enfant à gauche");
				
				return;
				
	    	}
	    	 
	    	if (gaucheEnfant.length() == 0) {
	    		//Si il n'a pas d'enfant à droite, on saute à son enfant de gauche
	    		raf.seek(Integer.valueOf(droiteEnfant) * 94);
	    		
	    		//on lit la ligne de l'enfant
				String ligneEnfant = ReadtoString(raf);
				
				//on retourne au début de la ligne de l'enfant et on l'efface
				
				raf.seek(Integer.valueOf(droiteEnfant) * 94);
				for (int i = 0; i <  93; i++) {
					raf.writeBytes(" ");
	    	}
				
				//finallement, on retourne à la ligne du parent qu'on efface et on y écrit la ligne de l'enfant
				raf.seek(current * 94);
				raf.writeBytes(ligne.substring(0, 5));
				raf.writeBytes(ligneEnfant.substring(5));
				
//				System.out.println("Effacement si enfant à droite");
				
				return;
	    	}
	    	
	    	
	    	//S'il a deux enfants, il faut ré-organiser l'arbre
	    	//On cherche le plus petit noeud de la branche de droite afin d'avoir une valeur "moyenne"
	    	//On l'ajoute sur le noeud  courant et on le supprime à son emplacement d'origine
	    	
	    	String smallestValue = findSmallestStagiaire(droiteEnfant, raf);
	    	
	    	//J'ai trouvé l'index du plus petit, maintenant je vais le chercher
	    	raf.seek(Integer.valueOf(smallestValue)*94);
	    	
			String ligneSmallestStagiaire = ReadtoString(raf);
			
			
			stagiairePrecedent = StagiaireDao.stringToStagiaire(ligneSmallestStagiaire);
			
			
			//Sauter à la place du stagiaire que j'efface et j'ecraser avec le stagiaire petit
			raf.seek(Integer.valueOf(smallestValue)*94);
			raf.seek(Integer.valueOf((ligne.substring(0,5).trim()))*94);
			raf.writeBytes(ligne.substring(0,5));
			raf.writeBytes(ligneSmallestStagiaire.substring(5, 81));
			
			//Garder l'enfant de droite ORIGINAL du stagiaire effacé et lancer la récursion dessus 
			
			droiteEnfant = ligne.substring(88, 93).trim();
			previousIndex = ligne.substring(0, 5);
			
			
	    	deleteRecursive(Integer.valueOf(droiteEnfant), stagiairePrecedent, previousIndex, raf);
	    	
	    	
	    	return;
		    }

	    
		    if ((stagiaire.compareTo(stagiairePrecedent)) < 0) {

		    	
		    	gaucheEnfant = ligne.substring(82, 87).trim();
		    	//System.out.println("This is my gauche enfant " + gaucheEnfant);
		    	previousIndex = ligne.substring(0, 5);
		        //deleteRecursive(Integer.valueOf(gaucheEnfant), stagiaire, previousIndex, raf);
		        
			    try {
			    	int gaucheEnfantExist = Integer.valueOf(gaucheEnfant);
			    	deleteRecursive(gaucheEnfantExist, stagiaire, previousIndex, raf);
			    } catch (NumberFormatException e) {
			    	System.out.println("Ce stagiaire n'existe pas sur la gauche");
			    }
		        
		        return;
		    }
		    
		    
		    try {
		    	int droiteEnfantExist = Integer.valueOf(droiteEnfant);
		    	deleteRecursive(droiteEnfantExist, stagiaire, previousIndex, raf);
		    } catch (NumberFormatException e) {
		    	System.out.println("Ce stagiaire n'existe pas sur la droite");
		    }
		    
		    
		    return;
		    
		    } catch (IOException e) {
		    	
		    } finally {
		    	
		    }
	    }
	    
	    
	    //Méthode pour trouver le plus petit élèment de la branche de droite 
	  	public String findSmallestStagiaire(String enfantD, RandomAccessFile raf) {
	  		String index = "";
	  		try {
				raf.seek(Integer.valueOf(enfantD)*94);
	    		//on lit la ligne de l'enfant
				
				String ligneEnfant = ReadtoString(raf);
				
				String gaucheEnfant = ligneEnfant.substring(82, 87).trim();
				index = ligneEnfant.substring(0, 5).trim();
				if(gaucheEnfant.length() == 0) {
					return index;
				} else  {
					return findSmallestStagiaire(gaucheEnfant, raf);
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return index; 
	  		


	  	}
	  	
	  	private String ReadtoString(RandomAccessFile raf) {
	  		String ligne = "";
			try {
				byte[] ligneByte = new byte[93];
				raf.read(ligneByte);
				ligne = new String(ligneByte, StandardCharsets.ISO_8859_1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return ligne;
			
	  	}
	  	
	  	
	  	
	  	
	  	
	    //Méthode pour initialiser la suppression au noeud root
	    public void delete(Stagiaire stagiaire) {
	    	RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(fichier, "rw");
				deleteRecursive(0, stagiaire, "", raf);
			} catch (FileNotFoundException e) {
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
