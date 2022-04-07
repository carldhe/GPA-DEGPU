package com.example.gpa_degpu.carte_graphique.ressource;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.carte_graphique.process.Carte_graphique;
import com.example.gpa_degpu.carte_graphique.process.Carte_GraphiqueRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Path("carte_graphique")
public class CarteGraphiqueRessource {
	@Autowired
	private Carte_GraphiqueRepository carte_graphiqueRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carte_graphique createCarte_graphique(Carte_graphique p) {
		return carte_graphiqueRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/carte_graphique -H 'Content-Type: application/json' -d '{"fabricant":"corsair","nom":"8GO-12","capacite":"8"}'



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carte_graphique> getAllCarte_graphique() {
		List<Carte_graphique> carte_graphiques = new ArrayList<>();
		carte_graphiqueRepository.findAll().forEach(carte_graphiques::add);
		return carte_graphiques;
	}

	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carte_graphique updateStockCarte_graphique(@PathParam("id") int stock, Carte_graphique p) {
		p.setStock(stock);
		return carte_graphiqueRepository.save(p);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carte_graphique updateTotalyCarte_graphique(@PathParam("id") Long id, Carte_graphique p) {
		p.setId(id);
		return carte_graphiqueRepository.save(p);
	}

	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUtilisateur(@PathParam("id") Long id) {
		if (carte_graphiqueRepository.findById(id).isPresent()) {//Attention
			carte_graphiqueRepository.deleteById(id);
		}
		return Response.noContent().build();
	}

	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json'




}
