package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		
		
		/*commande pour lancer la BDD, les fichiers de la BDD seront renommés firstBDD.
		 * java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:firstBDD --dbname.0 firstBDD
		 * 
		 * commande pour lancer le manager de la BDD ATTENTION il faut mettre un nom au manager sinon il n'aura aucun affichage
		 * java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
		 */
		
		//test1 git
		
	}
	
	

}
