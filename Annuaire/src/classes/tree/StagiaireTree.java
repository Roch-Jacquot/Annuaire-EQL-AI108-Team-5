package classes.tree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import classes.stagiaire.Stagiaire;
import classes.stagiaire.StagiaireDao;
import classes.utilitaires.WritingFunctions;
import fr.eql.ai108.TestBinaryTree.Node;
import fr.eql.ai108.TestBinaryTree.NodeStagiaire;

public class StagiaireTree  {
	Stagiaire rootStagiaire;
	List<Stagiaire> stagiaires = new ArrayList<Stagiaire>(); 
	int index;
	String indexString;
	String path = "C:/Users/formation/Downloads/testStagiaire.txt";
	
	private RandomAccessFile raf = null;
	
	
	private void addRecursiveStagiaire(int current, Stagiaire stagiaire, String previousIndex, RandomAccessFile raf) {

		Stagiaire stagiairePrecedent = null;
			//placer ma ligne
		
			try {
				raf.seek(current*94);
				byte[] ligneByte = new byte[93];
				raf.read(ligneByte);
				String ligne = new String(ligneByte);
				
			    if (ligne.trim().length() == 0) { 
			    	
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
				    	System.out.println(current);
				    	
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
				
				e.printStackTrace();
			}

		


		    return;
		}
	
	
		public void add(Stagiaire stagiaire) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(path, "rw");
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
		
		
		
		

	//Formatage d'écriture :5 + 30, 30, 2, 10, 4 + 6, 6
	
	//Méthode pour retrouver l'emplacement d'un Stagiaire, qui retourne [indexPere, indexStagiaire, indexFilsG, indexFilsD]
	public String[] searchRecursiveStagiaire(String indexString, String indexPereString, Stagiaire stagiaire, String[] emplacementStagiaire) {
		
		Stagiaire currentStagiaire;
		RandomAccessFile raf;
		byte[] tab = new byte[93];
		String maLigne = null;
		String indexGString;
		String indexDString;
		
		//On instancie un objet stagiaire à partir de l'index courant
		currentStagiaire = StagiaireDao.indexToStagiaire(indexString);
		
		maLigne = StagiaireDao.indexToString(indexString);
		indexGString = maLigne.substring(82, 87);
		indexDString = maLigne.substring(88, 93);	
		
		//Récupération et envoi des index si le stagiaire est trouvé
	    if (stagiaire.compareTo(currentStagiaire) == 0) {
		emplacementStagiaire[0] = indexPereString;
		emplacementStagiaire[1] = indexString;
		emplacementStagiaire[2] = indexGString;
		emplacementStagiaire[3] = indexDString;
		
	    }
	    if (stagiaire.compareTo(currentStagiaire) < 0) {
	    	searchRecursiveStagiaire(indexGString, indexString, stagiaire, emplacementStagiaire);	
	    }
	    if (stagiaire.compareTo(currentStagiaire) > 0) {
	    	searchRecursiveStagiaire(indexDString, indexString, stagiaire, emplacementStagiaire);	
	    }
		return emplacementStagiaire;
	}
	
	//Initialisation
	public String[]searchStagiaire(Stagiaire stagiaire) {
		int nbIndex = 4;
		String[] emplacementStagiaire = new String[nbIndex];
		String indexString = "0    ";
		String indexPereString = null;
    return searchRecursiveStagiaire(indexString, indexPereString, stagiaire, emplacementStagiaire);
	}
	
  
    //1- in-order traversal to List: Retourne une liste d'objets stagiaires triées
  	public List<Stagiaire> traverseInOrderToListRaf(String indexString) {
  		String maLigne = null;
  		String indexG = null;
  		String indexD = null;
  		
  		Stagiaire currentStagiaire;
  		byte[] tab = new byte[93]; //To do: ajout d'une variable tailleLigne
  		RandomAccessFile raf = null;
  		
			try {
				raf = new RandomAccessFile(path, "r");
				if(!indexString.equals("     ")) {
				//On instancie un stagiaire à partir des infos du fihier texte 
				maLigne = StagiaireDao.indexToString(indexString);
				currentStagiaire = StagiaireDao.stringToStagiaire(maLigne);
				indexG = maLigne.substring(82, 87);
				indexD = maLigne.substring(88, 93);
				
				//Ajout du stagiaire du noeud courant à la liste de stagiaires
			    traverseInOrderToListRaf(indexG);
			    stagiaires.add(currentStagiaire);
			    traverseInOrderToListRaf(indexD);	
				} 
			   } catch (IOException e) {
				e.printStackTrace();
			   }finally {
				   try {
					   raf.close();
			   } catch (IOException e) {
					   e.printStackTrace();
			   }		   
	  	    }
			return stagiaires;
  	}
  	
  //Initialisation de la méthode à l'index 0
  	public List<Stagiaire> traverseToListRaf() {
  		indexString = "0";
  		return traverseInOrderToListRaf(indexString);
  	}
  	
  	public StagiaireTree(Stagiaire rootStagiaire, List<Stagiaire> stagiaires, int index, String indexString,
			String path) {
		super();
		this.rootStagiaire = rootStagiaire;
		this.stagiaires = stagiaires;
		this.index = index;
		this.indexString = indexString;
		this.path = path;
	}
	public StagiaireTree() {
		super();
	}
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	public String toString() {
		return "StagiaireTree [rootStagiaire=" + rootStagiaire + ", stagiaires=" + stagiaires + ", index=" + index
				+ ", indexString=" + indexString + ", path=" + path + "]";
	}
}
