package fr.eql.ai108.lambda;

import java.util.HashMap;
import java.util.Map;

public class DemoForEachMapLamda {

	public static void main(String[] args) {

		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("Navet", 2);
		items.put("Orange", 8);
		items.put("Banane", 3);
		items.put("Kiwi", 4);
		items.put("Fraise", 12);

		
		//Java 7 
		for(Map.Entry<String, Integer> entry : items.entrySet()) {
			
			System.out.println("Item: " + entry.getKey() + "Value: " + entry.getValue());
		}
		
		
			//Java 8
		items.forEach((k,v) -> System.out.println("Item: " + k + " Values: " + v));
		
		
		
	}

}