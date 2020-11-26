package fr.eql.ai108.TestBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	Node root;
	Node current;
	
    //Constructeurs
	public BinaryTree(Node root, Node current) {
		super();
		this.root = root;
		this.current = current;
	}

	public BinaryTree() {
		super();
	}

    //Méthode pour ajouter un élement int  
	private Node addRecursiveInt(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.value) {
	        current.left = addRecursiveInt(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursiveInt(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	    return current;
	}
	
	public void addInt(int value) {
	    root = addRecursiveInt(root, value);
	}
	
	//Méthode pour créer notre abre avec des valeurs exemples
	static BinaryTree createBinaryTree() {
	    BinaryTree bt = new BinaryTree();
	 
	    bt.addInt(6);
	    bt.addInt(4);
	    bt.addInt(8);
	    bt.addInt(3);
	    bt.addInt(7);
	    bt.addInt(9);
	 
	    return bt;
	}
	
	//Méthode pour chercher un élèment
		//Méthode récursive pour traverser l'arbre
		//Si la valeur n'est pas sur le noeud courant elle passe au noeud enfant jusqu'à tombé sur la bonne valeure
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    return value < current.value
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
		//Méthode pour que la recherche s'initialise sur le root
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
	//Méthode pour supprimer un élèment
		//De même, méthode qui parcourt l'arbre jusqu'à trouver le bon élèment
	private Node deleteRecursive(Node current, int value) {
	    if (current == null) {
	        return null;
	    }
	    if (value == current.value) {
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
	    	//On l'ajoute sur le noeud courant et on le supprime à son emplacement d'origin
	    	int smallestValue = findSmallestValue(current.right);
	    	current.value = smallestValue;
	    	current.right = deleteRecursive(current.right, smallestValue);
	    	return current;
	    } 
	    if (value < current.value) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, value);
	    return current;
	}
	
		//Méthode pour trouver le plus petit élèment de la branche de droite 
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
		//Méthode pour initialiser la suppression au noeud root
	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	
	//Méthodes pour rechercher des élèments
	//1- in-order traversal : branche gauche, root, puis branche droite (celle qu'on va utiliser)
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.value);
	        traverseInOrder(node.right);
	    }
	}
	//2- Pre-order traversal: root, puis gauche, puis droite
	public void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.value);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	//3- Post-order traversal: gauche, puis droite, puis root
	public void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.value);
	    }
	}
	
	//Initialisation de la méthode traverseInOrder au noeud root
	public void traverse() {
		traverseInOrder(root);
	}
	public void traversePreOrder() {
		traversePreOrder(root);
	}
	public void traversePostOrder() {
		traversePostOrder(root);
	}
	
	//Méthode traverseLevelOrder() affiche l'arbre ligne par ligne
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }
	 
	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	        Node node = nodes.remove(); //affecte le premier noeux à node
	        System.out.print(" " + node.value);
	        if (node.left != null) {
	            nodes.add(node.left);
	        }
	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getCurrent() {
		return current;
	}

	public void setCurrent(Node current) {
		this.current = current;
	}	
}