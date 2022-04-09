package com.example.gpa_degpu.processeur.ressource;


import com.example.gpa_degpu.processeur.process.Processeur;
import com.example.gpa_degpu.processeur.process.ProcesseurRepository;
import com.example.gpa_degpu.ram.process.Ram;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("processeur")
public class ProcesseurRessource {
	@Autowired
	private ProcesseurRepository processeurRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Processeur createProcesseur(Processeur p) {
		return processeurRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/processeur -H 'Content-Type: application/json' -d '{"fabricant":"corsair","nom":"8GO-12","capacite":"8"}'

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Processeur> getAllProcesseur() {
		List<Processeur> processeurs = new ArrayList<>();
		processeurRepository.findAll().forEach(processeurs::add);
		return processeurs;
	}
	
	//curl -X GET http://localhost:8080/gpa_degpu/utilisateurs -H 'Content-Type: application/json'


	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Processeur updateTotalyProcesseur(@PathParam("id") Long id, Processeur p) {
		p.setId(id);
		return processeurRepository.save(p);
	}

	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'


	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProcesseur(@PathParam("id") Long id) {
		if (processeurRepository.findById(id).isPresent()) {
			processeurRepository.deleteById(id);
		}
		return Response.noContent().build();
	}
	
	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 
	

	

}
