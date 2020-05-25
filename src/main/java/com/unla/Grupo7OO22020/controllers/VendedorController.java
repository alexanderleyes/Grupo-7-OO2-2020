package com.unla.Grupo7OO22020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.User;
import com.unla.Grupo7OO22020.entities.UserRole;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;
import com.unla.Grupo7OO22020.services.implementation.UserRoleService;
import com.unla.Grupo7OO22020.services.implementation.UserService;

@Controller
@RequestMapping("vendedor")
public class VendedorController {
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	

	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("userRoleService")
	private UserRoleService userRoleService;	
	
	
	@GetMapping("/vendedor_idx")
	public ModelAndView vendedores(){
			System.out.println("enruta: " +ViewRouteHelper.vendedor_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.vendedor_idx);
			mav.addObject("vendedor", new Vendedor());
			mav.addObject("sucursal", new Sucursal());
			mav.addObject("vendedores", vendedorService.getAll());	
			mav.addObject("sucursales", sucursalService.getAll());
			
			Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			mav.addObject("user", userDet);
			return mav;			
		}	
	
	@PostMapping("/agregar")	
	public String agregarVendedor(VendedorModel vendedorModel){
		System.out.println("emp add: ");	
	
		vendedorModel.setPassword(String.valueOf(vendedorModel.getDni()));
		vendedorModel.setUsuario(vendedorModel.getApellido());
		vendedorModel.setSucursal(sucursalService.findByIdSucursal(vendedorModel.getSucursal().getIdSucursal()));
		vendedorModel = vendedorService.insertOrUpdate(vendedorModel);		
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);		
        long id_empleado = vendedorModel.getIdPersona(); ///Obtengo el id del Vendedor para que coincida con el user le asigno el mismo id, sino genera otro distinto es mas dificil conectarlos.
		String username = vendedorModel.getApellido(); // Al crear un nuevo empleado el usuario por defecto es el apellido
        String passEcriptado = bCryptPasswordEncoder.encode(Integer.toString(vendedorModel.getDni()));   // Al crear un nuevo empleado el password por defecto es el dni
        User user = new User(id_empleado, username, passEcriptado, true);    
        UserRole role = new UserRole(user , "ROLE_VENDEDOR");       
        user = userService.save(user); 
        userRoleService.insertOrUpdate(role);        
        
		return (ViewRouteHelper.vendedor_reload);		
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPersona){		
		System.out.println("MOD vendedor: "  );		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.vendedor_insert);
		mav.addObject("sucursales", sucursalService.getAll());
		mav.addObject("vendedor", vendedorService.findByIdVendedor(idPersona));	
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
	}
	
	@PostMapping("/modificar_aplicar")	
	public String modificarVendedor(VendedorModel vendedorModel){ ////no modifica el Usuario y contraseña		System.out.println("emp add: ");		
	
		vendedorModel.setSucursal(sucursalService.findByIdSucursal(vendedorModel.getSucursal().getIdSucursal()));
		vendedorModel = vendedorService.insertOrUpdate(vendedorModel);		
		
		return (ViewRouteHelper.vendedor_reload);		
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idVendedor){		
		System.out.println("ERASE vendedor: " );		
		vendedorService.remove(idVendedor);
		return ViewRouteHelper.vendedor_reload;
	}
}
