package com.example.gpa_degpu.test;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Individu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	// déclaration d'une table d'association
	@JoinTable(name = "societe_individu",
			joinColumns = @JoinColumn(name = "individu_id"),
			inverseJoinColumns = @JoinColumn(name = "societe_id"))
	@JoinColumn(name = "societe_ID")
	private Societe societe;

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	// getters et setters omis ...
}
