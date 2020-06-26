package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.EstadoVenta;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;
import com.unla.Grupo7OO22020.services.IEstadoVentaService;

@Controller
@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE')")
@RequestMapping("estadoVenta")
public class EstadoVentaController {
	
	@Autowired
	@Qualifier("estadoVentaService")
	private IEstadoVentaService estadoVentaService;
	
	
	@GetMapping("/estadoVenta_idx")
	public ModelAndView estadoVentas(){
			System.out.println("enruta: " +ViewRouteHelper.estadoVenta_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.estadoVenta_idx);	
			mav.addObject("estadoVenta", new EstadoVenta());
			mav.addObject("estados", estadoVentaService.getAll());
			
			
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregarEstadoVenta(EstadoVentaModel estadoVentaModel){		
		System.out.println("estado add: " );						
		estadoVentaModel = estadoVentaService.insertOrUpdate(estadoVentaModel);				
		return ViewRouteHelper.estadoVenta_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long id){		
		System.out.println("MOD estadoVenta: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.estadoVenta_insert);
		mav.addObject("estadoVenta", estadoVentaService.findByIdEstadoVenta(id));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idEstadoVenta){		
		System.out.println("ERASE sucursal: " );		
		estadoVentaService.remove(idEstadoVenta);
		return ViewRouteHelper.estadoVenta_reload;
	}

}
