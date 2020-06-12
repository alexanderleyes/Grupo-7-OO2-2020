package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.ParametroConverter;
import com.unla.Grupo7OO22020.entities.Parametro;
import com.unla.Grupo7OO22020.models.ParametroModel;
import com.unla.Grupo7OO22020.repositories.IParametroRepository;
import com.unla.Grupo7OO22020.services.IParametroService;

@Service("parametroService")
public class ParametroService implements  IParametroService{

	@Autowired
	@Qualifier("parametroRepository")
	private IParametroRepository parametroRepository;
	
	@Autowired
	@Qualifier("parametroConverter")
	private ParametroConverter parametroConverter;
	
	@Override
	public List<Parametro> getAll(){
		return parametroRepository.findAll();
	}

	@Override
	public ParametroModel insertOrUpdate(ParametroModel parametroModel) {
		Parametro parametro = parametroRepository.save(parametroConverter.modelToEntity(parametroModel));
		return parametroConverter.entityToModel(parametro);
	}
	
	@Override
	public boolean remove(long idParametro) {
		try {
			parametroRepository.deleteById(idParametro);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}

	@Override
	public ParametroModel findByIdParametro(long idParametro) {	
		Parametro parametro = null;
		parametro = parametroRepository.findByIdParametro(idParametro);			
		return parametroConverter.entityToModel(parametro);
	}



	
		
}
