package fr.eql.ai108.tp.bibliotheque;

import java.util.Scanner;

public class Bibliotheque {

	public static void main(String[] args) {
		System.out.println("Veulliez décliner votre identité. nom/prenom/adresse");
		Scanner scan = new Scanner(System.in);
		String nom = scan.nextLine();
		String prenom = scan.nextLine();
		String adresse = scan.nextLine();
		Lecteur lecteur = new Lecteur(nom, prenom, adresse);
		Livre[] livres = null;
		Categorie cat[] = Categorie.values();
		// Verif System.out.println(lecteur.getNom() + " " + lecteur.getPrenom() + " " + lecteur.getAdresse());
		
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
					
					if(livres == null) {
					
						System.out.println("Veuillez enregistrer vos livres");
						System.out.println("Combien de livres voulez-vous enregistrer ?");
						int nbLivres = scan.nextInt();
						scan.nextLine();
						livres = new Livre[nbLivres];
						
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
								livres[i] = livre;
								
							}
							lecteur.setLivres(livres);
							
					} else {
						
						System.out.println("Les livres enregistrés sont les suivants :");
						for(int i = 0; i < lecteur.getLivres().length; i++) {
							System.out.println(lecteur.getLivres()[i].getTitre() + " de " + lecteur.getLivres()[i].getAuteur() + " avec isbn: " + 
									lecteur.getLivres()[i].getIsbn() + " de type: " + lecteur.getLivres()[i].getCategorie() + "\n");
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

}