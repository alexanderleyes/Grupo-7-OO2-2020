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

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.LoteModel;
import com.unla.Grupo7OO22020.services.ILoteService;
import com.unla.Grupo7OO22020.services.IProductoService;


@Controller
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
			
	@GetMapping("/lote_idx")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.lote_idx);
		mav.addObject("lote", new Lote());
		mav.addObject("lotes", loteService.getAll());
		mav.addObject("productos", productoService.getAll());
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
	}
		
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("lote") LoteModel loteModel){		
		loteModel.setProducto(productoService.findByIdProducto(loteModel.getProducto().getIdProducto()));		
		loteModel = loteService.insertOrUpdate(loteModel);		
		return ViewRouteHelper.lote_reload;
	}	
	
	
	 @PostMapping("/modificar/{id}")
	 public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.lote_insert);
		mav.addObject("productos", productoService.getAll());
		mav.addObject("lote", loteService.findById(id));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;	
	}

	@PostMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id) {
		loteService.remove(id);
		return ViewRouteHelper.lote_reload;
	}
}
