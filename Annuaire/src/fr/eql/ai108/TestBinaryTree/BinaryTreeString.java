package fr.eql.ai108.TestBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeString {

	NodeString rootString;
	Node current;
	
	//Méthode pour ajouter un String
		private NodeString addRecursiveString(NodeString current, String value) {
		    if (current == null) {
		        return new NodeString(value);
		    }
		 
		    if (value.compareTo(current.value) < 0) {
		        current.left = addRecursiveString(current.left, value);
		    } else if (value.compareTo(current.value) > 0) {
		        current.right = addRecursiveString(current.right, value);
		    } else {
		        // value already exists
		        return current;
		    }
		    return current;
		}
		public void add(String value) {
		    rootString = addRecursiveString(rootString, value);
		}
	
		//Méthode pour chercher un élèment
		private boolean containsNodeRecursiveString(NodeString current, String value) {
		    if (current == null) {
		        return false;
		    } 
		    if (value.equals(current.value)) {
		        return true;
		    } 
		    return value.compareTo(current.value) < 0
		      ? containsNodeRecursiveString(current.left, value)
		      : containsNodeRecursiveString(current.right, value);
		}
			//Méthode pour que la recherche s'initialise sur le root (synthaxe étrange à revoir, ca ne fonctionne pas)
		public boolean containsNodeString(String value) {
		    return containsNodeRecursiveString(rootString, value);
		}
		
		//Méthode pour supprimer un élèment
		//De même, méthode qui parcourt l'arbre jusqu'à trouver le bon élèment
	    private NodeString deleteRecursive(NodeString current, String value) {
	    if (current == null) {
	        return null;
	    }
	    if (value.equals(current.value)) {
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
	    	//On l'ajoute sur le noeud et courant et on le supprime à son emplacement d'origin
	    	
	    	String smallestValue = findSmallestValue(current.right);
	    	current.value = smallestValue;
	    	current.right = deleteRecursive(current.right, smallestValue);
	    	return current;
	    } 
	    if ((value.compareTo(current.value)) < 0) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, value);
	    return current;
	}
	
		//Méthode pour trouver le plus petit élèment de la branche de droite 
		private String findSmallestValue(NodeString root) {
			return root.left == null ? root.value : findSmallestValue(root.left);
		}
		
		//Méthode pour initialiser la suppression au noeud root
		public void delete(String value) {
		rootString = deleteRecursive(rootString, value);
		}	
		
		//Méthodes pour rechercher des élèments
		//1- in-order traversal : branche gauche, root, puis branche droite (celle qu'on va utiliser)
		public void traverseInOrder(NodeString node) {
		    if (node != null) {
		        traverseInOrder(node.left);
		        System.out.print(" " + node.value);
		        traverseInOrder(node.right);
		    }
		}
		
		//Initialisation de la méthode traverseInOrder au noeud root
		public void traverse() {
			traverseInOrder(rootString);
		}
		
		//Pour les avoir par lignes
		public void traverseLevelOrder() {
		    if (rootString == null) {
		        return;
		    }
		 
		    Queue<NodeString> nodes = new LinkedList<>();
		    nodes.add(rootString);
		 
		    while (!nodes.isEmpty()) {
		        NodeString node = nodes.remove(); //affecte le premier noeux à node
		        System.out.print(" " + node.value);
		        if (node.left != null) {
		            nodes.add(node.left);
		        }
		        if (node.right != null) {
		            nodes.add(node.right);
		        }
		    }
		}

		public BinaryTreeString() {
			super();
			// TODO Auto-generated constructor stub
		}
		public BinaryTreeString(NodeString rootString, Node current) {
			super();
			this.rootString = rootString;
			this.current = current;
		}
		public NodeString getRootString() {
			return rootString;
		}
		public void setRootString(NodeString rootString) {
			this.rootString = rootString;
		}
		public Node getCurrent() {
			return current;
		}
		public void setCurrent(Node current) {
			this.current = current;
		}	
}
