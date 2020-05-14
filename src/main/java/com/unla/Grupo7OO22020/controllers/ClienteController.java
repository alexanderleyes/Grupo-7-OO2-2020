package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Cliente;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ClienteModel;
import com.unla.Grupo7OO22020.services.IClienteService;

@Controller
@RequestMapping("cliente")
public class ClienteController {	

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@GetMapping("/cliente_idx")
	public ModelAndView clientes(){
			System.out.println("enruta: " +ViewRouteHelper.cliente_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.cliente_idx);
			mav.addObject("cliente", new Cliente());
			mav.addObject("clientes", clienteService.getAll());		
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("cliente") ClienteModel clienteModel){		
		System.out.println("ADD cliente: " );	
		System.out.println("date: "+ clienteModel.getFechaNacimiento() );
		clienteModel = clienteService.insertOrUpdate(clienteModel);			
		return ViewRouteHelper.clientes_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idCliente){		
		System.out.println("MOD cliente: "  );		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.cliente_insert);
		mav.addObject("cliente", new Cliente());
		mav.addObject("cliente", clienteService.findByIdCliente(idCliente));
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idCliente){		
		System.out.println("ERASE cliente: " );		
		clienteService.remove(idCliente);
		return ViewRouteHelper.clientes_reload;
	}
	
}
