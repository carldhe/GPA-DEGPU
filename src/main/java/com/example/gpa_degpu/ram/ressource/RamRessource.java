package com.example.gpa_degpu.ram.ressource;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.gpa_degpu.ram.process.Ram;
import com.example.gpa_degpu.ram.process.RamRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Path("ram")
public class RamRessource {
	@Autowired
	private RamRepository ramRepository;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ram createRam(Ram p) {
		return ramRepository.save(p);
	}
	//curl -X POST http://localhost:8080/gpa_degpu/ram -H 'Content-Type: application/json' -d '{"fabricant":"corsair","nom":"8GO-12","capacite":"8","ref":"XB8D3D","stock":14}'

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ram> getAllRam() {
		List<Ram> rams = new ArrayList<>();
		ramRepository.findAll().forEach(rams::add);
		return rams;
	}


	/*
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ram updateRam(@PathParam("id") int stock, Ram p) {
		p.setStock(stock);
		return ramRepository.save(p);
	}
	*/

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ram updateTotalyRam(@PathParam("id") Long id, Ram p) {
		p.setId(id);
		return ramRepository.save(p);
	}
	
	//curl -X PUT http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' -d '{"name":"belzebuth","password":"jetevois"}'

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRam(@PathParam("id") Long id) {
		if (ramRepository.findById(id).isPresent()) {//Attention
			ramRepository.deleteById(id);
		}
		return Response.noContent().build();
	}
	
	//curl -X DELETE http://localhost:8080/gpa_degpu/utilisateurs/1 -H 'Content-Type: application/json' 
	

	

}
