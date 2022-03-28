package com.example.gpa_degpu.utilisateurs.ressource;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.utilisateurs.process.Utilisateur;
import com.example.gpa_degpu.utilisateurs.process.UtilisateurRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Path("utilisateurs")
public class UtilisateurResource {
	@Autowired
	private UtilisateurRepository utilisateurRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur createUtilisateur(Utilisateur p) {
		return utilisateurRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json' -d '{"nom":"carl","mot_de_passe":"1234"}'

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> getAllUtilisateur() {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurRepository.findAll().forEach(utilisateurs::add);
		return utilisateurs;
	}
	
	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur updateTotalyUtilisateur(@PathParam("id") Long id, Utilisateur p) {
		p.setId(id);
		return utilisateurRepository.save(p);
	}
	
	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUtilisateur(@PathParam("id") Long id) {
		if (utilisateurRepository.findById(id).isPresent()) {
			utilisateurRepository.deleteById(id);
		}
		return Response.noContent().build();
	}
	
	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 
	

	

}
