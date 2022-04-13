package com.example.gpa_degpu.utilisateurs.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idUtilisateur;
	private String nom;
	private String mot_de_passe;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String nom, String mot_de_passe) {
		super();
		this.nom = nom;
		this.mot_de_passe = mot_de_passe;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Long getId() {
		return idUtilisateur;
	}

	public void setId(Long id) {
		this.idUtilisateur = id;
	}

	
}
