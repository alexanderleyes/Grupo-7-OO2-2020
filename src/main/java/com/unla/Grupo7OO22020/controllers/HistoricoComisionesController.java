package com.unla.Grupo7OO22020.controllers;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.converters.HistoricoComisionesConverter;
import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.converters.VendedorConverter;
import com.unla.Grupo7OO22020.converters.VentaConverter;
import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.HistoricoComisiones;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.helpers.Funciones;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.IHistoricoComisionesService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;



@Controller
@RequestMapping("historicoComisiones")
public class HistoricoComisionesController {	

	@Autowired
	@Qualifier("historicoComisionesService")
	private IHistoricoComisionesService historicoComisionesService;
	
	@Autowired
	@Qualifier("historicoComisionesConverter")
	private HistoricoComisionesConverter historicoComisionesConverter;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@GetMapping("/historicoComisiones_idx")
	public ModelAndView historicosComisiones(){
			System.out.println("enruta: " +ViewRouteHelper.historicoCom_idx);
			ModelAndView mav = new ModelAndView(ViewRouteHelper.historicoCom_idx);
			String username 	= SecurityContextHolder.getContext().getAuthentication().getName();
			GerenteModel gerente		= gerenteService.findByUsuario(username);
			SucursalModel sucursal		= sucursalService.findByGerente(gerente);			
			mav.addObject("historicoComisiones", new HistoricoComisiones());
			mav.addObject("historicos", historicoComisionesService.getAll());			
			return mav;			
		}
	
	
	@GetMapping("/cierreMes/{fecha}")	
	public ModelAndView cierreMes(@PathVariable("fecha") String fechaString){
		
			
		
		System.out.println("cierre : " +fechaString);
		
		LocalDate fecha = Funciones.stringToLocalDate(fechaString);
		int ultimoDiaMes = Funciones.traerCantDiasDeUnMes(Funciones.traerAnio(fecha), Funciones.traerMes(fecha)-1);
		ModelAndView mav = new ModelAndView();
		
		if (ultimoDiaMes != Funciones.traerDia(fecha)) {
			mav.setViewName(ViewRouteHelper.historico_cie);			
		}else {
			mav.setViewName(ViewRouteHelper.historico_cieno);
			return mav;			
		}
		
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();
		GerenteModel gerente		= gerenteService.findByUsuario(username);
		SucursalModel sucursal		= sucursalService.findByGerente(gerente);
		
		List<HistoricoComisiones> historicosAux = historicoComisionesService.findByFechaAndSucursal(fecha, sucursalConverter.modelToEntity(sucursal));	
		
		System.out.println("cantidad : " +historicosAux.size());
		
		if (historicosAux.size() > 0) {
			mav.setViewName(ViewRouteHelper.historico_ciesi);
			return mav;	
		}
		
		List<HistoricoComisiones> historicos = new ArrayList<HistoricoComisiones>();
		
		List<VendedorModel> vendedores = vendedorService.findAllBySucursal(sucursal);
		
		HistoricoComisiones historico = new HistoricoComisiones();
		for(VendedorModel v: vendedores) {
			Vendedor vendedor = vendedorConverter.modelToEntitySinSucursal(v);
			
			
			historico = new HistoricoComisiones(LocalDate.now(), vendedor, vendedor.getPlusSueldo(), sucursalConverter.modelToEntity(sucursal));			
			historico = historicoComisionesService.insertOrUpdate(historico);
			historicos.add(historico);
			
			v.setPlusSueldo(0);
			vendedorService.insertOrUpdate(v);
		}
		
		mav.addObject("historicoComisiones", new HistoricoComisiones());
		mav.addObject("historicos", historicos);			
		return mav;			
	}
}
	
	

