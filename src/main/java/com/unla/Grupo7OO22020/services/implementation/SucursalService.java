package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.repositories.ISucursalRepository;
import com.unla.Grupo7OO22020.services.ISucursalService;

@Service("sucursalService")
public class SucursalService implements  ISucursalService{

	@Autowired
	@Qualifier("sucursalRepository")
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@Override
	public List<Sucursal> getAll(){
		return sucursalRepository.findAll();
	}
		
	
	@Override
	public SucursalModel findByGerente(Gerente gerente){
		
			Sucursal sucursal = null;
			sucursal = sucursalRepository.findByGerente(gerente);			
			return sucursalConverter.entityToModel(sucursal);
	}		
	
	@Override
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel) {
		Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
		return sucursalConverter.entityToModel(sucursal);
	}
	
	@Override
	public boolean remove(long idSucursal) {
		try {
			sucursalRepository.deleteById(idSucursal);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}
	
	
	
}
