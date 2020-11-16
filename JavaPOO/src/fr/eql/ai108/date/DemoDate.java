package fr.eql.ai108.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDate {

	public static void main(String[] args) {
		// instancier la date du jour
		Date date = new Date();
		


		//afficher une date
		//1ere m�thode: toString()
		System.out.println("Date du jour " + date);
		
		//2E m�thode: un objet SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Date du jour format�e " + sdf.format(date));
		
		
		//L'ann�e commence par 1900, le preimier mois commence � z�ro
		Date dateDepreciee = new Date(120, 10, 13);
		
		System.out.println("Date du jour " + dateDepreciee.toString());
		
		//Convertir une chaine de caracteres en date
		
		String dateAFormater = "02-04-2020 17:35:20";
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		try {
			Date newDate = sdf2.parse(dateAFormater);
			System.out.println("Date de " + dateAFormater + " devient " + newDate.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Comparer les java.util.date
		
		//1ere Methode: utiliser les methodes before(), after(), et equal()
		
		try {
			Date date1 = sdf.parse("17/07/1989");
			Date date2 = sdf.parse("15/10/2017");
			
			if(date1.after(date2)) {
				System.out.println("La date 2 est plus ancienne que la date 1");
			} else if(date1.before(date2)) {
				System.out.println("La date 2 est plus r�cente que la date 1");
			} else if (date1.equals(date2)) {
				System.out.println("La date 2 est la m�me que la date 1");
			}
			
			
			//2eme Methode: utiliser compareTo
			if(date1.compareTo(date2) > 0) {
				System.out.println("La date 2 est plus ancienne que la date 1");
			} else if(date1.compareTo(date2) < 0) {
				System.out.println("La date 1 est plus ancienne que la date 2");
			} else if (date.compareTo(date2) == 0) {
				System.out.println("Ce sont les m�mes dates");
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
