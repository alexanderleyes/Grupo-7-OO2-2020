package com.unla.Grupo7OO22020.controllers;

import java.util.List;

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

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ClienteModel;
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
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.lote_idx);
		mAV.addObject("lotes", loteService.getAll());
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_NEW);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}
	
	@GetMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		loteService.insertOrUpdate(loteModel);
		return new RedirectView(ViewRouteHelper.lote_reload);
	}
	
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("lote") LoteModel loteModel){	
		
		loteModel = loteService.insertOrUpdate(loteModel);
		
		return ViewRouteHelper.lote_reload;
	}
	
	 @GetMapping("/update/{id}")
		public ModelAndView update1(@PathVariable("id") int id) {
			ModelAndView mav = new ModelAndView(ViewRouteHelper.LOTE_UPDATE);
			mav.addObject("lote", new Producto());
			mav.addObject("lote", loteService.findById(id));
			return mav;
			
		}
	
	 @GetMapping("/modificar/{id}")
		public ModelAndView update(@PathVariable("id") int id) {
			ModelAndView mav = new ModelAndView(ViewRouteHelper.lote_insert);
			mav.addObject("lote", new Producto());
			mav.addObject("lote", loteService.findById(id));
			return mav;
			
		}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.lote_reload);
	
		mAV.addObject("lote", loteService.findById(id));
		mAV.addObject("producto", productoService.findById(loteService.findById(id).getIdProducto()));
		mAV.addObject("productos", productoService.getAll());
		
		return mAV;
	}
			
	
	
	 

	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		loteService.remove(id);
		return new RedirectView(ViewRouteHelper.lote_reload);
	}
}
