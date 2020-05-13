package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.LocalConverter;
import com.unla.Grupo7OO22020.entities.Local;
import com.unla.Grupo7OO22020.models.LocalModel;
import com.unla.Grupo7OO22020.repositories.ILocalRepository;
import com.unla.Grupo7OO22020.services.ILocalService;

@Service("localService")
public class LocalService implements  ILocalService{


	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;

	@Override
	public List<Local> getAll() {
		return localRepository.findAll();
	}

	@Override
	public LocalModel findByIdLocal(long id) {				
		return localConverter.entityToModel(localRepository.findByIdLocal(id));
	}

	@Override
	public boolean remove(long id) {
		try {
			localRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}	
		
	}

	@Override
	public LocalModel insertOrUpdate(LocalModel localModel) {
		Local local = localRepository.save(localConverter.modelToEntity(localModel));
		return localConverter.entityToModel(local);
	}
	
	
		
			
		
	
	
	
	
	
	
	
}
