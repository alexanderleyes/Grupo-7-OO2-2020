package com.unla.Grupo7OO22020.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.PersonaModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.models.VentaModel;
import com.unla.Grupo7OO22020.services.IClienteService;
import com.unla.Grupo7OO22020.services.IEstadoVentaService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;
import com.unla.Grupo7OO22020.services.IVentaService;

@Controller
@RequestMapping("venta")
public class VentaController {
	
	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("estadoVentaService")
	private IEstadoVentaService estadoVentaService;
	
	
	@GetMapping("/venta_idx")
	public ModelAndView index(){
			System.out.println("enruta: " +ViewRouteHelper.venta_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.venta_idx);
			String username = SecurityContextHolder.getContext().getAuthentication().getName();			
			VendedorModel vendedorModel= vendedorService.findByUsuario(username);	
			
			List<VendedorModel> vendedores = new ArrayList<VendedorModel>();
			vendedores.add(vendedorModel);
			mav.addObject("vendedores", vendedores);
			
			List<SucursalModel> sucursales = new ArrayList<SucursalModel>();
			sucursales.add(vendedorModel.getSucursal());
			mav.addObject("sucursales", sucursales);
			
			mav.addObject("sucursal", new Sucursal());
			mav.addObject("venta", new Venta());			
			mav.addObject("ventas", ventaService.getAll());	
			
			mav.addObject("clientes", clienteService.getAll());
			mav.addObject("estados", estadoVentaService.getAll());
			
			
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregarVenta(VentaModel ventaModel){		
		ventaModel.setSucursal(sucursalService.findByIdSucursal(ventaModel.getSucursal().getIdSucursal()));
		ventaModel.setVendedor(vendedorService.findByIdVendedor(ventaModel.getVendedor().getIdPersona()));
		ventaModel.setCliente((PersonaModel) clienteService.findByIdCliente(ventaModel.getCliente().getIdPersona()));
		
		System.out.println( "sucursal " + ventaModel.getSucursal().getIdSucursal());	
		
		long id = 1;
		ventaModel.setEstadoVenta(estadoVentaService.findByIdEstadoVenta(id/*ventaModel.getEstadoVenta().getIdEstadoVenta()*/));	

		ventaModel = ventaService.insertOrUpdate(ventaModel);				
		return ViewRouteHelper.venta_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView modificar( @PathVariable("id") long id){		
		System.out.println("MOD venta: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.venta_insert);
		mav.addObject("venta", ventaService.findByIdVenta(id));
		mav.addObject("ventas", ventaService.getAll());	
		mav.addObject("sucursales", sucursalService.getAll());
		mav.addObject("vendedores", vendedorService.getAll());
		mav.addObject("clientes", clienteService.getAll());
		mav.addObject("estados", estadoVentaService.getAll());
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idVenta){		
		System.out.println("ERASE venta: " );		
		ventaService.remove(idVenta);
		return ViewRouteHelper.venta_reload;
	}
	
	
		
}
