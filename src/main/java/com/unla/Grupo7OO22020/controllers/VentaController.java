package com.unla.Grupo7OO22020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.PersonaModel;
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
	public ModelAndView ventaes(){
			System.out.println("enruta: " +ViewRouteHelper.venta_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.venta_idx);	
			mav.addObject("venta", new Venta());
			mav.addObject("ventas", ventaService.getAll());	
			mav.addObject("sucursales", sucursalService.getAll());
			mav.addObject("vendedores", vendedorService.getAll());
			mav.addObject("clientes", clienteService.getAll());
			mav.addObject("estados", estadoVentaService.getAll());
			
			Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			mav.addObject("user", userDet);
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregarVenta(VentaModel ventaModel){		
		System.out.println("emp add: " );	
		ventaModel.setSucursal(sucursalService.findByIdSucursal(ventaModel.getSucursal().getIdSucursal()));
		ventaModel.setVendedor(vendedorService.findByIdVendedor(ventaModel.getVendedor().getIdPersona()));
		ventaModel.setCliente((PersonaModel) clienteService.findByIdCliente(ventaModel.getCliente().getIdPersona()));
		ventaModel.setEstadoVenta(estadoVentaService.findByIdEstadoVenta(ventaModel.getEstadoVenta().getIdEstadoVenta()));	

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
