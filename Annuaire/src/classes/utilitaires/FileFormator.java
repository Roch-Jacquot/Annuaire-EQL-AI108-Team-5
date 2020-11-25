package classes.utilitaires;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileFormator {
	
	private int [] espaces;

	public static void main(String[] args) {
		
		creationFichier("C:/Users/formation/Downloads/stagiaires.txt", "test");

	}
	
	public FileFormator(String path, String resulat) {
		//espaces = compteEspaces(path);
		
	}
	
	
	
	public static void creationFichier(String path, String fichierResultat) {
		int [] espaces = compteEspaces(path);
		
		FileReader in = null;
		BufferedReader br = null;
		
		//RandomAccessFile raf = null;
		BufferedWriter bw = null;
		
		try {
			//instanciation des readers et writers
			//raf = new RandomAccessFile(fichierResultat, "rw");
			in = new FileReader(path);
			br = new BufferedReader(in);
			bw = new BufferedWriter(new FileWriter(fichierResultat));
			
			//Effacer l'ancien fichier
			File nettoyage = new File(fichierResultat);
			nettoyage.delete();

			//instncier mon ligne1 et mes variables de suivi
			int i = 0;
			int tab = 0;
			String ligne1;

			while((ligne1 = br.readLine()) != null) {
				
				ligne1 = ligne1.trim().replaceAll("[(|)]", "").replaceAll("( - )", "-");
				int nbLeft = 0;
				i ++;
				
				if(i%6 ==0 && i != espaces[5]) {
					bw.write("\n");
					tab = 0;
					
				}  else {
					
					if(tab ==0) {
						nbLeft = espaces[0] - ligne1.length();
		
					} else if(tab ==1) {
						ligne1 = ligne1.replaceAll("[0-9]", "").replaceAll("( -/)", "");
						nbLeft = espaces[tab] - ligne1.length();
	
					} else if(tab ==2) {
						

						try {
							int temp = Integer.parseInt(ligne1);
						} catch(NumberFormatException e) {
							ligne1 = "00";
						}
						
						
						if(ligne1.length() == 0){
							
							ligne1 ="00";
						}
						
						
						nbLeft = espaces[tab] - ligne1.length();
	
					} else if(tab ==3) {

						nbLeft = espaces[tab] - ligne1.length();
	
					} else if(tab ==4) {
						nbLeft = espaces[tab] - ligne1.length();
					}
					if(i != espaces[5]) {
						bw.write(ligne1);
						for (int j = 0; j < nbLeft; j++) {
							bw.write(" ");
						}
						tab ++;
					}

				
				}
					
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//raf.close();
				in.close();
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static int[] compteEspaces(String path) {
			
		FileReader in = null;
		BufferedReader br = null;
		int tailleNom = 0;
		int taillePrenom = 0;
		int tailleDepartement = 0;
		int taillePromo = 0;
		int tailleAnnee = 0;
		
		int maxNom = 0;
		int maxPrenom = 0;
		int maxDepartement = 0;
		int maxPromo = 0;
		int maxAnnee = 0;
		int tab = 0;
		int i = 0;
		
		try {
			in = new FileReader(path);
			br = new BufferedReader(in);
			String ligne1;
			while((ligne1 = br.readLine()) != null) {
				ligne1 = ligne1.trim().replaceAll("[(|)]", "");
				//System.out.println(ligne1);
				//System.out.println(ligne1.length());
				i ++;
				
				if(i %6 ==0) {
					tab = 0;
					tailleNom = 0;
					taillePrenom = 0;
					tailleDepartement = 0;
					taillePromo = 0;
					tailleAnnee = 0;
					tab = 0;
					//System.out.println("This is i: " + i);
				} else  {

					if(tab == 0) {
						tailleNom = ligne1.length();

					}
					if(tab == 1) {
						ligne1 = ligne1.replaceAll("[0-9]", "").replaceAll("( -/)", "");
						taillePrenom = ligne1.length();
						
					}
					if(tab == 2) {
						tailleDepartement = ligne1.length();
						
					}
					if(tab == 3) {
						taillePromo = ligne1.length();

						
					}
					if(tab == 4) {
						tailleAnnee = ligne1.length();
						
					}
					tab++;
				}
			//bloc comparaison
			if (tailleNom > maxNom) {
				maxNom = tailleNom;
			}
			if (taillePrenom > maxPrenom) {
				maxPrenom = taillePrenom;
			}
			if (tailleDepartement > maxDepartement) {
				maxDepartement = tailleDepartement;
			}
			if (taillePromo > maxPromo) {
				maxPromo = taillePromo;
			}
			if (tailleAnnee > maxAnnee) {
				maxAnnee = tailleAnnee;
			}
			
			//System.out.println("This is tab:" + tab);
			
}
				
				//Bloc réinitialisation pour la boucle


		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			
			try {
				br.close();
				in.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		}
		int[] resultat = {maxNom, maxPrenom, maxDepartement, maxPromo, maxAnnee, i};
		

		return resultat;
	}

	public int[] getEspaces() {
		return espaces;
	}

	public void setEspaces(int[] espaces) {
		this.espaces = espaces;
	}
	


}
