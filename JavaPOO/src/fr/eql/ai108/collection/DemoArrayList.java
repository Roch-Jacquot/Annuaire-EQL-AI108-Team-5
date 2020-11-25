package fr.eql.ai108.collection;

import java.util.ArrayList;
import java.util.List;

import fr.eql.ai108.valref.Personne;

public class DemoArrayList {

	public static void main(String[] args) {
		// instancier un ArrayList de personne

		List<Personne> personnes = new ArrayList<Personne>();
		
		Personne sacha = new Personne("de Bourg Palette", "Sacha", 12);
		Personne pierre = new Personne("d'Argenta", "Pierre", 14);
		Personne ondine = new Personne("d'Azuria", "Ondine", 13);
		
		//La méthode add(Object o) permet d'ajouter des objets à la lsite
		
		personnes.add(sacha);
		personnes.add(sacha);
		personnes.add(sacha);
		personnes.add(sacha);
		personnes.add(pierre);
		personnes.add(ondine);
		
		//size() : taille liste
		
		System.out.println(personnes.size());
	
	
		for(Personne personne : personnes) {
			System.out.println(personne);
		}
	
		//récupérer un index à partir de la référence de mon instance.
		int indexSacha = personnes.indexOf(sacha);
		System.out.println("Index de Sacha " + indexSacha);
		
		//Recup à partir d'un index
		
		Personne persIndex2 = personnes.get(2);
		System.out.println(persIndex2);
	
		
		//retorer
		
		personnes.remove(pierre);
		
		for(Personne personne : personnes) {
			System.out.println(personne);
		}
	}
}