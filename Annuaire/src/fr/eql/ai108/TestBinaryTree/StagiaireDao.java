package fr.eql.ai108.TestBinaryTree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StagiaireDao {

	private File file;
	
	//Méthode pour transformer les lignes du RAF en objet Stagiaires
	private Stagiaire stringToStagiaire(String string) {
		
		return null;
	}
	
	//1.2 Méthode pour transformer les objets Stagiaires en arbre binaire
	private BinaryTreeStagiaire CreationArbre() {
		return null;
	}
	
	public List<Stagiaire> getAll(){
		
		//1. Création de l'arbre à partir du RAF
		
		
		//Brouillon
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
		
		//2. Cinvertion de l'arbre en liste de Stagiaires pour l'export vers le tableau
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires = btst.traverseToList();
		return stagiaires;	
	}
	
	
}