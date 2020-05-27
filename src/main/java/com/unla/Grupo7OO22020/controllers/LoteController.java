package com.unla.Grupo7OO22020.controllers;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.LoteModel;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.ILoteService;
import com.unla.Grupo7OO22020.services.IProductoService;
import com.unla.Grupo7OO22020.services.ISucursalService;


@Controller
@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE')")
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	

	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
			
	@GetMapping("/lote_idx")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.lote_idx);
		mav.addObject("lote", new Lote());		
		mav.addObject("productos", productoService.getAll());		
		
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();		
		String roleString = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();		
		
		switch(roleString) { 				  
		   case "[ROLE_ADMIN]":				      
			   mav.addObject("sucursales", sucursalService.getAll());
			   mav.addObject("lotes", loteService.getAll());
			   break;
		   case "[ROLE_VENDEDOR]" :
			   System.out.println("Un vendedor no da alta lotes");			  
			   break;
		   case "[ROLE_GERENTE]" :					       
			   System.out.println("cosas de gerente lote");
			   GerenteModel gerenteModel = gerenteService.findByUsuario(username);
			   SucursalModel sucursalModel =  sucursalService.findByGerente(gerenteModel);			   
			   Set<LoteModel> lotes = loteService.findAllBySucursal(sucursalModel);
			   mav.addObject("lotes", lotes);	
			   
			   Set<SucursalModel> sucursales = new HashSet<SucursalModel>();
			   sucursales.add(sucursalModel);		
			   mav.addObject("sucursales", sucursales);	
			   break;
		   default : 		
		}
			
		return mav;
	}
		
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("lote") LoteModel loteModel){		
		loteModel.setProducto(productoService.findByIdProducto(loteModel.getProducto().getIdProducto()));
		loteModel.setSucursal(sucursalService.findByIdSucursal(loteModel.getSucursal().getIdSucursal()));
		loteModel = loteService.insertOrUpdate(loteModel);		
		return ViewRouteHelper.lote_reload;
	}	
	
	
	 @PostMapping("/modificar/{id}")
	 public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.lote_insert);
		mav.addObject("lote", loteService.findById(id));	
		mav.addObject("productos", productoService.getAll());		
		
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();		
		String roleString = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();		
		
		switch(roleString) { 				  
		   case "[ROLE_ADMIN]":				      
			   mav.addObject("sucursales", sucursalService.getAll());
			   mav.addObject("lotes", loteService.getAll());
			   break;
		   case "[ROLE_VENDEDOR]" :
			   System.out.println("Un vendedor no da alta lotes");			  
			   break;
		   case "[ROLE_GERENTE]" :					       
			   System.out.println("cosas de gerente lote");
			   GerenteModel gerenteModel = gerenteService.findByUsuario(username);
			   SucursalModel sucursalModel =  sucursalService.findByGerente(gerenteModel);			   
			   Set<LoteModel> lotes = loteService.findAllBySucursal(sucursalModel);
			   mav.addObject("lotes", lotes);	
			   
			   Set<SucursalModel> sucursales = new HashSet<SucursalModel>();
			   sucursales.add(sucursalModel);		
			   mav.addObject("sucursales", sucursales);	
			   break;
		   default : 		
		}		
		
		return mav;	
	}

	@PostMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id) {
		loteService.remove(id);
		return ViewRouteHelper.lote_reload;
	}
	
	
	
}
