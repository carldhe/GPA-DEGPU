package com.example.gpa_degpu.carte_mere.ressource;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.carte_mere.process.Carte_mere;
import com.example.gpa_degpu.carte_mere.process.Carte_MereRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Path("carte_mere")
public class CarteMereRessource {
	@Autowired
	private Carte_MereRepository carte_mereRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carte_mere createCarte_mere(Carte_mere p) {
		return carte_mereRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/carte_mere -H 'Content-Type: application/json' -d '{"fabricant":"corsair","nom":"8GO-12","capacite":"8"}'



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carte_mere> getAllCarte_mere() {
		List<Carte_mere> carte_meres = new ArrayList<>();
		carte_mereRepository.findAll().forEach(carte_meres::add);
		return carte_meres;
	}

	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carte_mere updateStockCarte_mere(@PathParam("id") int stock, Carte_mere p) {
		p.setStock(stock);
		return carte_mereRepository.save(p);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carte_mere updateTotalyCarte_mere(@PathParam("id") Long id, Carte_mere p) {
		p.setId(id);
		return carte_mereRepository.save(p);
	}

	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUtilisateur(@PathParam("id") Long id) {
		if (carte_mereRepository.findById(id).isPresent()) {//Attention
			carte_mereRepository.deleteById(id);
		}
		return Response.noContent().build();
	}

	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 




}
