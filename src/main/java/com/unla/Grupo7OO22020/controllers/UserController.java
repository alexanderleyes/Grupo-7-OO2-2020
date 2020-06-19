package com.unla.Grupo7OO22020.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Ranking;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.services.IGerenteService;
import com.unla.Grupo7OO22020.services.IParametroService;
import com.unla.Grupo7OO22020.services.IPedidoService;
import com.unla.Grupo7OO22020.services.IRankingService;
import com.unla.Grupo7OO22020.services.ISucursalService;
import com.unla.Grupo7OO22020.services.IVendedorService;


@Controller
public class UserController {
	

	
	@Autowired
	@Qualifier("gerenteService")
	private IGerenteService gerenteService;
	

	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	

	@Autowired
	@Qualifier("rankingService")
	private IRankingService rankingService;
	

	@Autowired
	@Qualifier("parametroService")
	private IParametroService parametroService;
	
	
	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.login;		
	}
	
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.logout;
	}
		
	@GetMapping("")
	public ModelAndView loginCheckInit()  {return loginCheckBase();}
		
	
	@PostMapping("/loginsuccess")
	public ModelAndView loginCheckPost()  {return loginCheckBase();}
		
	
	@GetMapping("/loginsuccess")
	public ModelAndView loginCheckGet() {return loginCheckBase();}
	
	public ModelAndView loginCheckBase() {
		ModelAndView mav 	= new ModelAndView(ViewRouteHelper.login_ok);		
		String username 	= SecurityContextHolder.getContext().getAuthentication().getName();		
		String roleString = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();		
		List<SucursalModel> sucursales = new ArrayList<SucursalModel>();
		
		switch(roleString)				{ 				  
		   case "[ROLE_ADMIN]":				      
			   System.out.println("cosas de admin");
			   mav.addObject("sucursal", new Sucursal());
			   mav.addObject("sucursales", sucursalService.getAll());
			   break;
		   case "[ROLE_VENDEDOR]" :
			   System.out.println("cosas de vendedor");
			   VendedorModel vendedorModel =  vendedorService.findByUsuario(username);
			   List<PedidoModel> pedidos =  pedidoService.findAllBySucursalDesPending(vendedorModel.getSucursal());
			   mav.addObject("vendedor", vendedorModel);
			   mav.addObject("pedidos", pedidos);
			   break;
		   case "[ROLE_GERENTE]" :					       
			   System.out.println("cosas de gerente");
			   GerenteModel gerenteModel = gerenteService.findByUsuario(username);
			   SucursalModel sucursalModel =  sucursalService.findByGerente(gerenteModel);
			   mav.addObject("gerente", gerenteModel);
			   mav.addObject("sucursal", sucursalModel);
			   sucursales.add(sucursalModel);
			   mav.addObject("sucursales", sucursales);
			   List<Ranking> ranking = rankingService.ranking();
			   mav.addObject("rankingProd" , ranking);
			   
			   /********************RANKING PRODUCTOS************************/			   
			   Map<String, Integer> barProd = new HashMap<>();
			   long idParametro = 1;
			   int cantidad = Integer.parseInt(parametroService.findByIdParametro(idParametro).getValor());
			   
			   if (cantidad == 0 ) {
				   cantidad = 999999;
			   }
			   if (cantidad >ranking.size()) {
				   cantidad = ranking.size();
			   }
			   
			   
			   for(int i=0 ; i<cantidad; i++) {	
				   barProd.put(ranking.get(i).getNombreProd(), ranking.get(i).getCantidad());
				}			   
			   mav.addObject("bar", barProd);			   
			   /********************RANKING PRODUCTOS************************/	
			   
			   /**********************PLUS COMISIONES************************/		
			   List<VendedorModel> vendedores = vendedorService.findAllBySucursal(sucursalModel);
			   Map<String, Double> prodChart = new HashMap<>();
			   String texto = null;
			   idParametro = 2;
			   cantidad = Integer.parseInt(parametroService.findByIdParametro(idParametro).getValor());
			   
			   if (cantidad == 0 ) {
				   cantidad = 999999;
			   }			   
			   if (cantidad >vendedores.size()) {
				   cantidad = vendedores.size();
			   }
			  
			   
			   for(int i=0 ; i<cantidad; i++) {	
				   prodChart.put(vendedores.get(i).getApellido(), vendedores.get(i).getPlusSueldo());
				}		   
			   mav.addObject("prodChart", prodChart);
			   /**********************PLUS COMISIONES************************/		
			   
			   
			   

			   break;
		   default : 		
		}
		
		
		return mav ;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {return loginCheckBase();}
		
	

}
