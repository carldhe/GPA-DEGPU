package com.example.crud;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.example.crud.personnes.ressource.PersonneResource;


@Component
@ApplicationPath("crud")
public class JerseyConfiguration extends ResourceConfig{
	public JerseyConfiguration( ) {
		
		register(PersonneResource.class);
	
	
			// La servlet de jersey map toutes les url /* donc impossible de servir du contenu statique via la servlet par défaut de sprign boot.
			// On doit donc dire à jersey de quand même laisser passer la requête pour que la prochaine servlet prenne le relais.
			// https://stackoverflow.com/questions/29658240/spring-boot-jersey-allow-jersey-to-serve-static-content/29670751#29670751
			property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
	
}

