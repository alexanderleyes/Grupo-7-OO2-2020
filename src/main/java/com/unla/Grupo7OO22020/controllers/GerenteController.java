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

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.User;
import com.unla.Grupo7OO22020.entities.UserRole;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.implementation.UserRoleService;
import com.unla.Grupo7OO22020.services.implementation.UserService;

@Controller
@RequestMapping("gerente")
public class GerenteController {
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("userRoleService")
	private UserRoleService userRoleService;
	
	@GetMapping("/gerente_idx")
	public ModelAndView gerentes(){
			System.out.println("enruta: " +ViewRouteHelper.gerente_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.gerente_idx);
			mav.addObject("gerente", new Gerente());
			mav.addObject("gerentes", gerenteService.getAll());
			
			Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			mav.addObject("user", userDet);
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregarGerente(GerenteModel gerenteModel){	
		
		System.out.println("emp add: " );
		gerenteModel.setPassword(String.valueOf(gerenteModel.getDni()));
		gerenteModel.setUsuario(gerenteModel.getApellido());
		gerenteModel = gerenteService.insertOrUpdate(gerenteModel);
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);   //Instancia para necriptar password 
        long id_empleado = gerenteModel.getIdPersona(); ///Obtengo el id del Vendedor para que coincida con el user le asigno el mismo id, sino genera otro distinto es mas dificil conectarlos.
		String username = gerenteModel.getApellido(); // Al crear un nuevo empleado el usuario por defecto es el apellido
        String passEcriptado = bCryptPasswordEncoder.encode(Integer.toString(gerenteModel.getDni()));   // Al crear un nuevo empleado el password por defecto es el dni
        User user = new User(id_empleado, username, passEcriptado, true);       //creo un usuario        
        UserRole role = new UserRole(user , "GERENTE");       //creo un rol      
        user = userService.save(user); // guardo usuario
        userRoleService.insertOrUpdate(role);        //guardo el rol luego del usario por que necesita que le usuario este een la BD para que sea coherente la relacion		
		
		return ViewRouteHelper.gerente_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPersona){		
		System.out.println("MOD gerente: "  );		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.gerente_insert);		
		mav.addObject("gerente", gerenteService.findByIdGerente(idPersona));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;	
		
	}
	
	
	@PostMapping("/modificar_aplicar")	
	public String modificarGerente(GerenteModel gerenteModel){ ////no modifica el Usuario y contraseña
		System.out.println("ger add: ");
		
		gerenteModel = gerenteService.insertOrUpdate(gerenteModel);			
		return (ViewRouteHelper.gerente_reload);		
	}
	
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idGerente){		
		System.out.println("ERASE gerente: " );		
		gerenteService.remove(idGerente);
		return ViewRouteHelper.gerente_reload;
	}
}
