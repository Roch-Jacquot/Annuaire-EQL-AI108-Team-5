package fr.eql.ai108.tp.bibliotheque.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bibliotheque {

	public static void main(String[] args) {
		System.out.println("Veulliez décliner votre identité. nom/prenom/adresse");
		Scanner scan = new Scanner(System.in);
		String nom = scan.nextLine();
		String prenom = scan.nextLine();
		String adresse = scan.nextLine();
		Lecteur lecteur = new Lecteur(nom, prenom, adresse);
		List<Livre> livres = new ArrayList<Livre>();
		Categorie cat[] = Categorie.values();
		
		Map<Categorie, List<Livre>> livreParCategorie = new HashMap<Categorie, List<Livre>>();
		
		boolean rester = true;
		
		do {
			System.out.println("\nBienvenue dans le menu principal\n");
			
			System.out.println("Vous avez les options suivantes :\n \n-Afficher votre identité à l'aide de la commande \"identité\" \n"
					+ "-Enregistrer des livres ou affiche la liste de livres enregistrés avec \"livres\" \n"
					+ "-Quitter le programme avec \"quitter\" ");
			
			String choix = scan.nextLine();
			switch (choix) {
				case "identité" :
						System.out.println("Voici votre identité");
						System.out.println("nom : " + lecteur.getNom() + ". prénom : " + lecteur.getPrenom() +
								". habitant au " + lecteur.getAdresse());
						break;
				case "livres" :
					
					if(livres.size() == 0) {
					
						System.out.println("Veuillez enregistrer vos livres");
						//enregistrerLivres(scan, cat, livres, lecteur, livreParCategorie);

							
					} else {
						System.out.println("Voulez vous ajouter des livres (indiquez \"ajouter\") ou "
								+ "afficher le contenu de votre bibliothère (indiquez \"lire\") ou "
								+ " afficher tous les livres d'une catégorie (indiquez \"categorie\") ?");
						String choixLivre = scan.nextLine();
						
						switch (choixLivre) {
						case "lire" : 
							System.out.println("Les livres enregistrés sont les suivants :");
							for(int i = 0; i < lecteur.getLivres().size(); i++) {
								System.out.println(lecteur.getLivres().get(i).getTitre() + " de " + lecteur.getLivres().get(i).getAuteur() + " avec isbn: " + 
										lecteur.getLivres().get(i).getIsbn() + " de type: " + lecteur.getLivres().get(i).getCategorie() + "\n");
							}
						break;
						case "ajouter" :
							//enregistrerLivres(scan, cat, livres, lecteur, livreParCategorie);
							break;
							
						case "categorie" :
							
							Categorie categorieChoisie = Categorie.valueOf(scan.nextLine());
							
							System.out.println(livreParCategorie.get(categorieChoisie));
							
						}
					}
					break;
				case "quitter" :
					System.out.println("Vous quittez l'application");
					rester = false;
					break;
			}
		}while (rester);
		
		scan.close();

	}
	
	public static void enregistrerLivres(Scanner scan, Categorie cat[], List<Livre> livres, Lecteur lecteur, Map<Categorie, Livre> livreParCategorie) {
		
		System.out.println("Combien de livres voulez-vous enregistrer ?");
		int nbLivres = scan.nextInt();
		scan.nextLine();
		
			for(int i = 0; i < nbLivres; i++) {
				System.out.println("Veuillez renseigner les informations du livre. titre/auteur/isbn");
				String titre1 = scan.nextLine();
				String auteur1 = scan.nextLine();
				int isbn1 = scan.nextInt();
				scan.nextLine();
				System.out.println("Veuillez aussi sélectionner le type de livre parmis les suivant");
				for(Categorie categ : cat) {
					System.out.println(categ);
				}
				String categorie1 = scan.nextLine().toUpperCase();
				Livre livre = new Livre(titre1, auteur1, isbn1, Categorie.valueOf(categorie1));
				livres.add(livre);
				livreParCategorie.put(livre.getCategorie(), livre);
				
			}
			lecteur.setLivres(livres);
		
	}

}
