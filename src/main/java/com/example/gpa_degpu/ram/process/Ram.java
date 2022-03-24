package com.example.gpa_degpu.ram.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Ram  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String ref;
	private String fabricant;
	private String nom;
	private String capacite;
	private int stock;
	
	public Ram() {
		super();
	}
	
	public Ram(String ref,String fabricant,String nom, String capacite, int stock) {
		super();
		this.ref= ref;
		this.fabricant= fabricant;
		this.nom= nom;
		this.capacite= capacite;
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
	
	
	
	
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
