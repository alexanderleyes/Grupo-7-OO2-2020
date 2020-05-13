package com.unla.Grupo7OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ClienteModel;
import com.unla.Grupo7OO22020.services.IClienteService;

@Controller
@RequestMapping("cliente")
public class ClienteController {	

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	
	@PostMapping("/agregar")	
	public String agregar(ClienteModel clienteModel){		
		System.out.println("ADD cliente: " );		
		clienteModel = clienteService.insertOrUpdate(clienteModel);			
		return ViewRouteHelper.clientes_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idCliente){		
		System.out.println("MOD cliente: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.cliente_insert);
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
