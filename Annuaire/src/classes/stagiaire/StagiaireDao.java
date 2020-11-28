package classes.stagiaire;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import fr.eql.ai108.TestBinaryTree.BinaryTreeStagiaire;

public class StagiaireDao {
	BinaryTreeStagiaire treeText;
	private File file;
	
	//Méthode pour transformer les lignes du RAF en objet Stagiaires
	public static Stagiaire stringToStagiaire(String maLigne) {
		String nom = maLigne.substring(5,35).trim();
		String prenom = maLigne.substring(35,65).trim();
		int departement = Integer.valueOf(maLigne.substring(65, 67));
		String promotion = maLigne.substring(67, 77).trim();
		int annee = Integer.valueOf(maLigne.substring(77, 81));
		String indexG = maLigne.substring(82, 87);
		String indexD = maLigne.substring(88, 93);
		Stagiaire currentStagiaire = new Stagiaire(nom, prenom, departement, promotion, annee);
		return currentStagiaire;
	}
	
	
	//1.2 Méthode pour transformer les objets Stagiaires en arbre binaire
	private BinaryTreeStagiaire CreationArbre() {
		return null;
	}
	
	public List<Stagiaire> getAll(){
		treeText = new BinaryTreeStagiaire();
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires = treeText.traverseToListRaf();
		return stagiaires;	
	}
}