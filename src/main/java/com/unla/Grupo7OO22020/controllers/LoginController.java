package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.LoginModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.IVendedorService;


//@Controller
//@RequestMapping("user")
public class LoginController{	
	
	/*@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@PostMapping("/login")
	public ModelAndView login(LoginModel loginModel)	{		
		
		//Primero lo busca como gerente por que seguramente hay menos registros
		GerenteModel gerenteModel = gerenteService.findByUsuario(loginModel.getUsuario());//busqueda	
		ModelAndView mav = new ModelAndView();		
	
		if (gerenteModel!=null) { // si la busqueda no trajo dummy es por que encontro gerente con ese usuario
			if (gerenteModel.getPassword().equals(loginModel.getPassword())){	//comparo los passwords si no trajo dumy				
				mav.addObject("gerente" ,gerenteModel); //agrego la clase empleado para enviar	
				mav.addObject("user" , loginModel);
				mav.setViewName(ViewRouteHelper.login_ok);	//le seteo la ruta a donde voy
				System.out.println(loginModel.getUsuario() +" login Gerente"); // resultdo por consola
			}else {
				
				System.out.println("PassWord Incorrecto"); // si no coinciden los passwords muestro por consola
				mav.setViewName(ViewRouteHelper.login_fail);	// redirijo al login(hay que poner un mensaje en login.html)			
			}			
		}else{
			System.out.println(loginModel.getUsuario() +" no es gerente ");			
		}
		
		
		if (gerenteModel == null) { // si llego aca por ser dummy no era gerente pruebo con empleado
			
			//Busca Empleado si no sale por gerente
			VendedorModel vendedorModel = vendedorService.findByUsuario(loginModel.getUsuario());		
			
			if (vendedorModel != null)   {
				if (vendedorModel.getPassword().equals(loginModel.getPassword())){			
						
					mav.addObject("vendedor" ,vendedorModel); //agrego la clase empleado para enviar
					mav.addObject("user" , loginModel);
					mav.setViewName(ViewRouteHelper.login_ok);	//le seteo la ruta a donde voy
					System.out.println(loginModel.getUsuario() +" login Vendedor"); // resultdo por consola
				}else {
					System.out.println("PassWord Incorrecto");
					mav.setViewName(ViewRouteHelper.login_fail);				
				}			
			}else{
				System.out.println("Usuario no existe");
				mav.setViewName(ViewRouteHelper.login_fail);	
			}
		}
		
		return mav;
	}
	
	
	*/
	
		
}

