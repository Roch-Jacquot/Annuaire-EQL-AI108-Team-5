package tri;

public class TriRapide {

	public static void main(String[] args) {
		int[] t = {45, 4, 9, 2, 5, 5, 1, 7,12, 45, 1, 3, 1, 4};
		//int[] t = {5,7,2,9,4,3,1,8,6};

		//int x = partition(t, 0, t.length-1);
		//int y = partition(t, 0, x-1);
		//int z = partition(t, 0, y-1);
		
		//int a = partition(t, x+1, t.length-1);
		
		triRapide(t, 0, t.length-1);
		System.out.println();
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + ", ");
		}
		//System.out.println("\nThis is my first pivot " + x + " and this is my second pivlot " + y);

	}
	
	
	
	public static void triRapide(int[] tab, int debut, int fin) {
		
		if(debut < fin) {
			int pos = partition(tab, debut, fin);
			triRapide(tab, debut, pos-1);
			triRapide(tab, pos + 1, fin);
			
		}
		
		
	}
	
	public static int partition(int[] tab, int debut, int fin) {
		//choisir Pivot
		int pivot = fin;
		//permutations
		System.out.println("My currrent pivot is " + tab[pivot]);
		
		for (int i = debut; i <= fin; i++) {
			//System.out.println("Current i in loop " + i);
			
			for (int j = fin-1; j >= debut; j--) {
				if(tab[j] > tab[pivot]) {
					//System.out.println("Dans le preimier if avec tab[j] = " + tab[j]);
					int temp = tab[j];
					tab[j] = tab[pivot];
					tab[pivot] = temp;
					pivot = j;
					System.out.println("After the first loop, the pivot is " + tab[pivot]);
				}
				if(tab[i] <= tab[j] && i != 0) {
					//System.out.println("Dans le second if avec tab[i] = " + tab[i] + " et tab[j] = " + tab[j]);
					//System.out.println();
					int temp = tab[i];
					tab[i] = tab[j];
					tab[j] = temp;
					pivot = i;
					System.out.println("This is the pivot value " + tab[pivot] + " this is tab[i] " + tab[i] + " and this is tab[j] " + tab[j]);
				}
				//System.out.println("In the condition i = " + i + ", condition j = " + j + ", tab[i] = " + tab[i] + " tab[pivot] = " + tab[pivot] + " et indice " + pivot);
			}
		}
		for (int i = debut; i < fin+1; i++) {
			System.out.print(tab[i] + ", ");
		}
		
		//System.out.println("In the condition i = " + i + ", tab[i] = " + tab[i] + " tab[pivot] = " + tab[pivot] + " et indice "
		
		System.out.println("Number Pivot = " + tab[pivot]);
		return pivot;
		
	}

}
