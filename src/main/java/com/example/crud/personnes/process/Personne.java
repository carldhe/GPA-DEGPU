package com.example.crud.personnes.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Personne  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String prenom;
	private int age;
	
	public Personne() {
		super();
	}
	
	public Personne(String prenom, int age) {
		super();
		this.prenom = prenom;
		this.age = age;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
