package com.unla.Grupo7OO22020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.services.IEmpleadoService;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.IPersonaService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;


@Controller
@RequestMapping("/")
public class HomeController {		
		
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
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
	
	
	@GetMapping("/locales")
	public ModelAndView locales(){
			System.out.println("enruta: " +ViewRouteHelper.locales);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.locales);
			mav.addObject("sucursales", sucursalService.getAll());
			return mav;			
		}
	
	@GetMapping("/empleado_idx")
	public ModelAndView empleados(){
			System.out.println("enruta: " +ViewRouteHelper.empleado_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.empleado_idx);
			mav.addObject("empleados", empleadoService.getAll());			
			return mav;			
		}
	
	@GetMapping("/gerente_idx")
	public ModelAndView gerentes(){
			System.out.println("enruta: " +ViewRouteHelper.gerente_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.gerente_idx);
			mav.addObject("gerentes", gerenteService.getAll());			
			return mav;			
		}
	
	@GetMapping("/vendedor_idx")
	public ModelAndView vendedores(){
			System.out.println("enruta: " +ViewRouteHelper.vendedor_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.vendedor_idx);
			mav.addObject("vendedores", vendedorService.getAll());			
			return mav;			
		}
	
	
	@GetMapping("/persona_idx")
	public ModelAndView clientes(){
			System.out.println("enruta: " +ViewRouteHelper.persona_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.persona_idx);			
			mav.addObject("personas", personaService.getAll());		
			return mav;			
		}
}
