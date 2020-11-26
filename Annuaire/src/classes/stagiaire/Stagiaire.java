package classes.stagiaire;

import java.util.Comparator;

public class Stagiaire implements Comparable<Stagiaire> {
	
	private String nom;
	private String prenom;
	private int departement;
	private String promotion;
	private int annee;
	private String identifiant;

	
	public Stagiaire() {
		super();
	}
	

	public Stagiaire(String nom, String prenom, int departement, String promotion, int annee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.promotion = promotion;
		this.annee = annee;
		this.identifiant = nom+prenom;
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + departement;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((promotion == null) ? 0 : promotion.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		if (annee != other.annee)
			return false;
		if (departement != other.departement)
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (promotion == null) {
			if (other.promotion != null)
				return false;
		} else if (!promotion.equals(other.promotion))
			return false;
		return true;
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	@Override
	public String toString() {
		return "Stagiaire nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + ", promotion="
				+ promotion + ", annee=" + annee + ", identifiant=" + identifiant;
	}


	@Override
	public int compareTo(Stagiaire stagiaire) {
		
		return identifiant.compareTo(stagiaire.getIdentifiant());
	}


	
	

}
