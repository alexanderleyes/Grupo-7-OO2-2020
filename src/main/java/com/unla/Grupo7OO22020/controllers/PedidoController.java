package com.unla.Grupo7OO22020.controllers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.converters.VendedorConverter;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.IPedidoService;
import com.unla.Grupo7OO22020.services.IProductoService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;

@Controller
@PreAuthorize("hasRole('ADMIN') or hasRole('VENDEDOR')")
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;

	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@GetMapping("/pedido_idx")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.pedido_idx);
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();		
		String roleString = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();			
		
		
		
		switch(roleString)				{ 				  
		   case "[ROLE_ADMIN]":				      
			   System.out.println("cosas de admin");
			   	mav.addObject("vendedoresOri", vendedorService.getAll());
				mav.addObject("sucursalesOri", sucursalService.getAll());
				mav.addObject("sucursalesDes", sucursalService.getAll());
				mav.addObject("pedido", new Pedido());
				mav.addObject("pedidos", pedidoService.getAll());	
				
				mav.addObject("vendedoresDes", vendedorService.getAll());
				mav.addObject("productos", productoService.getAll());
			   break;
		   case "[ROLE_VENDEDOR]" :			   
			   
			   System.out.println("cosas de vendedor");
			   VendedorModel vendedorModel = vendedorService.findByUsuario(username);
			   mav.addObject("pedidosMios", pedidoService.findAllByVendedor(vendedorModel));
			   mav.addObject("pedidos", pedidoService.findAllBySucursal(vendedorModel.getSucursal())); 
			  
			   break;
		   case "[ROLE_GERENTE]" :					       
			   System.out.println("cosas de gerente");
			 //El gerente no realiza Pedidos
			   break;
		   default : 			
		}		
		
		
		return mav;
	}

	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPedido){					
		ModelAndView mav = new ModelAndView(ViewRouteHelper.pedido_insert);
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();		
		String roleString = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();			
		
	
		mav.addObject("pedido", pedidoService.findById(idPedido));		
		
		switch(roleString)				{ 				  
		   case "[ROLE_ADMIN]":				      
			   System.out.println("cosas de admin");
			   List<Sucursal> sucursales = sucursalService.getAll();
			   mav.addObject("sucursalesOri", sucursales);
			   mav.addObject("sucursalesDes", sucursales);
			   List<Vendedor> vendedores = vendedorService.getAll();
			   mav.addObject("vendedoresOri", vendedores);
			   mav.addObject("vendedoresDes", vendedores);
			   mav.addObject("productos", productoService.getAll());			   
			   break;
		   case "[ROLE_VENDEDOR]" :	   
			   VendedorModel vendedorModel = vendedorService.findByUsuario(username);
			   List<Sucursal> sucursalMia = new ArrayList<Sucursal>();			   
			   sucursalMia.add(sucursalConverter.modelToEntity(vendedorModel.getSucursal()));
			   mav.addObject("sucursalesOri", sucursalMia);
			   mav.addObject("sucursalesDes", sucursalService.getAll());
			   List<Vendedor> vendedoresYo = new ArrayList<Vendedor>();
			   vendedoresYo.add(vendedorConverter.modelToEntity(vendedorModel));
			   mav.addObject("vendedoresOri", vendedoresYo);
			   mav.addObject("vendedoresDes", vendedorService.getAll());
			   mav.addObject("productos", productoService.getAll());
			   

			   System.out.println("cosas de vendedor");
			//   VendedorModel vendedorModel = vendedorService.findByUsuario(username);
			   mav.addObject("pedidos", pedidoService.findAllBySucursal(vendedorModel.getSucursal()));			  
			   break;
		   case "[ROLE_GERENTE]" :					       
			   System.out.println("cosas de gerente");
			 //El gerente no realiza Pedidos
			   break;
		   default : 			
		}		
		return mav;
	}	
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.pedido_insert);
		mav.addObject("pedido", pedidoService.findById(id));	
		
		return mav;
	}	
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		pedidoService.remove(id);
		return ViewRouteHelper.pedido_reload;
	}
	
	@PostMapping("/despachar/{id}")
	public ModelAndView despachar(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.home);
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();		
		PedidoModel pedidoModel = pedidoService.findById(id);
		pedidoModel.setVendedorDespacha(vendedorService.findByUsuario(username));
		pedidoService.insertOrUpdate(pedidoModel);		
		return mav;
	}
	
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("pedido") PedidoModel pedidoModel){			
		
		pedidoModel.setSucOrigen(sucursalService.findByIdSucursal(pedidoModel.getSucOrigen().getIdSucursal()));
		pedidoModel.setSucDestino(sucursalService.findByIdSucursal(pedidoModel.getSucDestino().getIdSucursal()));
		pedidoModel.setVendedorSolicita(vendedorService.findByIdVendedor(pedidoModel.getVendedorSolicita().getIdPersona()));
		pedidoModel.setVendedorDespacha(vendedorService.findByIdVendedor(pedidoModel.getVendedorDespacha().getIdPersona()));	
		pedidoModel.setProducto(productoService.findByIdProducto(pedidoModel.getProducto().getIdProducto()));

		pedidoModel = pedidoService.insertOrUpdate(pedidoModel);
		
		return ViewRouteHelper.pedido_reload;
	}
	
	@GetMapping("/cercana/{id}/{idp}/{cant}")
	public ModelAndView cercanas(@PathVariable("id") long id,@PathVariable("idp") long idp,@PathVariable("cant") int cant) {
		System.out.println("cerc sucursal: " + id);
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.cercana_view);
		SucursalModel sucursal = sucursalService.findByIdSucursal(id);
		
		ProductoModel producto = productoService.findByIdProducto(idp);
		
		mAV.addObject("sucursal", new Sucursal());
		mAV.addObject("producto", new Sucursal());
		mAV.addObject(sucursalService.distancias(sucursal, producto, cant));
		mAV.addObject("sucursales", sucursalService.distancias(sucursal,producto,cant));
		return mAV;
		
	}
	
}