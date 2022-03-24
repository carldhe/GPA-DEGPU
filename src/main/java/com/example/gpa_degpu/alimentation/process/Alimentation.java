package com.example.gpa_degpu.alimentation.process;



import javax.persistence.*;
import java.util.List;

@Entity
public class Alimentation{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String ref;
	private String fabricant;
	private String nom;
	private String puissance;
	private int stock;
	
	public Alimentation() {
		super();
	}
	
	public Alimentation(String ref,String fabricant,String nom, String capacite, int stock) {
		super();
		this.ref= ref;
		this.fabricant= fabricant;
		this.nom= nom;
		this.puissance= capacite;
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
	
	
	
	
	public String getPuissance() {
		return puissance;
	}
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}

	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
