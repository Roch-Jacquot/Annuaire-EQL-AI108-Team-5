package fr.eql.ai108.motcle;

import fr.eql.ai108.valref.Personne;

public class TestFinal {

	public static void main(String[] args) {
		// LE mot final permet de déclarer des valeurs constantes qui ne peuvent être modifiée
		//Cependant, il se comporte un peu dfferement pour les primitifs et les objets;
		
		//par convention, on écrit les constantes en UPPER_CASE
		final float PI = 3.141592f;
		
		//Pour un primitif; je ne peux pas changer la valeur d'une variable final une fois qu'une valeur est assignée
		//PI = 42;
		
		
		//Je peux modif la valeur des attributs d'un objet final
		final Personne OBERYN = new Personne("Martell", "Oberyn", 39);
		OBERYN.setAge(40);
		
		//Je ne peux pas assigner une nouvel object à la réference déclarée final
		//OBERYN = new Personne("toto", "tata", 999);
	}

}