package fr.eql.ai108.poo;

public class DemoString {

	public static void main(String[] args) {
		String uneString = "Une chaine de caractères est un objet; "
				+ "elle possède donc des methodes d'instances";
		
		String uneStringVide = "";
		
		//Une méthode pour obtenir sa taille
		
		System.out.println(uneString.length());
		System.out.println(uneStringVide.length());
		
		//Une méthode pour vérifier si la chaine est vide ou pas
		
		System.out.println(uneString.isEmpty());
		System.out.println(uneStringVide.isEmpty());
		
		//Une méthode de comparaison
		
		System.out.println(uneString.equals(uneStringVide));
		
		//Méthode de découpage de chaine
		System.out.println(uneString.substring(4));
		System.out.println(uneString.substring(9,18));
		
		//Des méthodes qui changent la csse de ma chaine:
		System.out.println(uneString.toLowerCase());
		System.out.println(uneString.toUpperCase());
		
		//Une méthode pour enlever les espqces avant et après ma chaine
		String derniereString = "          blablabla            ";
		System.out.println(derniereString.trim());
	
		
		//Une méthode split qui permet de découper une chaine de caractères en fonction d'un séparateur
		String[] split = uneString.split(";");
		System.out.println(split[0] + " --- et ---" + split[1]);
		
		
		//remplacer des caractères
		String romain = uneString.replace("objet", "toto").replace("d'instances", "de tata").toUpperCase();
		
	System.out.println(romain);
		
		
		
	}

}