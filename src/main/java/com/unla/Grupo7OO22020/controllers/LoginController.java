package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.EmpleadoModel;
import com.unla.Grupo7OO22020.models.LoginModel;
import com.unla.Grupo7OO22020.repositories.IEmpleadoRepository;
import com.unla.Grupo7OO22020.services.IEmpleadoService;


@Controller
@RequestMapping("user")
public class LoginController{	
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@PostMapping("/login")
	public String login(LoginModel loginModel)	{
		System.out.println("Usuario: " + loginModel.getUsuario());	
		
		EmpleadoModel empleadoModel = null;
		empleadoModel = empleadoService.findByUsuario(loginModel.getUsuario());
			
		if (empleadoModel.getUsuario()!="dummy") {
			if (empleadoModel.getPassword().equals(loginModel.getPassword())){
				
				System.out.println("Login OK");
				return (ViewRouteHelper.home);	
			}else {
				System.out.println("PassWord Incorrecto");
				return (ViewRouteHelper.login);	
			}			
		}else {
			System.out.println("Usuario no existe");
			return (ViewRouteHelper.login);		
		}		
	}
	
	
		
}

