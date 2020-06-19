package com.unla.Grupo7OO22020.controllers;
import java.time.LocalDate;
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
import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Ranking;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.helpers.Funciones;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.ItemModel;
import com.unla.Grupo7OO22020.models.LoteModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.IProductoService;
import com.unla.Grupo7OO22020.services.IRankingService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVentaService;



@Controller
@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE')")
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("rankingService")
	private IRankingService rankingService;
	
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	

	
	@GetMapping("/producto_idx")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_idx);
		mav.addObject("producto", new Producto());
		mav.addObject("productos", productoService.getAll());
		
		return mav;
	}
	
	
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long idProducto){				
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", new Producto());
		mav.addObject("producto", productoService.findByIdProducto(idProducto));		
		return mav;
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("producto") ProductoModel productoModel) {
	productoModel = productoService.insertOrUpdate(productoModel);			
	return ViewRouteHelper.producto_reload;
	}

	 @GetMapping("/update/{id}")
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", productoService.findByIdProducto(id));		
		return mav;		
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_insert);
		mav.addObject("producto", productoService.findByIdProducto(id));		
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		productoService.eliminar(id);
		return ViewRouteHelper.producto_reload;
	}
	
	@PostMapping("/agregar")	
	public String agregar(@ModelAttribute("producto") ProductoModel productoModel){		
		productoModel = productoService.insertOrUpdate(productoModel);			
		return ViewRouteHelper.producto_reload;
	}	
	
	@PostMapping("/ranking")	
	public ModelAndView ranking(){
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_ranking);
		mav.addObject("ranking", new Ranking());
		mav.addObject("rankings",rankingService.ranking() );	
		List<Ranking>ran = rankingService.ranking();
		for(Ranking r: ran) {
			System.out.println("Producto: " + r.getnombreProd() + " Cantidad: " + r.getCantidad());
		}		
		return mav;
	}
	
	@GetMapping("/productosPorFecha/{desde}/{hasta}/{tipo}/{idSuc}")	
	public ModelAndView productosPorFecha( @PathVariable("desde") String desdeString,  @PathVariable("hasta") String hastaString, @PathVariable("tipo") String tipo, @PathVariable("idSuc") long idSuc){
		
		String username 			= SecurityContextHolder.getContext().getAuthentication().getName();	
		GerenteModel gerenteModel 	= gerenteService.findByUsuario(username);
		SucursalModel sucursalModel =  sucursalService.findByIdSucursal(idSuc);
		ModelAndView  mav = new ModelAndView(); 
		
		LocalDate desde = Funciones.stringToLocalDate(desdeString);
		LocalDate hasta = Funciones.stringToLocalDate(hastaString);
		
		
		switch(tipo) { 				  
		 	case "ventas":
		 		List<Item> items = ventaService.ProductosEntreFechasPorSucursal(sucursalConverter.modelToEntity(sucursalModel), desde, hasta);
		 		if (items.size() > 0) {
		 			mav.addObject("items", items);			 		
			 		mav.setViewName(ViewRouteHelper.productoxfecha);
		 		}else {
		 			mav.setViewName(ViewRouteHelper.sin_registros);
		 		}		 		
		 		break;		   
		 	default : 		
		}	
	
	
		return mav;
	}
		
}