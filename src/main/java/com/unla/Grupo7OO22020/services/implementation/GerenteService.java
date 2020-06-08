package com.unla.Grupo7OO22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.GerenteConverter;
import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.repositories.IGerenteRepository;
import com.unla.Grupo7OO22020.repositories.ISucursalRepository;
import com.unla.Grupo7OO22020.services.IGerenteService;

@Service("gerenteService")
public class GerenteService implements  IGerenteService{

	@Autowired
	@Qualifier("gerenteRepository")
	private IGerenteRepository gerenteRepository;
	
	@Autowired
	@Qualifier("sucursalRepository")
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;
	
	@Override
	public List<Gerente> getAll(){
		return gerenteRepository.findAll();
	}
		
	
	@Override
	public GerenteModel findByApellido(String apellido){
		
			Gerente gerente = null;
			gerente = gerenteRepository.findByApellido(apellido);
			
			if(gerente == null) {
				System.out.println("Gerente null");
				gerente = new Gerente();
				gerente.setUsuario("dummy");
			}else {
				return gerenteConverter.entityToModel(gerente);
			}			
			return gerenteConverter.entityToModel(gerente);
	}
	
	
	@Override
	public GerenteModel findByDni(int dni){
		
			Gerente gerente = null;
			gerente = gerenteRepository.findByDni(dni);
			
			if(gerente == null) {				
				gerente = new Gerente();
				gerente.setUsuario("dummy");
			}else {
				return gerenteConverter.entityToModel(gerente);
			}			
			return gerenteConverter.entityToModel(gerente);
	}	
	
	@Override
	public GerenteModel findByUsuario(String usuario){
		
		Gerente gerente = null;
		gerente = gerenteRepository.findByUsuario(usuario);
		
		if(gerente != null) {	
			return gerenteConverter.entityToModel(gerente);
		}			
		return null;
}	
	
	
	
	@Override
	public GerenteModel insertOrUpdate(GerenteModel gerenteModel) {
		Gerente gerente = gerenteRepository.save(gerenteConverter.modelToEntity(gerenteModel));
		return gerenteConverter.entityToModel(gerente);
	}
	
	@Override
	public boolean remove(long idGerente) {
		try {
			gerenteRepository.deleteById(idGerente);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}


	@Override
	public GerenteModel findByIdGerente(long id) {
		Gerente gerente = null;
		gerente = gerenteRepository.findByIdPersona(id);			
		return gerenteConverter.entityToModel(gerente);
	}
	
	@Override
	public List<Gerente> findByDisponibles(){
		
		List<Gerente> gerentesDisponibles = new ArrayList<Gerente>();
		List<Gerente> gerentes = gerenteRepository.findAll();
		List<Sucursal> sucursales = sucursalRepository.findAll();
		for(Gerente g: gerentes) {
			boolean encontro = false;
			for(Sucursal s: sucursales) {			
				if(g.getIdPersona() == s.getGerente().getIdPersona() ) {
					encontro = true;
					//break;
				}
			}
			if(!encontro) {
				gerentesDisponibles.add(g);			
			
			}
		}
		return gerentesDisponibles;
		}		
	
}
