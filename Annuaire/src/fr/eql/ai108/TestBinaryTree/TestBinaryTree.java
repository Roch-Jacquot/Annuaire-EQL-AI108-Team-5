package fr.eql.ai108.TestBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class TestBinaryTree {
	private BinaryTreeStagiaire btst;
	
	public static void main(String[] args) {	
	//test avec des int	
		BinaryTree bt = new BinaryTree();
		bt.addInt(5);
		bt.addInt(3);
		bt.addInt(7);
		bt.addInt(1);
		bt.addInt(4);
		bt.addInt(6);
		bt.addInt(8);
		//bt.traverse();
		//System.out.println("\r");
		//bt.traversePreOrder();
		//System.out.println("\n");
		//bt.traversePostOrder();
		//System.out.println("\r");
		//bt.traverseLevelOrder();
		
	//test avec des Strings
		BinaryTreeString bts = new BinaryTreeString();
		bts.add("b");
		bts.add("a");
		bts.add("f");
		bts.add("d");
		bts.add("e");
		bts.add("c");
		bts.add("g");
		
//		bts.containsNodeString("d");
//		bts.delete("d");
//		bts.containsNodeString("d");
//		System.out.println("\r");
//		bts.traverse();
//		System.out.println("\r");
//		bts.traverseLevelOrder();
		
		//Avec un objet stagiaire
		
		Stagiaire stagiaire1 = new Stagiaire("Jean", "Marc", 75, "AI108", 2020);
		Stagiaire stagiaire2 = new Stagiaire("Durant", "Julie", 91, "AI108", 2020);
		Stagiaire stagiaire3 = new Stagiaire("Dupont", "Romain", 92, "AI108", 2020);
		Stagiaire stagiaire4 = new Stagiaire("Dupond", "Kevin", 93, "AI108", 2020);
		Stagiaire stagiaire5 = new Stagiaire("Trump", "Marc", 94, "AI108", 2020);
		Stagiaire stagiaire6 = new Stagiaire("Bidden", "Antoine", 94, "AI108", 2020);
		Stagiaire stagiaire7 = new Stagiaire("Louvet", "William", 94, "AI108", 2020);
		Stagiaire stagiaire8 = new Stagiaire("Deschamps", "Marcus", 94, "AI108", 2020);
		BinaryTreeStagiaire btst = new BinaryTreeStagiaire();
		btst.add(stagiaire1);
		btst.add(stagiaire2);
		btst.add(stagiaire3);
		btst.add(stagiaire4);
		btst.add(stagiaire5);
		btst.add(stagiaire6);
		btst.add(stagiaire7);
		btst.add(stagiaire8);
		System.out.println(btst.containsNodeStagiaire(stagiaire2));
		btst.delete(stagiaire2);
		System.out.println(btst.containsNodeStagiaire(stagiaire2));
		btst.traverse();
		
		//Stockage des valeurs dans une liste d'objets
		System.out.println("\r\n" + btst.traverseToList());
		
	}
}
