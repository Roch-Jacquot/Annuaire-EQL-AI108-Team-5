package fr.eql.ai108.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DemoTime {

	public static void main(String[] args) {
		// LocalDate, LocalTime, LocalDateTime, ZonesDateTime
		
		//Date d'aujourd'hui
		LocalDate dateAjd = LocalDate.now();
		System.out.println("Aujourd'hui nous sommes: " + dateAjd);
		
		
		//Date pr�cise: l'ann�e ne commence plus � 1900 et l'index des mois commence � un
		LocalDate uneDate = LocalDate.of(2017, 1, 25);
		System.out.println(uneDate);
		
		//Modifier une date avec la m�thode "with"
		LocalDate dateModifiee = uneDate.withYear(2020);
		System.out.println(dateModifiee);
		
		//Convertir la chaine en date en lui donnant un pattern
		LocalDate dateParsee = LocalDate.parse("2017-02-09", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Date format�e " + dateParsee);
		
		
		//Incr�menter ou d�cr�menter la date +- 
		//ajouter un jour
		LocalDate dateIncrementJour = uneDate.plusDays(32);
		System.out.println(dateIncrementJour);
		
		
		//Enlever un mois*
		LocalDate dateDecrementerMois = uneDate.minusMonths(2);
		System.out.println(dateDecrementerMois);
		
		
		//LOCALTIME : Time sans date
		LocalTime maintenant = LocalTime.now();
		System.out.println(maintenant);
		
		LocalTime heureParsee = LocalTime.parse("17:45");
		System.out.println(heureParsee);
		
		LocalTime ajoutMinute = heureParsee.plusMinutes(30);
		System.out.println(ajoutMinute);
		
		//ZonesDateTime
		ZonedDateTime zoneDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		System.out.println(zoneDateTime);
		
		ZonedDateTime australiaSydneyZonesDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Australia/Sydney"));
		System.out.println(australiaSydneyZonesDateTime);
	}

}
