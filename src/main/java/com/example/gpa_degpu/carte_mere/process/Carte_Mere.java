package com.example.gpa_degpu.carte_mere.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Carte_Mere  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idCarte_Mere;
	private String ref;
	private String fabricant;
	private String nom;
	private int stock;

	public Carte_Mere() {
		super();
	}

	public Carte_Mere(String ref,String fabricant,String nom, String capacite) {
		super();
		this.ref = ref;
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
		return idCarte_Mere;
	}

	public void setId(Long id) {
		this.idCarte_Mere = id;
	}

}
