package fr.eql.aiXXX.poo.tp;

public class Lanceur {

	public static void main(String[] args) {
		Serie got = new Serie("Game of Thrones", "Sur le continent de Westeros...", 8);
		got.presenterSerie();
		Serie discovery = new Serie("Star Trek: Discovery", "Deep in space ...", 3);
		discovery.presenterSerie();
		
		String[] monTab = {"Stannis Baratheon", "Petyr Baelish", "John Boredom"};
		
		
		got.setPersonnages(monTab);
		System.out.println(got.obtenirInitialesPersonnages());
		
		String initiales = got.obtenirInitialesPersonnages();
		
		System.out.println(initiales);
	}

}