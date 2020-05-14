package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.PersonaModel;
import com.unla.Grupo7OO22020.services.IPersonaService;

@Controller
@RequestMapping("persona")
public class PersonaController {	

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@PostMapping("/agregar")	
	public String agregar(PersonaModel personaModel){		
		System.out.println("ADD persona: " );		
		personaModel = personaService.insertOrUpdate(personaModel);			
		return ViewRouteHelper.personas_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPersona){		
		System.out.println("MOD persona: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.personas_insert);
		mav.addObject("persona",personaService.findByIdPersona(idPersona));
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idPersona){		
		System.out.println("ERASE persona: " );		
		personaService.remove(idPersona);
		return ViewRouteHelper.personas_reload;
	}
	
}
