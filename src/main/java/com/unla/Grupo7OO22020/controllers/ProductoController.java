package com.unla.Grupo7OO22020.controllers;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
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
	
	@PostMapping("/productoporfecha")	
	public ModelAndView productoXfecha(){	
		//FALTA VISTA, NO SALIO AUN XD 
		
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.producto_prodxfecha);
		//pasar un id de sucursal ( que tenga ventas ) 
		SucursalModel s = sucursalService.findByIdSucursal(5);
		
		//fechas entre la que se buscan los productos
		LocalDate fechaUno = LocalDate.of(2020, 4, 3); 
		LocalDate fechaDos = LocalDate.of(2020, 5, 3); 
		
		List<Item>result = ventaService.ProductosEntreFechasPorSucursal(sucursalConverter.modelToEntity(s), fechaUno, fechaDos);
		
		//aca imprime los productos x sucursal entre fechas
		for(Item i : result) {
			System.out.println("Sucursal: "+i.getVenta().getSucursal().getDireccion()+" Fecha: "+i.getVenta().getFecha()+ " Producto: "+i.getProducto().getDescripcion());
		}
		
		return mav;
	}	
		
}