package tri;

public class TriSelection {

	public static void main(String[] args) {
		int[] t = {2, 4, 9, 5, 5, 7,12, 45, 1, 3, 6, 1, 2};
		
		triSelection(t);
		
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + ", ");
		}

	}
	
	
	public static void triSelection(int[] tab) {
		
		int len = tab.length;
		
		for (int i = 0; i < tab.length; i++) {
			int temp = 0;
			
			for (int j = 1; j < len; j++) {
				if(tab[j] > tab[temp]) {
					//System.out.println("tab[j] " + tab[j] + " is bigger than tab[temp] " + tab[temp]);
					temp = j;
				}
			}
			
			int varTemp = tab[temp];
			tab[temp] = tab[len-1];
			tab[len-1] = varTemp;
			
			len = len - 1;
			
			//System.out.println("Boocle " + i);
		}

	}

}
