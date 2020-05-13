package com.unla.Grupo7OO22020.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo7OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo7OO22020.models.LocalModel;
import com.unla.Grupo7OO22020.services.ILocalService;

@Controller
@RequestMapping("local")
public class LocalController {
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	
	@PostMapping("/agregar")	
	public String agregarLocal(LocalModel localModel){		
		System.out.println("emp add: " );						
		localModel = localService.insertOrUpdate(localModel);				
		return ViewRouteHelper.local_reload;
	}
	
	@PostMapping("/modificar/{id}")	
	public ModelAndView  modificar( @PathVariable("id") long id){		
		System.out.println("MOD local: "  );
		
		ModelAndView mav = new ModelAndView(ViewRouteHelper.local_insert);
		mav.addObject("local", localService.findByIdLocal(id));
		return mav;
	}
	
	@PostMapping("/eliminar/{id}")	
	public String eliminar( @PathVariable("id") long idLocal){		
		System.out.println("ERASE local: " );		
		localService.remove(idLocal);
		return ViewRouteHelper.local_reload;
	}
}
