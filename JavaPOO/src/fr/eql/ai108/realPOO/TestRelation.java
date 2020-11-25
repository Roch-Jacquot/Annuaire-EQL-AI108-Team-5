package fr.eql.ai108.realPOO;

public class TestRelation {

	public static void main(String[] args) {
		//instanciation de jouets:
		
		Jouet balle = new Jouet("balle", 5.50f);
		Jouet os = new Jouet("os", 3.50f);
		Jouet doudou = new Jouet("doudou", 8.50f);
		Jouet baton = new Jouet("baton", 0.0f);
		Jouet[] jouetsEin = {balle, os};
		Jouet[] jouetsLaika = {doudou, baton};
		Chien ein = new Chien("ein", 8, 0.070f, 7.45f, "Welsh Corgy", true, 'E', jouetsEin, GroupeChien.SPITZ);
		Collier collierEin = new Collier("rouge", "cuir");
		ein.setCollier(collierEin);
		System.out.println("Ein possède un collier en " + ein.getCollier().getMatiere() + " de couleur " + ein.getCollier().getCouleur()
				+ ".");
		
		//affichage jouets de Ein
		
		System.out.println("Jouets de Ein");
		
		for (int i = 0; i < ein.getJouets().length; i++) {
			System.out.println(ein.getJouets()[i].getLibelle() + " " + ein.getJouets()[i].getPrix());
		}
		
		//affichage du groupe de EIN
		System.out.println("Ein fait partie de la famille " + ein.getGroupe());
		
		
		
		Collier collierLaika = new Collier("jaune", "tissus");
		
		Chien Laika = new Chien("Laika", 12, 0.9f, 12.42f, "Berger Allemand",  true, 'L', collierLaika);
		System.out.println("Laika possède un colleir en " + Laika.getCollier().getMatiere() + " de couleur " + Laika.getCollier().getCouleur()
				+ ".");
		
		Laika.setJouets(jouetsLaika);
		
		//Affectation d'une valeur Enum par setter
		
		Laika.setGroupe(GroupeChien.BERGER);
		System.out.println(Laika.getGroupe());
		
		
		//Pour chaque jouet compris dans la collection de jouets de Laika que je réference localement par 
		//joujou
		for (Jouet joujou : Laika.getJouets()) {
			System.out.println(joujou.getLibelle() + " " + joujou.getPrix());
		}
		
		
		
		
		
	}

}