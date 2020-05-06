package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.GerenteConverter;
import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.repositories.IGerenteRepository;
import com.unla.Grupo7OO22020.services.IGerenteService;

@Service("gerenteService")
public class GerenteService implements  IGerenteService{

	@Autowired
	@Qualifier("gerenteRepository")
	private IGerenteRepository gerenteRepository;
	
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
				System.out.println("Gerente null");
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
	
	
	
}
