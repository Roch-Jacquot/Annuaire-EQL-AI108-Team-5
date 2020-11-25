package fr.eql.ai108.heritage;

public class Lanceur {

	public static void main(String[] args) {

		//InstrumentDeMusique tambour = new InstrumentDeMusique("Tambour", "Tama", 78.12f);
		
		Basse jazzbass = new Basse("Jazz Bass", "Fender", 1500f, 4, false);

		
		InstrumentDeMusique stingray = new Basse("Stingray", "Music Man", 2000.45f, 5, true);
		
		
		Piano k500 = new Piano("K-500", "Kawai", 10909f, 88, "lourd");
		
		k500.faireDeLaMusique("Moonlight Sonata");
		
		InstrumentDeMusique primus = new Piano("Primus", "Seller", 15000.45f, 88, "dynamique");
		
		//Tous sont des instruments de musique; tous ont donc accès à la méthode faire de la musique
		
		System.out.println("La JAzz Bass fait ");
		jazzbass.faireDeLaMusique();
		
		System.out.println("La primus fait ");
		primus.faireDeLaMusique();
	
		
		//Comme tous mes objets sont des Instruments de Musique, je peux les placer dans une collection d'Instruments
		InstrumentDeMusique[] instruments = {jazzbass, stingray, k500, primus};
		
		for (InstrumentDeMusique instrumentDeMusique : instruments) {
			instrumentDeMusique.faireDeLaMusique();
			//instanceof est un operateur de comparaison qui permet de verifier le type reel d'une clsse
			if(instrumentDeMusique instanceof Piano) {
				System.out.println(instrumentDeMusique.getNom());
				//instrumentDeMusique.faireDeLaMusique("Experience");
				
				//Le casting
				Piano piano = (Piano) instrumentDeMusique;
				piano.faireDeLaMusique("Experience");
				((Piano) instrumentDeMusique).faireDeLaMusique("Eperience");
				
			}
		}
		
	}

}