package com.example.gpa_degpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LaunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaunchApplication.class, args);
		
		
		/*commande pour lancer la BDD, les fichiers de la BDD seront renommés firstBDD.
		 * java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:stock_BDD --dbname.0 stock_BDD
		 * 
		 * commande pour lancer le manager de la BDD ATTENTION il faut mettre un nom au manager sinon il n'aura aucun affichage
		 * java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
		 *
		 * nom de la BDD : stock_BDD
		 * url BDD : jdbc:hsqldb:hsql://localhost/stock_BDD
		 */
		
		//test1 git
		
	}
	
	

}
