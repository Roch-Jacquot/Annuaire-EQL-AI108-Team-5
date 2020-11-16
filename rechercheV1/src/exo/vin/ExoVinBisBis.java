package exo.vin;

// 2 - importer ligne i
//initialiser nos FileReaders et BufferedReaders.

// 2.1 créer tableau de taille max
	//Avec les résultat de la fonction compteEspaces (somme des valeurs pour la taille 
	//(98 + taille tableau d'espaces))

//initialisation du reader et writer


// 1 - charger fichier/lignes et boucler pour compter les tailles des categories.
// 1.0 - initialiser des variables de comptage par catégorie et
// initialiser les FileReader et le BufferedReader

// 1.1 ouverture d'une boucle while (temps qu'il reste des lignes)
// 1.2 Charger une ligne avec le le FileReader et le BufferedReader et
// initialiser des variables de comptage par catégorie
// 1.3 Boucler une fois sur la ligne et s'arrêter à "\t" pour compter la taille du nom;

// 2 - importer ligne i
//initialiser nos FileReaders et BufferedReaders.

// 2.1 créer tableau de taille max
//Avec les résultat de la fonction compteEspaces (somme des valeurs pour la taille 
//(98 + taille tableau d'espaces))

// 2.2 Remplir tableau par catégorie ? (voir tabulations)
// 2.3 - écrire tableau dans fichier




// 3 - Rechercher ?
// 3.1 - lire les X premiers octets
// 3.2 - utilsier un algo de tri sur ces octets et essayer d'echanger les lignes?





import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//C:/Users/formation/Desktop/WorkspaceAlgoAvance/algo-avancee/cours/tp vins/
public class ExoVinBisBis {

