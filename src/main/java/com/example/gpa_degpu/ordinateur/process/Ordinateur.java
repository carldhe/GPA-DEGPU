package com.example.gpa_degpu.ordinateur.process;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.example.gpa_degpu.*;
import com.example.gpa_degpu.alimentation.process.Alimentation;
import com.example.gpa_degpu.carte_graphique.process.Carte_Graphique;
import com.example.gpa_degpu.carte_mere.process.Carte_Mere;
import com.example.gpa_degpu.disque_dur.process.Disque_Dur;
import com.example.gpa_degpu.processeur.process.Processeur;
import com.example.gpa_degpu.ram.process.Ram;


@Entity
public class Ordinateur implements Serializable{
		
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
	    @JoinColumn(name = "idAlimentation", nullable=true)
		private Alimentation alimentation;
		
	    @OneToOne(cascade = CascadeType.ALL) 
	    @JoinColumn(name = "idCarte_Graphique", nullable=true)
		private Carte_Graphique carte_Graphique;
		
		
	    @OneToOne(cascade = CascadeType.ALL) 
	    @JoinColumn(name = "idCarte_Mere", nullable=true)
		private Carte_Mere carte_Mere;
		
	    @OneToOne(cascade = CascadeType.ALL) 
	    @JoinColumn(name = "idDisque_Dur", nullable=true)
		private Disque_Dur disque_Dur;
	    
	    @OneToOne(cascade = CascadeType.ALL) 
	    @JoinColumn(name = "idProcesseur", nullable=true)
		private Processeur processeur;
		
	    @OneToOne(cascade = CascadeType.ALL) 
	    @JoinColumn(name = "idRam", nullable=true)
		private Ram ram;
		
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
	
		public void setAlimentation(Alimentation alimentation) {
			this.alimentation = alimentation;
		}
		
		
		public Carte_Graphique getCarte_Graphique() {
			return carte_Graphique;
		}
	
		public void setCarte_Graphique(Carte_Graphique carte_Graphique) {
			this.carte_Graphique = carte_Graphique;
		}
		
		public Carte_Mere getCarte_Mere() {
			return carte_Mere;
		}
	
		public void setCarte_Mere(Carte_Mere carte_Mere) {
			this.carte_Mere = carte_Mere;
		}
		
		public Disque_Dur getDisque_Dur() {
			return disque_Dur;
		}
	
		public void setDisque_Dur(Disque_Dur disque_Dur) {
			this.disque_Dur = disque_Dur;
		}
		
		public Processeur getProcesseur() {
			return processeur;
		}
	
		public void setProcesseur(Processeur processeur) {
			this.processeur = processeur;
		}
		
		public Ram getRam() {
			return ram;
		}
	
		public void setRam(Ram ram) {
			this.ram = ram;
		}
}
