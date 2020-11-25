package fr.eql.ai108.bibliotheque.v3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LecteurDAO {
	
	public static void main(String[] args) {
		creerCompte("Jacquot", "Roch", "64 rue de mocuq", "123asd", "000000");
	}

	
	
	
	public static boolean creerCompte(String nom, String prenom, String adresse, String login, String password) {
		File file = new File("Bibliotheque");
		
		//boolean createFile = false;
		boolean createFolder;
		if(!file.exists()) {
			createFolder = file.mkdir();
			
		}

		File fileToCreate = new File("Bibliotheque/" + login + ".bib");
		boolean createFile;
		//Creation du fichier de login
		try {
			
			createFile = fileToCreate.createNewFile();
			if(createFile) {
				System.out.println("Fichier créé");
			} else {
				System.out.println("Fichier non créé");
			}
			
		} catch (IOException e1) {
			createFile = false;
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		FileWriter fileLogin = null;
		BufferedWriter bw = null;
		if(createFile) {
			try {
				fileLogin = new FileWriter(fileToCreate.getPath());
				bw = new BufferedWriter(fileLogin);
				bw.write(login);
				bw.newLine();
				bw.write(password);
				bw.newLine();
				bw.write(nom);
				bw.newLine();
				bw.write(prenom);
				bw.newLine();
				bw.write(adresse);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					bw.close();
					fileLogin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}
		return createFile;
	}
	
	public static Lecteur seConnecter(String login, String password) {
		
		
		
		return null;
		
		
		
	}
}