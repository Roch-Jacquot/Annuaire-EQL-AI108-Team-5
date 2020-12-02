package classes.stagiaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import classes.tree.StagiaireTree;
import fr.eql.ai108.annuaireEQL.RechercheTableau;

public class StagiaireDao {
	StagiaireTree stagiaireTree;
	private File file;
	
	
	
	//M�thode pour transformer les lignes du RAF en objet Stagiaires
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
	
	//M�thode pour obtenir une ligne � partir d'un index
	public static String indexToString(String indexString) {
		RandomAccessFile raf = null;
		byte[] tab = new byte[93];
		String maLigne = null;
		int indexInt = 0;
		String path = "MonFichierFinal";
		try {
			raf = new RandomAccessFile(path, "r");
			indexInt = Integer.valueOf((indexString).trim());
			raf.seek(indexInt * 94);
			raf.read(tab);
			maLigne = new String(tab, StandardCharsets.ISO_8859_1);
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return maLigne;
	}
	
	//Methode pour r�cup�rer un stagiaire � partir de l'index
	public static  Stagiaire indexToStagiaire(String indexString) {
		return stringToStagiaire(indexToString(indexString));
	}
	
	public List<Stagiaire> getAll(){
		stagiaireTree = new StagiaireTree();
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires = stagiaireTree.traverseToListRaf();
		return stagiaires;	
	}
	public List<Stagiaire> getAllRecherche(Stagiaire stagiaireRecherche){
		stagiaireTree = new StagiaireTree();
		RechercheTableau maRecherche = new RechercheTableau();
		List<Stagiaire> stagiaires = new ArrayList<>();
		stagiaires = maRecherche.stagiairesRecherches(stagiaireRecherche);
		return stagiaires;	
	}
}