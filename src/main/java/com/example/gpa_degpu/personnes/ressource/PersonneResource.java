package com.example.gpa_degpu.personnes.ressource;


import com.example.gpa_degpu.personnes.process.Personne;
import com.example.gpa_degpu.personnes.process.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Path("personnes")
public class PersonneResource {
	@Autowired
	private PersonneRepository personneRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Personne createPersonne(Personne p) {
		return personneRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/personnes -H 'Content-Type: application/json' -d '{"prenom":"carl","age":22}'

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personne> getAllPersonne() {
		List<Personne> personnes = new ArrayList<>();
		personneRepository.findAll().forEach(personnes::add);
		return personnes;
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Personne updateTotalyPersonne(@PathParam("id") Long id, Personne p) {
		p.setId(id);
		return personneRepository.save(p);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePersonne(@PathParam("id") Long id) {
		if (personneRepository.findById(id).isPresent()) {
			personneRepository.deleteById(id);
		}
		return Response.noContent().build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getpersonneById(@PathParam("id") Long id) {
		Optional<Personne> p = personneRepository.findById(id);
		if (p.isPresent()) {
			return Response.ok(p.get()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	// PATCH /personnes/{id}
	public Response updateAge(@PathParam("id") Long id, Personne p) {
		int age = p.getAge();
		Optional<Personne> optional = personneRepository.findById(id);

		if (optional.isPresent()) {
			Personne pBDD = optional.get();
			pBDD.setAge(age);
			personneRepository.save(pBDD);
			return Response.ok(pBDD).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
