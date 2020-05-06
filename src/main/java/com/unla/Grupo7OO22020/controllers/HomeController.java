package com.unla.Grupo7OO22020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.services.ISucursalService;


@Controller
@RequestMapping("/")
public class HomeController {		
		
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@GetMapping("/")
	public ModelAndView home(){
		return new ModelAndView(ViewRouteHelper.login);				
	}
	
	
	@GetMapping("/loginfail")
	public ModelAndView loginfail(){
		return new ModelAndView(ViewRouteHelper.login);			
	}
	
	
	@GetMapping("/locales")
	public ModelAndView locales(){
		System.out.println("enruta: " +ViewRouteHelper.locales);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.locales);
			mav.addObject("sucursales", sucursalService.getAll());
			return mav;			
		}
}
