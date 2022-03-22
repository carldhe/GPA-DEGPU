package com.example.gpa_degpu.utilisateurs.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
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
	
	public String getName() {
		return nom;
	}
	public void setName(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return mot_de_passe;
	}
	public void setPassword(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
