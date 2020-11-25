package fr.eql.aiXXX.poo.tp;

public class Serie {
	String titre;
	String synopsis;
	int nbSaison;
	String[] personnages;
	
	public Serie() {}
	
	public Serie(String titre, String synopsis, int nbSaison) {
		this.titre = titre;
		this.synopsis = synopsis;
		this.nbSaison = nbSaison;
	}

	public void presenterSerie() {
		System.out.println("Titre: " + titre + "\nSynopsis: " + synopsis +
				"\nNombre de saisons: " + nbSaison);
		
	}
	
	
	
	public String obtenirInitialesPersonnages() {
		String tps = "";
		String[] holder;
		for (int i = 0; i < personnages.length; i++) {
			holder = personnages[i].split(" ");
			tps += holder[0].charAt(0) + "." + holder[1].charAt(0) + ".\n";
			//tps += personnage[i] + "\n";
		}
		return tps;
	}
	
	
	public String[] getPersonnages() {
		return this.personnages;
	}
	public void setPersonnages(String[] personnage) {
		this.personnages = personnage;
	}
	
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getNbSaison() {
		return nbSaison;
	}

	public void setNbSaison(int nbSaison) {
		this.nbSaison = nbSaison;
	}

	
	
}