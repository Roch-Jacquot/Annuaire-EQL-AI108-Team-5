package fr.eql.ai108.valref;

public class Personne implements Comparable<Personne>{
	
	private String nom;
	private String prenom;
	private int age;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	
	@Override
	public int compareTo(Personne p) {
		int i = this.nom.compareTo(p.nom);
		if(i ==0) {
			i = this.prenom.compareTo(p.prenom);
			if(i ==0) {
				i = this.age - p.age;
			}
		} 
		return i;
	}
	
	
	
}