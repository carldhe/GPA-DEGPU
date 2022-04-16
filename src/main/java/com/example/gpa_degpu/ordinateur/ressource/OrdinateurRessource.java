package com.example.gpa_degpu.ordinateur.ressource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.ordinateur.process.Ordinateur;
import com.example.gpa_degpu.ordinateur.process.OrdinateurRepository;


@Path("ordinateur")
public class OrdinateurRessource {
	@Autowired
	private OrdinateurRepository ordinateurRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ordinateur createOrdinateur(Ordinateur p) {
		
		return ordinateurRepository.save(p);
	}
	
	//curl -X POST http://localhost:8080/gpa_degpu/ordinateur -H 'Content-Type: application/json' -d '{"nom":"master","ref":"XXX","stock":8,"id":9,"alimentation":{},"carte_Graphique":{},"carte_Mere":{},"disque_Dur":{},"processeur":{},"ram":{}}'

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordinateur> getAllOrdinateur() {
		List<Ordinateur> ordinateurs = new ArrayList<>();
		ordinateurRepository.findAll().forEach(ordinateurs::add);
		
		
		return ordinateurs;
	}
	
	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'

	

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ordinateur updateTotalyOrdinateur(@PathParam("id") Long id, Ordinateur p) {
		p.setId(id);
		return ordinateurRepository.save(p);
	}

	//curl -X PUT http://localhost:8080/gpa_degpu/ordinateur/7 -H 'Content-Type: application/json' -d '{"ram":6}'


	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteOrdinateur(@PathParam("id") Long id) {
		if (ordinateurRepository.findById(id).isPresent()) {
			ordinateurRepository.deleteById(id);
		}
		return Response.noContent().build();
	}
	
	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 
	

	
}
