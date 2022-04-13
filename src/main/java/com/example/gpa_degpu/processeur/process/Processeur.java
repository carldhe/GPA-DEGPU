package com.example.gpa_degpu.processeur.process;



import javax.persistence.*;
import java.util.List;

@Entity
public class Processeur {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idProcesseur;
	private String ref;
	private String fabricant;
	private String nom;
	private int stock;
	
	public Processeur() {
		super();
	}
	
	public Processeur(String ref,String fabricant,String nom) {
		super();
		this.ref= ref;
		this.fabricant= fabricant;
		this.nom= nom;
	}
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	
	public String getFabricant() {
		return fabricant;
	}
	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
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
		return idProcesseur;
	}
	public void setId(Long id) {
		this.idProcesseur = id;
	}
}

