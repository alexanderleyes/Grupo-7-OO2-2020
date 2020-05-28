package com.unla.Grupo7OO22020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.services.IProductoService;



@Controller
@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE')")
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/producto_idx")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_idx);
		mav.addObject("producto", new Producto());
		mav.addObject("productos", productoService.getAll());
		
		return mav;
	}
	
	
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idProducto){				
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", new Producto());
		mav.addObject("producto", productoService.findByIdProducto(idProducto));		
		return mav;
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("producto") ProductoModel productoModel) {
	productoModel = productoService.insertOrUpdate(productoModel);			
	return ViewRouteHelper.producto_reload;
	}

	 @GetMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", productoService.findByIdProducto(id));		
		return mav;		
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", productoService.findByIdProducto(id));		
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		productoService.eliminar(id);
		return ViewRouteHelper.producto_reload;
	}
	
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("producto") ProductoModel productoModel){		
		productoModel = productoService.insertOrUpdate(productoModel);			
		return ViewRouteHelper.producto_reload;
	}	
}