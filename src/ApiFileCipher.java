
/*******************************************************************************************
 * Il vous faut créer une nouvelle classe ApiFileCipher qui permet de chiffrer et déchiffrer un 
 *    Chiffrer et Déchiffrer une phase de votre choix 
•     Chiffrer un fichier texte de votre choix et 
        sauvegarder le résultat dans un fichier
•      L’affichage du déchiffrement du fichier.cryp se fera à 
      l’écran dans la console
 * @author Jeremie Plaiche
 * @version 2.0
 * Date: 12/012/2021
 *******************************************************************************************/



package blowfish;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.Key;
import java.security.PrivateKey;
import java.util.Scanner;





public class ApiFileCipher {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Key cleBlowfish = ApiBlowfish.generateKey();
		
		// System.out.println(cleBlowfish); //
		
		 System.out.println("\n Veuillez entrer une phrase: ");
		
		   Scanner saisir = new Scanner(System.in);
		   
		   String phrase = saisir.nextLine();
		  
		   System.out.println("\n Veuillez entrer une phrase: ");
		   
		   

			 System.out.println(" ******* Chiffrement en cours ******* ");
			 System.out.println(" ******* Chiffrement terminé ******* ");
		
	String chiffre = ApiBlowfish.encryptInString(phrase, cleBlowfish);    // Chiffre la phrase qui etait entrer par l'utilisateur
		
	 System.out.println(chiffre);
	 
	 
	 System.out.println("\n ******* Dechiffrement en cours ******* ");
	 System.out.println(" ******* Dechiffrement terminé ******* ");
	 
	 String dechiffre = ApiBlowfish.decryptInString(chiffre, cleBlowfish); // Dechiffre la phrase qui etait entrer par l'utilisateur
		
	 System.out.println(dechiffre); 
	 
	 
	 System.out.println(" ******* Chiffrement du fichier en cours ******* ");
	 System.out.println(" ******* Chiffrement terminé ******* ");
	 System.out.println(" ******* Veuillez consulter le fichier pour voir le chiffrement ******* ");
	 
	 
	 
	 String encrypt = textChiffre("C:\\Users\\Jeremie\\Documents\\toto.txt", cleBlowfish);    // Chiffre le fichier
	//	System.out.println(encrypt);
		
	    
           File newTextFile = new File("C:\\Users\\Jeremie\\Documents\\encrypt.txt");

           FileWriter fw = new FileWriter(newTextFile);
           fw.write(encrypt);
             fw.close();
             
             
        	 System.out.println("\n ******* Dechiffrement du fichier en cours ******* ");
        	 System.out.println(" ******* Dechiffrement terminé ******* ");
        	 System.out.println(" ******* Affichage du dechiffrement  ******* ");
        	 
             
             String decrypt = textDechiffre("C:\\Users\\Jeremie\\Documents\\encrypt.txt", cleBlowfish);  // Dechiffre le fichier 
             System.out.println(decrypt);
             
             
             
             
	 
	// byte[] fichier = ("C:\\Users\\Jeremie\\Documents\\toto.txt");
			 
			 
   //	String chiffrerFichier = ApiBlowfish.encryptInByte(fichier,cleBlowfish); 
	
	
	 
	 
	 
	}
	 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 

	String nomDuFichier = ("C:\\Users\\Jeremie\\Documents\\toto.txt");
	
	
	static String textChiffre(String nomDuFichier, Key cleBlowfish ) throws Exception{
		
		try {
			RandomAccessFile fichier = new RandomAccessFile(nomDuFichier, "r");  // en mode read
			byte[] data = new byte[(int)fichier.length()];
			fichier.readFully(data);
			
			String chaine = new String(data);  // conversion de la  data en string
			
			// System.out.printf("\n%s\n", chaine);
			
			fichier.close();
			return ApiBlowfish.encryptInString(chaine, cleBlowfish); // chiffrement du fichier en utilisant la fonction encryptInString de l'ApiBlowfish
			
			

        

		}
		
		   
		
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		return null;
		
		
	}
	 
		static String textDechiffre(String newTextFile, Key cleBlowfish ) throws Exception{
			
			try {
				RandomAccessFile fichier = new RandomAccessFile(newTextFile, "r");  // en mode read
				byte[] data = new byte[(int)fichier.length()];
				fichier.readFully(data);
				
				String chaine = new String(data);  // conversion de la  data en string
				
				// System.out.printf("\n%s\n", chaine);
				
				fichier.close();
				return ApiBlowfish.decryptInString(chaine, cleBlowfish); // dechiffrement du fichier en utilisant la fonction encryptInString de l'ApiBlowfish
				
				

	        

			}
			
			   
			
			catch (FileNotFoundException e) {}
			catch (IOException e) {}
			return null;
		 
		
			 
	       
       
	
		
				
	}

}

	


