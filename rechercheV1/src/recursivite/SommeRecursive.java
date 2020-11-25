package recursivite;

public class SommeRecursive {

	public static void main(String[] args) {
		int[] tab = {1,2,3,4,5};
		
		int resultat = somme(tab, 4);
		
		System.out.println(resultat);
		
	}
	
	
	public static int somme(int[] tab, int longueur) { 
		int res = 0;
		if(longueur ==0) {
			return 0;
		}
		
		for(int i = 0; i < longueur; i++) {
			res += tab[i];
		}
		System.out.println(res);
		return res + somme(tab, longueur-1);
	}

}