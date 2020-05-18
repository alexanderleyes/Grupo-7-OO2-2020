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

import com.unla.Grupo7OO22020.entities.Cliente;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ClienteModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.services.IProductoService;



@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/producto_idx")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.producto_idx);
		mAV.addObject("producto", new Producto());
		mAV.addObject("productos", productoService.getAll());
		
		return mAV;
	}
	
	
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idProducto){		
				
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", new Producto());
		mav.addObject("producto", productoService.findById(idProducto));
		return mav;
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("producto") ProductoModel productoModel) {
	productoModel = productoService.insertOrUpdate(productoModel);			
	return ViewRouteHelper.producto_reload;
	}
	
	 @GetMapping("/update/{id}")
		public ModelAndView update(@PathVariable("id") int id) {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.producto_insert);
			mAV.addObject("producto", productoService.findById(id));
			return mAV;
			
		}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.producto_insert);
		mAV.addObject("producto", productoService.findById(id));
		return mAV;
	}
	
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		productoService.remove(id);
		return ViewRouteHelper.producto_reload;
	}
	
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("producto") ProductoModel productoModel){		
		productoModel = productoService.insertOrUpdate(productoModel);			
		return ViewRouteHelper.producto_reload;
	}
	
	/*
	
	@GetMapping("/by_name/{name}")
	public ModelAndView getByName(@PathVariable("name") String name) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_UPDATE);
		mAV.addObject("producto", productoService.findByDescripcion(name));
		return mAV;
	}*/
	
	
}