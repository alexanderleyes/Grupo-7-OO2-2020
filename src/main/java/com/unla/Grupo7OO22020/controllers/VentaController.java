package com.unla.Grupo7OO22020.controllers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.converters.ClienteConverter;
import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.entities.VtaItems;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ClienteModel;
import com.unla.Grupo7OO22020.models.ItemModel;
import com.unla.Grupo7OO22020.models.PersonaModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.models.VentaModel;
import com.unla.Grupo7OO22020.services.IClienteService;
import com.unla.Grupo7OO22020.services.IEstadoVentaService;
import com.unla.Grupo7OO22020.services.IItemService;
import com.unla.Grupo7OO22020.services.IProductoService;
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
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("itemService")
	private IItemService itemService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("estadoVentaService")
	private IEstadoVentaService estadoVentaService;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
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
	public ModelAndView agregarVenta(VentaModel ventaModel){
		ModelAndView mav = new ModelAndView();
		
		ventaModel.setSucursal(sucursalService.findByIdSucursal(ventaModel.getSucursal().getIdSucursal()));
		ventaModel.setVendedor(vendedorService.findByIdVendedor(ventaModel.getVendedor().getIdPersona()));
		ventaModel.setCliente((PersonaModel) clienteService.findByIdCliente(ventaModel.getCliente().getIdPersona()));		
		mav.addObject("venta", ventaModel);
		mav.addObject("items", itemService.getAll());
		mav.addObject("productos", productoService.getAll());
		mav.addObject("producto", new Producto());
		mav.addObject("item", new Item());
		mav.addObject("vtaItems", new VtaItems());
		System.out.println( "sucursal " + ventaModel.getSucursal().getIdSucursal());			
		
		//ventaModel = ventaService.insertOrUpdate(ventaModel);	
		
		
//		return ViewRouteHelper.venta_reload;
		
		mav.setViewName(ViewRouteHelper.venta_items);
		return mav;	
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
	
	@PostMapping("/revisa")	
	public ModelAndView revisaItems(VtaItems vtaItems, VentaModel venta){	
		ModelAndView 	mav 				= new ModelAndView(ViewRouteHelper.venta_reload);
		
		
		System.out.println("REV venta: " + venta.toString());
		ClienteModel 	clienteModel 	= clienteService.findByIdCliente(venta.getCliente().getIdPersona());	
		venta.setCliente(clienteModel);
		SucursalModel 	sucursalModel 	= sucursalService.findByIdSucursal(venta.getSucursal().getIdSucursal());
		venta.setSucursal(sucursalModel);
		VendedorModel 	vendedorModel	= vendedorService.findByIdVendedor(venta.getVendedor().getIdVendedor());
		venta.setVendedor(vendedorModel);		
		long id = 1;		
		venta.setEstado(estadoVentaService.findByIdEstadoVenta(id));
		
		System.out.println("cli : " + clienteModel);	
		System.out.println("suc : " + sucursalModel);	
		System.out.println("ven : " + vendedorModel);	
		List<Long> prodIndices  	= vtaItems.getListaIndices();
		List<Long> prodCantidades 	= vtaItems.getListaCantidad();
		
		venta = ventaService.insertOrUpdate(venta);
		
		int largo = prodIndices.size();
		for (int i = 0; i < largo; i++) {
			ProductoModel productoModel = productoService.findByIdProducto(prodIndices.get(i));
			double 		cantidad 	= Double.parseDouble(prodCantidades.get(i).toString());
			ItemModel 	itemModel 	= new ItemModel(productoModel, cantidad, venta);
			itemService.insertOrUpdate(itemModel);
		}
		
		/********************************/
		/**Aca deberia estar la logica para consumir el stock que tengo y/o enviar la solicitud de stock a otra sucursal**/
		/********************************/		
		
		return mav;
	}
	
	
	@PostMapping("/verDetalle/{id}")	
	public ModelAndView  verDetalle( @PathVariable("id") long idVenta){		
		System.out.println("DET venta: "  );		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.venta_detalles);
		VentaModel ventaModel = ventaService.findByIdVenta(idVenta);
		mav.addObject("venta", ventaModel);
		List<ItemModel> items = itemService.findAllByVenta(ventaModel);		
		mav.addObject("items", items);
		double total = 0;
		for (ItemModel i : items) {
			total = total + i.getCantidad() * i.getProducto().getPrecioUnitario();
		}
		mav.addObject("total", total);
		
		
		return mav;
	}
	
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idVenta){		
		System.out.println("ERASE venta: " );		
		ventaService.remove(idVenta);
		return ViewRouteHelper.venta_reload;
	}		
}