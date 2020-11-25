package fr.eql.ai108.exception;

public class Lanceur {

	
	//Ici l'exception s'est propagée jusqu'au main et n'a jamais été gérée. Du coup, le programme cette de s'exécuter
//	public static void main(String[] args) throws Exception {
//
//
//		Calculatrice calc = new Calculatrice();
//		
//		double result = calc.diviser(20, 0);
//		
//		System.out.println("____________________________________________________");
//		System.out.println(result);
//
//	}
	
	

	public static void main(String[] args) {


		Calculatrice calc = new Calculatrice();
		
		double result = 0;
		//Essaye d'effectuer la division: try
		try {
			result = calc.diviser(20, 0);
			double resultAdd = calc.additionner(20, 150);
		//Si l'exception est jetée, attrape là et arrête de la propager
			
			//gerer les deux eceptions au même endroit
		} catch (DivisionParZeroException | GrandNombreException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("Attention, vous ne pouvez pas diviser par 0, le résutlat est faux");
//		}
//		catch (GrandNombreException e) {
//			// Je gère ici le GrandNombreException
//			
//			e.printStackTrace();
		} finally {
			System.out.println("Nettoyage");
		}
		
		
		//faire un bloc try/catch : 
//		try {
//			double resultAdd = calc.additionner(20, 150);
//		} catch (GrandNombreException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("____________________________________________________");
		System.out.println(result);

	}

}