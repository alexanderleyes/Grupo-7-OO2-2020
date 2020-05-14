package com.unla.Grupo7OO22020.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Cliente;
import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.services.IGerenteService;

@Controller
@RequestMapping("gerente")
public class GerenteController {
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	
	@GetMapping("/gerente_idx")
	public ModelAndView gerentes(){
			System.out.println("enruta: " +ViewRouteHelper.gerente_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.gerente_idx);
			mav.addObject("gerente", new Gerente());
			mav.addObject("gerentes", gerenteService.getAll());			
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregarGerente(GerenteModel gerenteModel){	
		
		System.out.println("emp add: " );
		gerenteModel.setPassword(String.valueOf(gerenteModel.getDni()));
		gerenteModel.setUsuario(gerenteModel.getApellido());
		gerenteModel = gerenteService.insertOrUpdate(gerenteModel);				
		return ViewRouteHelper.gerente_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPersona){		
		System.out.println("MOD gerente: "  );		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.gerente_insert);		
		mav.addObject("gerente", gerenteService.findByIdGerente(idPersona));
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idGerente){		
		System.out.println("ERASE gerente: " );		
		gerenteService.remove(idGerente);
		return ViewRouteHelper.gerente_reload;
	}
}
