package com.unla.Grupo7OO22020.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ItemModel;
import com.unla.Grupo7OO22020.models.PersonaModel;
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
	
	
	@GetMapping("/venta_idx")
	public ModelAndView index(){
//			System.out.println("enruta: " +ViewRouteHelper.venta_idx);
//			ModelAndView mav = new ModelAndView(ViewRouteHelper.venta_idx);
			System.out.println("enruta: " +ViewRouteHelper.venta_prueba);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.venta_prueba);
			
			
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
			
			mav.addObject("producto", new Producto());
			mav.addObject("productos", productoService.getAll());
			
			mav.addObject("item", new Item());
			mav.addObject("items", itemService.getAll());
			
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public /* ModelAndView */ String agregarVenta(VentaModel ventaModel){
		ModelAndView mav = new ModelAndView();
		
		ventaModel.setSucursal(sucursalService.findByIdSucursal(ventaModel.getSucursal().getIdSucursal()));
		ventaModel.setVendedor(vendedorService.findByIdVendedor(ventaModel.getVendedor().getIdPersona()));
		ventaModel.setCliente((PersonaModel) clienteService.findByIdCliente(ventaModel.getCliente().getIdPersona()));		
		mav.addObject("venta", ventaModel);
		mav.addObject("items", itemService.getAll());
		mav.addObject("productos", productoService.getAll());
		mav.addObject("producto", new Producto());
		mav.addObject("item", new Item());
		System.out.println( "sucursal " + ventaModel.getSucursal().getIdSucursal());	
		
		long id = 1;
		ventaModel.setEstadoVenta(estadoVentaService.findByIdEstadoVenta(id/*ventaModel.getEstadoVenta().getIdEstadoVenta()*/));	

		ventaModel = ventaService.insertOrUpdate(ventaModel);	
		
		
		return ViewRouteHelper.venta_reload;
		
//		mav.setViewName(ViewRouteHelper.venta_items);
//		return mav;	
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
	
	
//	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
//    public String create(
//            @RequestParam(value = "stname1") String[] stname1,
//            @RequestParam(value = "marks1") Integer[] marks1,
//            BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//
//    List<EntityPojo> list = new ArrayList<EntityPojo>();
//    for(int i=0; i < stname1.length; i++){
//        EntityPojo pojo = new EntityPojo();
//        pojo.setStName(stname1[i]);
//        pojo.setMarks(marks1[i]);
//        list.add(pojo);
//    }

	

}