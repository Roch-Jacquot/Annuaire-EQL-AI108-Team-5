package fr.eql.ai108.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestInputOutputStream {

	public static void main(String[] args) {

		File file = new File("c:/DossierAI108/testWrite.test");
		int[] tab = {12, 28, 58, 45, 37};
		
		//FileOutputStream permet d'écrire des octets dans un fichier
		
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			//On ecrit sous forme d'octets chacun de nos int dans le fichier
			for(int i : tab) {
				fos.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//FileInputStream permet de lire des octets sur un fichier
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int i = 0;
			//La methode read lit des octets et renvoie -1 quand il n'y a plus d'octets à lire
			while((i = fis.read()) != -1) {
				System.out.println(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
