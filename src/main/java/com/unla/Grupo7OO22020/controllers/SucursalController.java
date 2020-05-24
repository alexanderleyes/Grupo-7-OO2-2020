package com.unla.Grupo7OO22020.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.services.ISucursalService;

@Controller
@RequestMapping("sucursal")
public class SucursalController {
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	
	@GetMapping("/sucursal_idx")
	public ModelAndView sucursales(){
		System.out.println("enruta: " +ViewRouteHelper.sucursal_idx);
		ModelAndView mav = new ModelAndView(ViewRouteHelper.sucursal_idx);	
		mav.addObject("sucursal", new Sucursal());
		mav.addObject("sucursales", sucursalService.getAll());	
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;			
	}
	
	@PostMapping("/agregar")	
	public String agregarSucursal(SucursalModel sucursalModel){		
		System.out.println("emp add: " );						
		sucursalModel = sucursalService.insertOrUpdate(sucursalModel);				
		return ViewRouteHelper.sucursal_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long id){		
		System.out.println("MOD sucursal: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.sucursal_insert);
		mav.addObject("sucursal", sucursalService.findByIdSucursal(id));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idSucursal){		
		System.out.println("ERASE sucursal: " );		
		sucursalService.remove(idSucursal);
		return ViewRouteHelper.sucursal_reload;
	}	

	
	@GetMapping("/cercana/{id}")
	public ModelAndView cercanas(@PathVariable("id") long id) {
		System.out.println("cerc sucursal: " + id);
		ModelAndView mav = new ModelAndView(ViewRouteHelper.cercana_view);
		SucursalModel sucursal = sucursalService.findByIdSucursal(id);
		mav.addObject("sucursal", new Sucursal());
		mav.addObject(sucursalService.distancias(sucursal));
		mav.addObject("sucursales", sucursalService.distancias(sucursal));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
		
	}
}
