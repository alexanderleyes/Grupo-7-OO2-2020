package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.EmpleadoModel;
import com.unla.Grupo7OO22020.services.IEmpleadoService;


@Controller
public class UserController {
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.login;
		
		
	}
	
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.logout;
	}
	
	@GetMapping("/loginsuccess")
	public ModelAndView loginCheck() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.login_ok);
		Object userDet =   SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();	
		System.out.println(username);
		mav.addObject("empleado", empleadoService.findByUsuario(username));			
		mav.addObject("user", userDet);		
		return mav ;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.login_ok);
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);		
		return mav ;
	}
	
		

}
