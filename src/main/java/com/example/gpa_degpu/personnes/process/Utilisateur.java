package com.example.gpa_degpu.personnes.process;


import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	private String password;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
