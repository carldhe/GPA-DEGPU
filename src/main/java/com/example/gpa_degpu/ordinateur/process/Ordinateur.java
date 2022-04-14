package com.example.gpa_degpu.ordinateur.process;
import java.util.List;

import javax.persistence.*;

import com.example.gpa_degpu.*;
import com.example.gpa_degpu.alimentation.process.Alimentation;


@Entity
public class Ordinateur {
		
		//clef primaire voir annotation juste en dessous
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long idOrdinateur;
	    private String nom;
	    private String ref;
	    private int stock;
	    
	    //https://koor.fr/Java/TutorialJEE/jee_jpa_one_to_one.wp
	    //attention garder false pour empêcher l'ajout d'un ordinateur sans idAlimentation et true pour le permettre 
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name ="idAlimentation", nullable=true)
		private Alimentation alimentation;
		
		
		
		
		
		
		
		
		
	    public String getRef() {
			return ref;
		}

		public void setRef(String ref) {
			this.ref = ref;
		}

	
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		

		
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}

		public Long getId() {
			return idOrdinateur;
		}
		public void setId(Long id) {
			this.idOrdinateur = id;
		}
		
		public Alimentation getAlimentation() {
			return alimentation;
		}
	

}
