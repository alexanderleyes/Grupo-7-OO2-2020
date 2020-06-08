package com.unla.Grupo7OO22020.controllers;
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

import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.IProductoService;
import com.unla.Grupo7OO22020.services.IRankingService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVentaService;

@Controller
@RequestMapping("sucursal")
public class SucursalController {
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;
	
	@Autowired
	@Qualifier("rankingService")
	private IRankingService rankingService;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@GetMapping("/sucursal_idx")
	public ModelAndView sucursales(){
			System.out.println("enruta: " +ViewRouteHelper.sucursal_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.sucursal_idx);	
			mav.addObject("sucursal", new Sucursal());
			mav.addObject("sucursales", sucursalService.getAll());
			//mav.addObject("gerentes", gerenteService.getAll());
			mav.addObject("gerentes", gerenteService.findByDisponibles());
			mav.addObject("gerente", new Gerente());		
			return mav;			
		}
	
	@PostMapping("/agregar")	
	public String agregarSucursal(SucursalModel sucursalModel){		
		System.out.println("emp add: " );						
		sucursalModel = sucursalService.insertOrUpdate(sucursalModel);
		
		sucursalModel.setGerente(gerenteService.findByIdGerente(sucursalModel.getGerente().getIdGerente()));
		sucursalModel = sucursalService.insertOrUpdate(sucursalModel);
		return ViewRouteHelper.sucursal_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long id){		
		System.out.println("MOD sucursal: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.sucursal_insert);
		mav.addObject("sucursal", sucursalService.findByIdSucursal(id));
		
		Object userDet =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("user", userDet);
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idSucursal){		
		System.out.println("ERASE sucursal: " );		
		sucursalService.remove(idSucursal);
		return ViewRouteHelper.sucursal_reload;
	}
	
	
	@GetMapping("/stock/{idSucursal}/{idProducto}")
	public ModelAndView cercanas(@PathVariable("idSucursal") long idSucursal,@PathVariable("idProducto") long idProducto) {
		ModelAndView mav = new ModelAndView();		
	
		int cantStock = sucursalService.stock(idSucursal, idProducto);	
		mav.addObject("cantStock", cantStock);
		mav.setViewName(ViewRouteHelper.producto_stock); 		
		return mav;
		
	}
	
	@GetMapping("/cercana/{id}/{idp}/{cant}")
	public ModelAndView cercanas(@PathVariable("id") long id,@PathVariable("idp") long idp,@PathVariable("cant") int cant) {
		ModelAndView mAV = new ModelAndView();
		
		System.out.println("cerc sucursal: " + id);
	
		SucursalModel sucursal = sucursalService.findByIdSucursal(id);		
		ProductoModel producto = productoService.findByIdProducto(idp);
		
		mAV.addObject("sucursal", new Sucursal());
		mAV.addObject("producto", new Producto());	
		
		
		List<Sucursal> resultado =  sucursalService.distancias(sucursal,producto,cant);
	
		if (resultado.size() >0) {
			mAV.setViewName(ViewRouteHelper.cercana_view); 
			mAV.addObject("sucursalesDes", resultado);			
		}
		else {	
			mAV.setViewName(ViewRouteHelper.cercana_sin); 		
		}
		
		return mAV;
		
	}
		
}
