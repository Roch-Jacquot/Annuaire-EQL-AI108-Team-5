package tri;

public class TriBulle {

	public static void main(String[] args) {
		int[] t = {2, 4, 9, 5, 5, 1, 7,12, 45, 1, 3, 6, 1, 2};
		
		triBulle(t, t.length);
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + ", ");
		}

	}
	
	
	
	public static void triBulle(int tab[], int len) {
		
		if(len > 0) {
			for (int i = 0; i < len-1; i++) {
				if(tab[i] > tab[i+1]) {
					int temp = tab[i];
					tab[i] = tab[i+1];
					tab[i+1] = temp;
				}
			}
			triBulle(tab, len-1);
		}
	}
		

}
