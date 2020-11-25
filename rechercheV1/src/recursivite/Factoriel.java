package recursivite;

public class Factoriel {

	public static void main(String[] args) {
		int x = factoriel(3);
		System.out.println(x);

		
		int y = factorielB(3);
		System.out.println(y);
	}
	
	public static int factoriel(int n) {
		System.out.println(n);
		
		if(n == 1) {
			return 1;
		}
		
		return n*factoriel(n-1);
		
	}
	public static int factorielB(int n) {
		int res = 1;
		for(int i = 1; i <= n; i++) {
			res *= i;
		}
		return res ;
	}

}