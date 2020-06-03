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

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ItemModel;
import com.unla.Grupo7OO22020.services.IItemService;
import com.unla.Grupo7OO22020.services.IProductoService;


@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	@Qualifier("itemService")
	private IItemService itemService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
			
	@GetMapping("/item_idx")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.item_idx);
		mav.addObject("item", new Item());
		mav.addObject("items", itemService.getAll());
		mav.addObject("productos", productoService.getAll());
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
	}
		
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("item") ItemModel itemModel){		
		itemModel.setProducto(productoService.findByIdProducto(itemModel.getProducto().getIdProducto()));		
		itemModel = itemService.insertOrUpdate(itemModel);		
		return ViewRouteHelper.item_reload;
	}	
	
	
	 @PostMapping("/modificar/{id}")
	 public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.item_insert);
		mav.addObject("productos", productoService.getAll());
		mav.addObject("item", itemService.findById(id));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;	
	}

	@PostMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id) {
		itemService.remove(id);
		return ViewRouteHelper.item_reload;
	}
}
