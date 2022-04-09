package com.example.gpa_degpu.disque_dur.ressource;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.disque_dur.process.Disque_Dur;
import com.example.gpa_degpu.disque_dur.process.Disque_DurRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Path("disque_dur")
public class DisqueDurRessource {
	@Autowired
	private Disque_DurRepository disque_durRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Disque_Dur createDisque_Dur(Disque_Dur p) {
		return disque_durRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/disque_dur -H 'Content-Type: application/json' -d '{"fabricant":"corsair","nom":"8GO-12","capacite":"8"}'



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disque_Dur> getAllDisque_Dur() {
		List<Disque_Dur> disque_durs = new ArrayList<>();
		disque_durRepository.findAll().forEach(disque_durs::add);
		return disque_durs;
	}

	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'


	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Disque_Dur updateTotalyDisque_Dur(@PathParam("id") Long id, Disque_Dur p) {
		p.setId(id);
		return disque_durRepository.save(p);
	}

	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'


	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDisqueDur(@PathParam("id") Long id) {
		if (disque_durRepository.findById(id).isPresent()) {//Attention
			disque_durRepository.deleteById(id);
		}
		return Response.noContent().build();
	}

	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 




}
