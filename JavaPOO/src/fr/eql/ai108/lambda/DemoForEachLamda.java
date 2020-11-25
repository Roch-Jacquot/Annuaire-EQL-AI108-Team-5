package fr.eql.ai108.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoForEachLamda {

	public static void main(String[] args) {


		List<String> items = new ArrayList<String>();
		Collections.addAll(items, "A", "B", "C", "D", "E");
		
		//Jusqu'� Java 7
		for (String string : items) {
			System.out.println("Java 7: " + string);
		}
		
		items.forEach(item -> System.out.println("Java 7: " + item));
		
		items.forEach(item -> {
			if(item.equals("C")) {
				System.out.println("item trouv� " + item);
			}
			
		});

	}

}