package com.example.gpa_degpu.carte_mere.process;



import javax.persistence.*;
import java.util.List;

@Entity
public class Carte_mere  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String ref;
	private String fabricant;
	private String nom;
	private int stock;
	
	public Carte_mere() {
		super();
	}
	
	public Carte_mere(String ref,String fabricant,String nom, int stock) {
		super();
		this.ref= ref;
		this.fabricant= fabricant;
		this.nom= nom;
		this.stock = stock;
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
	
}

