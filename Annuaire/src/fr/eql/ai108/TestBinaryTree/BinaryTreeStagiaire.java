package fr.eql.ai108.TestBinaryTree;

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

public class BinaryTreeStagiaire {
	NodeStagiaire root;
	Node current;
	List<Stagiaire> stagiaires = new ArrayList<Stagiaire>(); 
	int index;
	String index2;
	String path = "C:/Users/formation/Downloads/testStagiaire.txt";

	

	//Formatage d'écriture :5 + 30, 30, 2, 10, 4 + 6, 6
	
	//Méthode pour ajouter un String
	private NodeStagiaire addRecursiveStagiaire(NodeStagiaire current, Stagiaire stagiaire, String previousIndex) {
		
		RandomAccessFile raf = null;
	    if (current == null) {
	    	NodeStagiaire aStagiaire = new NodeStagiaire(stagiaire, index);
	    	
	    	WritingFunctions.ecrireAjout(raf, path, aStagiaire, previousIndex);
	    	
	    	index++;
	        return aStagiaire;
	    }
	 
	    if (stagiaire.compareTo(current.stagiaire) < 0) {
	    	previousIndex = current.getIndex() + "G";
	    	
	        current.left = addRecursiveStagiaire(current.left, stagiaire, previousIndex);
	    } else if (stagiaire.compareTo(current.stagiaire) > 0) {
	    	
	    	previousIndex = current.getIndex() + "D";
	    	
	        current.right = addRecursiveStagiaire(current.right, stagiaire, previousIndex);
	    } else {
	        // value already exists
	        return current;
	    }
	    return current;
	}
	public void add(Stagiaire stagiaire) {
	    root = addRecursiveStagiaire(root, stagiaire, "");
	}
	
	//Méthode pour chercher un élèment
	private boolean containsNodeRecursiveStagiaire(NodeStagiaire current, Stagiaire stagiaire) {
		if (current == null) {
	        return false; 
	    } 
	    if (stagiaire.compareTo(current.stagiaire) == 0) {
	        return true;
	    }
	    return stagiaire.compareTo(current.stagiaire) < 0
	      ? containsNodeRecursiveStagiaire(current.left, stagiaire)
	      : containsNodeRecursiveStagiaire(current.right, stagiaire);
	}
	
	//Méthode pour que la recherche s'initialise sur le root (synthaxe étrange à revoir, ca ne fonctionne pas)
	public boolean containsNodeStagiaire(Stagiaire stagiaire) {
    return containsNodeRecursiveStagiaire(root, stagiaire);
	}
	
	//Méthode pour supprimer un élèment
	//De même, méthode qui parcourt l'arbre jusqu'à trouver le bon élèment
    private NodeStagiaire deleteRecursive(NodeStagiaire current, Stagiaire stagiaire) {
    if (current == null) {
        return null;
    }
    if (stagiaire.compareTo(current.stagiaire) == 0) {
        // Node to delete found, on le supprime avec le code suivant:
    	// S'il n'a aucun enfant il suffit de lui affecter la valeur null
    	if (current.left == null && current.right == null) {
    	    return null;
    	}
        // S'il n'a qu'un seul enfant, il suffit de le remplacer par celui-ci
    	if (current.right == null) {
    	    return current.left;
    	}
    	 
    	if (current.left == null) {
    	    return current.right;
    	}
    	//S'il a deux enfants, il faut ré-organiser l'arbre
    	//On cherche le plus petit noeud de la branche de droite afin d'avoir une valeur "moyenne"
    	//On l'ajoute sur le noeud  courant et on le supprime à son emplacement d'origine
    	
    	Stagiaire smallestValue = findSmallestStagiaire(current.right);
    	current.stagiaire = smallestValue;
    	current.right = deleteRecursive(current.right, stagiaire);
    	return current;
	    } 
	    if ((stagiaire.compareTo(current.stagiaire)) < 0) {
	        current.left = deleteRecursive(current.left, stagiaire);
	        return current;
	    }
	    
	    current.right = deleteRecursive(current.right, stagiaire);
	    return current;
	    }
    
    //Méthode pour trouver le plus petit élèment de la branche de droite 
  	private Stagiaire findSmallestStagiaire(NodeStagiaire root) {
  		return root.left == null ? root.stagiaire : findSmallestStagiaire(root.left);
  	}
    //Méthode pour initialiser la suppression au noeud root
    public void delete(Stagiaire stagiaire) {
    	root = deleteRecursive(root, stagiaire);
  	}
    //Méthodes pour rechercher des élèments
  	//in-order traversal : branche gauche, root, puis branche droite (celle qu'on va utiliser)
  	public void traverseInOrder(NodeStagiaire node) {
  		 if (node != null) {
  		   traverseInOrder(node.left);
  		   System.out.print(" " + node.stagiaire + "\r");
  		   traverseInOrder(node.right);
  		 }
    }
    //Initialisation de la méthode traverseInOrder au noeud root
  	public void traverse() {
  		traverseInOrder(root);
  	}
  	
  	//1- in-order traversal to List: On fait la même mais en retournant une liste d'objets
  	public List<Stagiaire> traverseInOrderToList(NodeStagiaire node) {
  		 if (node != null) {
  		   traverseInOrderToList(node.left);
  		   stagiaires.add(node.stagiaire);
  		   traverseInOrderToList(node.right);
  		 }
		return stagiaires;
    }
    //Initialisation de la méthode traverseToList au noeud root
  	public List<Stagiaire> traverseToList() {
  		return traverseInOrderToList(root);
  	}
  	
 
  	
  //1- in-order traversal to List: On fait la même en travaillant directement sur le RAF
  	public List<Stagiaire> traverseInOrderToListRaf(String index2) {
  		
  		String nom = null;
  		String prenom = null;
  		String promotion = null;
  		String maLigne = null;
  		String indexG = null;
  		String indexD = null;
  		int departement = 0;
  		int annee = 0;
  		int indexInt = 0;
  		
  		Stagiaire currentStagiaire;
  		byte[] tab = new byte[93]; //ajout d'une variable taille
  		RandomAccessFile raf = null;
  		
  		
			try {
				raf = new RandomAccessFile(path, "r");
				if(!index2.equals("     ")) {
				//Positionnement du pointeur
				indexInt = Integer.valueOf((index2).trim());
				raf.seek(indexInt * 94);
				raf.read(tab);
				
				//On instancie un stagiaire à partir des infos du fihier texte 
				maLigne = new String(tab);
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
  		index2 = "0";
  		return traverseInOrderToListRaf(index2);
  	}
  	

 
	//Pour les avoir par lignes
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }
	 
	    Queue<NodeStagiaire> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	        NodeStagiaire node = nodes.remove(); //affecte le premier noeux à node
	        System.out.print(" " + node.stagiaire + "\r");
	        if (node.left != null) {
	            nodes.add(node.left);
	        }
	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
	}
	
	public NodeStagiaire getRoot() {
		return root;
	}
	public void setRoot(NodeStagiaire root) {
		this.root = root;
	}
	public Node getCurrent() {
		return current;
	}
	public void setCurrent(Node current) {
		this.current = current;
	}
	public BinaryTreeStagiaire(NodeStagiaire root, Node current) {
		super();
		this.root = root;
		this.current = current;
		
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(path, "rw");
			this.index = (int) raf.length()/70;
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
	public BinaryTreeStagiaire() {
		super();
	}
	public String toString() {
		return "BinaryTreeStagiaire [root=" + root + ", current=" + current + "]";
	}
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
}
