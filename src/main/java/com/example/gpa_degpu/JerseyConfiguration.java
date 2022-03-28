package com.example.gpa_degpu;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;

import com.example.gpa_degpu.utilisateurs.ressource.UtilisateurResource;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.stereotype.Component;


@Component
@ApplicationPath("gpa_degpu")
public class JerseyConfiguration extends ResourceConfig{
	public JerseyConfiguration( ) {
		
		register(UtilisateurResource.class);
		register(CORSResponseFilter.class);
	
	
			// La servlet de jersey map toutes les url /* donc impossible de servir du contenu statique via la servlet par défaut de sprign boot.
			// On doit donc dire à jersey de quand même laisser passer la requête pour que la prochaine servlet prenne le relais.
			// https://stackoverflow.com/questions/29658240/spring-boot-jersey-allow-jersey-to-serve-static-content/29670751#29670751
			property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
	
}

