package com.unla.Grupo7OO22020.controllers;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.EmpleadoModel;
import com.unla.Grupo7OO22020.services.IEmpleadoService;

@Controller
@RequestMapping("empleado")
public class EmpleadoController {
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	
	@PostMapping("/agregar")	
	public String agregarEmpleado(EmpleadoModel empleadoModel){		
		System.out.println("emp add: " );						
		empleadoModel = empleadoService.insertOrUpdate(empleadoModel);				
		return ViewRouteHelper.empleado_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPersona){		
		System.out.println("MOD empleado: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.empleado_insert);
		mav.addObject("empleado", empleadoService.findByIdEmpleado(idPersona));
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idEmpleado){		
		System.out.println("ERASE empleado: " );		
		empleadoService.remove(idEmpleado);
		return ViewRouteHelper.empleado_reload;
	}
}
