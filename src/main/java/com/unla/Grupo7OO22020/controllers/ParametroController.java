package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Parametro;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;
import com.unla.Grupo7OO22020.models.ParametroModel;
import com.unla.Grupo7OO22020.services.IParametroService;

@Controller
@RequestMapping("parametro")
public class ParametroController {	

	@Autowired
	@Qualifier("parametroService")
	private IParametroService parametroService;
	
	
	@GetMapping("/parametro_idx")
	public ModelAndView parametros(){
			System.out.println("enruta: " +ViewRouteHelper.parametro_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.parametro_idx);
			mav.addObject("parametro", new Parametro());
			mav.addObject("parametros", parametroService.getAll());			
			return mav;			
		}
	
	
	@PostMapping("/agregar")	
	public String agregarEstadoVenta(ParametroModel parametroModel){		
		System.out.println("parametro mod: " );						
		parametroModel = parametroService.insertOrUpdate(parametroModel);				
		return ViewRouteHelper.parametro_reload;
	}
	
	
	
}
