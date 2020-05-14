package com.unla.Grupo7OO22020.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;

@Controller
@RequestMapping("vendedor")
public class VendedorController {
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	

	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	
	@GetMapping("/vendedor_idx")
	public ModelAndView vendedores(){
			System.out.println("enruta: " +ViewRouteHelper.vendedor_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.vendedor_idx);
			mav.addObject("vendedor", new Vendedor());
			mav.addObject("sucursal", new Sucursal());
			mav.addObject("vendedores", vendedorService.getAll());	
			mav.addObject("sucursales", sucursalService.getAll());	
			return mav;			
		}	
	
	@PostMapping("/agregar")	
	public String agregarVendedor(VendedorModel vendedorModel){
		System.out.println("emp add: ");	
		System.out.println("emp add: " + vendedorModel.getSucursalModel().getIdSucursal());		
	
		vendedorModel.setPassword(String.valueOf(vendedorModel.getDni()));
		vendedorModel.setUsuario(vendedorModel.getApellido());
		//vendedorModel = vendedorService.insertOrUpdate(vendedorModel);				
		return (ViewRouteHelper.vendedor_reload);
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPersona){		
		System.out.println("MOD vendedor: "  );		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.vendedor_insert);
		mav.addObject("sucursales", sucursalService.getAll());
		mav.addObject("vendedor", vendedorService.findByIdVendedor(idPersona));
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idVendedor){		
		System.out.println("ERASE vendedor: " );		
		vendedorService.remove(idVendedor);
		return ViewRouteHelper.vendedor_reload;
	}
}
