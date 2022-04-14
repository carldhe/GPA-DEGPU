package com.example.gpa_degpu.alimentation.ressource;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.alimentation.process.Alimentation;
import com.example.gpa_degpu.alimentation.process.AlimentationRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Path("alimentation")
public class AlimentationRessource {
	@Autowired
	private AlimentationRepository alimentationRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Alimentation createAlimentation(Alimentation p) {
		return alimentationRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/alimentation -H 'Content-Type: application/json' -d '{"ref":"XDE","fabricant":"XXX","nom":"XXX","capacite":"5","stock":8}'
	



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alimentation> getAllAlimentation() {
		List<Alimentation> alimentations = new ArrayList<>();
		alimentationRepository.findAll().forEach(alimentations::add);
		return alimentations;
	}

	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'


	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Alimentation updateTotalyAlimentation(@PathParam("id") Long id, Alimentation p) {
		p.setId(id);
		return alimentationRepository.save(p);
	}

	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'


	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAlimentation(@PathParam("id") Long id) {
		if (alimentationRepository.findById(id).isPresent()) {//Attention
			alimentationRepository.deleteById(id);
		}
		return Response.noContent().build();
	}

	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 




}
