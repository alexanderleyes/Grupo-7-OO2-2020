package com.unla.Grupo7OO22020.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;



@Controller
@RequestMapping("/")
public class HomeController {		

	

	
	@GetMapping("/")
	public ModelAndView home(){
		return new ModelAndView(ViewRouteHelper.login);				
	}
	
			
	@GetMapping("/loginfail")
	public ModelAndView loginfail(){
		return new ModelAndView(ViewRouteHelper.login);			
	}
	
	@GetMapping("/home")
	public ModelAndView loginok(){
		return new ModelAndView(ViewRouteHelper.login_ok);			
	}	
	
	
}
