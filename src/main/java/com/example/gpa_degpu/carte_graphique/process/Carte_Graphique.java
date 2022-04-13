package com.example.gpa_degpu.carte_graphique.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Carte_Graphique  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idCarte_Graphique;
	private String ref;
	private String fabricant;
	private String nom;
	private int stock;

	public Carte_Graphique() {
		super();
	}

	public Carte_Graphique(String ref,String fabricant,String nom, String capacite) {
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
		return idCarte_Graphique;
	}

	public void setId(Long id) {
		this.idCarte_Graphique = id;
	}

}
