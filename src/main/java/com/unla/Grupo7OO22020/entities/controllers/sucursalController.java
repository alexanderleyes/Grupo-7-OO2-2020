package com.unla.Grupo7OO22020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.ISucursalService;

public class sucursalController {

	@Controller
	@RequestMapping("/sucursal")
	public class SucursalController {

		@Autowired
		@Qualifier("sucursalService")
		private ISucursalService sucursalService;
		
		@Autowired
		@Qualifier("gerenteService")
		private IGerenteService gerenteService;
		
		@GetMapping("/")
		public ModelAndView index() {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.sucursal_idx);
			mAV.addObject("sucursales", sucursalService.getAll());
			mAV.addObject("sucursal", new SucursalModel());
			return mAV;
		}		
		
		@PostMapping("/agregar")
		public String agregarSucursal(SucursalModel sucursal) {
			
			//sucursalModel.setGerenteModel(gerenteService.findByIdGerente(1));
			
			sucursalService.insertOrUpdate(sucursal);
			
			return ViewRouteHelper.sucursal_reload;
		}
		
//		@PostMapping("/modificar/{id}")
//		public ModelAndView modificarSucursal(@PathVariable("id") long idSucursal) {
//			ModelAndView mav = new ModelAndView(ViewRouteHelper.sucursal_mod);
//			mav.addObject("sucursal", sucursalService.findByIdSucursal(idSucursal));
//			return mav;
//		}
//		
//		@PostMapping("/eliminar/{id}")
//		public String eliminarSucursal(@PathVariable("id") long idSucursal) {
//			sucursalService.remove(idSucursal);
//			return ViewRouteHelper.sucursal_reload;
//		}
		
//		@GetMapping("/view")
//		public String sucursal(Model model) {
//			model.addAttribute("sucursal", new SucursalModel());
//			return ViewRouteHelper.Sucursal_View;
//		}
		
				
		@GetMapping("/{id}")
		public ModelAndView get(@PathVariable("id") long id) {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.sucursal_mod);
			mAV.addObject("sucursal", sucursalService.findByIdSucursal(id));
			return mAV;
		}
		
//		@GetMapping("/by_gerente/{name}")
//		public ModelAndView getByGerente(@PathVariable("gerente") Gerente gerente) {
//			ModelAndView mAV = new ModelAndView(ViewRouteHelper.Sucursal);
//			mAV.addObject("sucursal", sucursalService.findByGerente(gerente));
//			return mAV;
//		}
		
		
		
		
	}


}
