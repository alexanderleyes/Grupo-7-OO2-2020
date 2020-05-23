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

import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.services.IPedidoService;
import com.unla.Grupo7OO22020.services.IProductoService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;

@Controller
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
	
	@GetMapping("/pedido_idx")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.pedido_idx);
		mAV.addObject("pedido", new Pedido());
		mAV.addObject("pedidos", pedidoService.getAll());
		mAV.addObject("sucursales", sucursalService.getAll());
		mAV.addObject("vendedores", vendedorService.getAll());
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}

	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idPedido){		
				
		ModelAndView mav = new ModelAndView(ViewRouteHelper.pedido_insert);
		mav.addObject("pedido", new Pedido());
		mav.addObject("pedido", pedidoService.findById(idPedido));
		mav.addObject("sucursales", sucursalService.getAll());
		mav.addObject("vendedores", vendedorService.getAll());
		mav.addObject("productos", productoService.getAll());		
		return mav;
	}	
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.pedido_insert);
		mAV.addObject("pedido", pedidoService.findById(id));
		return mAV;
	}	
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		pedidoService.remove(id);
		return ViewRouteHelper.pedido_reload;
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