package stacks;

public class EmpilerDepiler {

	public static void main(String[] args) {
		
		int qty = 10;
		double[] pile = new double[qty];
		double[] file = new double[qty];
		push(42, pile);
		push(18, pile);
		push(72, pile);
		pop(pile);
//		pop(pile);
		queue(42, file);
		queue(18, file);
		queue(72, file);
		UnQueue(file);
		UnQueue(file);
		
		for (int i = 0; i < pile.length; i++) {
			System.out.println(pile[i]);
		}
		
		for (int i = 0; i < file.length; i++) {
			System.out.println(file[i]);
		}


		
		
	}
	
	
	public static void push(double d, double[] pile) {
		
		for (int i = pile.length-1; i >= 0; i--) {
			if(pile[i] != 0.0) {
				pile[i+1] = pile[i];
			}
		}
		pile[0] = d;
	}
	public static void pop(double[] pile) {
		for (int i = 1; i < pile.length ; i++) {
			
			pile[i-1] = pile[i];
		}
		pile[pile.length-1] = 0.0;
	}
	
	public static void queue(double d, double[] file) {
		for (int i = file.length-1; i >= 0; i--) {
			if(file[i] != 0.0) {
				file[i+1] = file[i];
			}
		}
		file[0] = d;
	}
	public static void UnQueue(double[] file) {
		for (int i = file.length-1; i >= 0; i--) {
			if(file[i] != 0.0) {
				file[i] = 0.0;
				break;
			}
		}
	}
	
}