	public static void main(String[] args) {
		//System.out.println(Charset.defaultCharset().displayName());
		
		//Assignation des chemins
		String path = "c:/Users/formation/Desktop/WorkspaceAlgoAvance/algo-avancee/cours/tp vins/VINStp.DON";
		String fichierResultat = "c:/Users/formation/Desktop/WorkspaceAlgoAvance/algo-avancee/cours/tp vins/FICHIERFINAL.DON";
		int[] espaces = compteEspaces(path);
		//System.out.println(espaces[0] + espaces[1] + espaces[2] + espaces[3] + espaces[4] + espaces[5]);
		int tailleLigne = espaces[0] + espaces[1] + espaces[2] + espaces[3] + espaces[4] + espaces[5];
		int len = 390;
		
		//Creation du fichier nettoye
		
		//creationFichier(path, fichierResultat, espaces);
		
		
		RandomAccessFile raf = null;
		RandomAccessFile rafCherche = null;
		try {
			raf = new RandomAccessFile(fichierResultat, "rw");
			rafCherche = new RandomAccessFile(fichierResultat, "rw");

			//triTexte(raf, fichierResultat, espaces[0], len, tailleLigne);
			
			rechercheDichotomique("Ch�teau Suduiraut", rafCherche, espaces[0], tailleLigne);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				raf.close();
				rafCherche.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		


	}
	
	//
	//	TODO : modulariser les parties du codes qui se repetent :voir les boucles
	//
	
	 public static String copyStringVin(RandomAccessFile raf, int Selection, int i, int tailleLigne){
		 
	 int placement = i * tailleLigne;
	 String vinNom = "";
	 
	 try {
		raf.seek(placement);
		byte[] tab = new byte[Selection];
		raf.read(tab);
		vinNom = new String(tab);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return vinNom;
	 
}
	 
	public static void triTexte(RandomAccessFile raf, String chemin, int tailleNom, int len, int tailleLigne) {
		
	//int nbLigne = 390;
	
	//long tailleLigne = 0;
	
	try {
		//tailleLigne = raf.length()/nbLigne;
		
		
		if(len > 0){
			for (int i = 0; i < len-1; i++) {
				
				String premierVin = copyStringVin(raf, tailleNom, i, tailleLigne);
				String SecondVin = copyStringVin(raf, tailleNom, i+1, tailleLigne);
				//System.out.println("Mon premier vin est " + premierVin + " et mon second vin est " + SecondVin);
				
				if(premierVin.compareTo(SecondVin) > 0) {
					//System.out.println(premierVin + " vs " + SecondVin + "str est plus grande");
					//ligne originale
					premierVin = copyStringVin(raf, tailleLigne, i, tailleLigne);
					
					//ligne avec laquelle on va echanger
					SecondVin = copyStringVin(raf, tailleLigne, (i+1), tailleLigne);
					
					//System.out.println("Mon premier vin est " + premierVin + " et mon second vin est " + SecondVin);

					raf.seek(i*tailleLigne);
					
					raf.writeBytes(SecondVin);
					raf.writeBytes(premierVin);
		
				}
			}
			
			triTexte(raf, chemin, tailleNom, len - 1, tailleLigne);
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		
	}
	
	
	
}
	
	
	
	public static int[] compteEspaces(String path) {
		FileReader in = null;
		BufferedReader br = null;
		int tailleNom = 0;
		int tailleAppel = 0;
		int tailleRegion = 0;
		int tailleReference = 0;
		int tailleSurface = 0;
		int ref2 = 0;
		int tab = 0;
		int maxNom = 0;
		int maxAppel = 0;
		int maxRegion = 0;
		int maxReference = 0;
		int maxSurface = 0;
		int maxRef2 = 0;
		
			// 1.1 ouverture d'une boucle while (temps qu'il reste des lignes)
				// 1.2 Charger une ligne avec le le FileReader et le BufferedReader et
				// initialiser des variables de comptage par catégorie
				// 1.3 Boucler une fois sur la ligne et s'arrêter à "\t" pour compter la taille du nom;
		try {
			in = new FileReader(path);
			br = new BufferedReader(in);
			String ligne1;
			while((ligne1 = br.readLine()) != null) {
				//System.out.println(ligne1);
				for (int i = 0; i < ligne1.length(); i++) {
					
					if(ligne1.charAt(i) == '\t') {
						tab += 1;
						i +=1;
					}
					if(tab == 0) {
						tailleNom += 1;
					}
					if(tab == 1) {
						tailleAppel += 1;
					}
					if(tab == 2) {
						tailleRegion += 1;
					}
					if(tab == 3) {
						tailleReference += 1;
					}
					if(tab == 4) {
						tailleSurface += 1;
					}
					if(tab == 5) {
						ref2 += 1;
					}
					
				}
				//bloc comparaison
				if (tailleNom > maxNom) {
					maxNom = tailleNom;
				}
				if (tailleAppel > maxAppel) {
					maxAppel = tailleAppel;
				}
				if (tailleRegion > maxRegion) {
					maxRegion = tailleRegion;
				}
				if (tailleReference > maxReference) {
					maxReference = tailleReference;
				}
				if (tailleSurface > maxSurface) {
					maxSurface = tailleSurface;
				}
				if (ref2 > maxRef2) {
					maxRef2 = ref2;
				}
				
				//Bloc réinitialisation pour la boucle
				tab = 0;
				tailleNom = 0;
				tailleAppel = 0;
				tailleRegion = 0;
				tailleReference = 0;
				tailleSurface = 0;
				ref2 = 0;

			}

//			System.out.println(" LES MAX     nom: " + maxNom + " Appel: " + maxAppel + " region: " + maxRegion
//					+ " reference 1: " + maxReference + " Surface: " +  maxSurface +
//					" Ref2: " + maxRef2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		int[] resultat = {maxNom, maxAppel, maxRegion, maxReference, maxSurface, maxRef2};
		return resultat;
	}
	
	public static void creationFichier(String path, String fichierResultat, int[] espaces) {
		FileReader in = null;
		BufferedReader br = null;
		
//		FileWriter out = null;
//		BufferedWriter bw = null;
		RandomAccessFile raf = null;
		
		
		try {
			//instanciation des readers et writers
			raf = new RandomAccessFile(fichierResultat, "rw");
			in = new FileReader(path);
			br = new BufferedReader(in);
			
			//Effacer l'ancien fichier
			File nettoyage = new File(fichierResultat);
			nettoyage.delete();

			String ligne1 = br.readLine();
			//raf.write
			//raf.writeChar
			
			while(ligne1 != null) {
					
				int tab = 0;
				int tailleMot = 0;
				
				char[] ligneTableau = ligne1.toCharArray();
				
				for (int i = 0; i < ligneTableau.length; i++) {
					
					if(ligneTableau[i] != '\t') {
						raf.write(ligneTableau[i]);
						tailleMot ++;
					}
					
					if(ligneTableau[i] == '\t') {
						
						if(tab ==0) {
							
							int nbLeft = espaces[0] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								raf.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==1) {
							
							int nbLeft = espaces[1] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								raf.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==2) {
							
							int nbLeft = espaces[2] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								raf.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==3) {
							
							int nbLeft = espaces[3] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								raf.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==4) {
							
							int nbLeft = espaces[4] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								raf.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==5) {
							
							int nbLeft = espaces[5] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								raf.write(' ');
							}
							tailleMot = 0;
							tab ++;
						}
						
					}
					
				}
				ligne1 = br.readLine();	
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				raf.close();
				in.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void rechercheDichotomique(String recherche, RandomAccessFile raf, int Selection, int tailleLigne) {

		try {
			
			int test = 0;
			int debut = 0;
			long fin = raf.length();
			
			boolean trouve = false ;//flat 
			boolean rechercheTermine = false;
			
			for (int i = recherche.length(); i < Selection; i++) {
					recherche+= ' ';
			}
			
			
			while((!trouve && !rechercheTermine) /*&& test != 4*/) {
				
				System.out.print("Portion de " + debut + " a� " + fin + " : ");
				
				int milieu = (debut + (int) fin)/2;
				
				while(milieu % tailleLigne != 0) {
					milieu--;
				}
				
				raf.seek(milieu);
	
				byte[] tab = new byte[Selection];
				raf.read(tab);
				String valeurMilieu = new String(tab);
				System.out.println("Ma valeur du mileu est " + valeurMilieu);
				
				
				
				
				if(recherche.equals(valeurMilieu)) {
					raf.seek(milieu);
					byte[] tab2 = new byte[tailleLigne];
					raf.read(tab2);
					String valeurFinale = new String(tab2);
					System.out.println("Trouve !!! : " + valeurFinale);
					trouve = true;
					
				}
				
				if(valeurMilieu.compareTo(recherche) < 0) {
					
					System.out.println("Plus grand que " + valeurMilieu);
					debut = milieu + tailleLigne ;
					
				}
				
				if(valeurMilieu.compareTo(recherche) > 0) {
					
					System.out.println("Plus petit que " + valeurMilieu);
					fin = milieu ;
					
				}
				if(fin == -1 || debut == raf.length() || debut == fin) {
					rechercheTermine = true;
				}
				test ++;
				
			}
			
			if(!trouve) {
				System.out.println("Element non trouve");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
