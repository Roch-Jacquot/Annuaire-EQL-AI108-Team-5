package exo.vin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
//C:/Users/formation/Desktop/WorkspaceAlgoAvance/algo-avancee/cours/tp vins/
public class ExoVin {

	public static void main(String[] args) {
		
		//Assignation des chemins
		String path = "c:/Users/formation/Desktop/WorkspaceAlgoAvance/algo-avancee/cours/tp vins/VINStp.DON";
		String fichierResultat = "c:/Users/formation/Desktop/WorkspaceAlgoAvance/algo-avancee/cours/tp vins/FICHIERFINAL.DON";
		int[] espaces = compteEspaces(path);
		System.out.println(espaces[0] + espaces[1] + espaces[2] + espaces[3] + espaces[4] + espaces[5]);
		
		//Creation du fichier nettoye
		creationFichier(path, fichierResultat, espaces);
		
		RandomAccessFile raf = null;
		//une ligne = 98; 98 ou 105
		int tailleLigne = 100;
		int tailleTotale = tailleLigne*390;
		//isoler la première partie LigneX*105 + 46
		try {
			raf = new RandomAccessFile(fichierResultat, "r");
//			raf.seek(100);
//			System.out.println(raf.readLine());
//			System.out.println(raf.getFilePointer());
			String i1 = "";
			
			for (int i = 0; i < tailleTotale; i += tailleLigne) {
				if(i == tailleLigne) {
					i1 += '\n';
				} 
				i1 += raf.readChar();
				System.out.println(i1);
				raf.seek(i + tailleLigne);
				
				//String i2 = raf.readLine();
				//System.out.println(i2);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
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
		*/
		
		
		
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
		

	}
	
	//
	//	TODO : modulariser les parties du codes qui se répètent :voir les boucles
	//
	
	
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
//				System.out.println("nom: " + tailleNom + " Appel: " + tailleAppel + " region: " + tailleRegion
//						+ " reference 1: " + tailleReference + " Surface: " +  tailleSurface +
//						" Ref2: " + ref2);
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
		
		FileWriter out = null;
		BufferedWriter bw = null;
		
		try {
			//instanciation des readers et writers
			in = new FileReader(path);
			br = new BufferedReader(in);
			out = new FileWriter(fichierResultat, true);
			bw = new BufferedWriter(out);
			int tab = 0;
			int tailleMot = 0;
			
			String ligne1;
			
			while(( ligne1 = br.readLine()) != null) {
				//System.out.println(ligne1);	
				for (int i = 0; i < ligne1.length(); i++) {
					
					if(ligne1.charAt(i) != '\t') {
						tailleMot ++;
						bw.write(ligne1.charAt(i));
					}
					
					if(ligne1.charAt(i) == '\t') {
						
						if(tab ==0) {
							
							int nbLeft = espaces[0] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								bw.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==1) {
							
							int nbLeft = espaces[1] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								bw.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==2) {
							
							int nbLeft = espaces[2] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								bw.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==3) {
							
							int nbLeft = espaces[3] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								bw.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==4) {
							
							int nbLeft = espaces[4] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								bw.write(' ');
							}
							tailleMot = 0;
							tab ++;
						} else if(tab ==5) {
							
							int nbLeft = espaces[5] - tailleMot;
							for (int j = 0; j < nbLeft; j++) {
								bw.write(' ');
							}
							tailleMot = 0;
							tab ++;
						}
						
					
						
					}
					//bw.write(ligne1.charAt(i));
				}
				bw.newLine();
				tab = 0;
				tailleMot = 0;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}