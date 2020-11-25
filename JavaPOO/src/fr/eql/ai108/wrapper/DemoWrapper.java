package fr.eql.ai108.wrapper;

public class DemoWrapper {

	public static void main(String[] args) {
		// Les wrappers ou classe enveloppes permettent d'encapsuler des types primitifs
		//Chaque type primitif possède sa classe evelopppe qui lui permet de se comporter comme un objet
		
		//Boolean : pour le type boolean (16 bits)
		//Integer: pour le type int (16 bits)
		//Byte : pour le type byte (16 bits)
		//Short : pour le type short (16 bits)
		//Long : pour le type long (24 bits)
		//Float pour le type float (16 bits)
		//Double pour le type ddouble (24 bits)
		//Character pour le type char (16 bits)
		
		
		//Les wrappers sont nullables
		//int i = null;
		Integer unInteger = null;

		//Un wrapper peut être instancié
		Integer unAutreInteger = new Integer(12);
		System.out.println(unAutreInteger);
		
		//pour simplifier leur écriture, l'instanciation n'est pas nécessaire
		//C'est de l'autoboxing
		Float f= 3.45f;
		
		//Chaque wrapper (Sauf Character) possède une méthode qu s'appelle parseXXX(String str) qui permet de renvoyer un type
		//primitif à partir d'une chiane de charactères
		
		double d = Double.parseDouble("42.2222");
	
		//Chaque wrapper (Sauf Character) possède une méthode valueOf(String str), qui permet cette fois de renvoyer un type objet
		//à partir d'une chaine de caractères
		
		Boolean bool = Boolean.valueOf("true");
	
	
	}

}