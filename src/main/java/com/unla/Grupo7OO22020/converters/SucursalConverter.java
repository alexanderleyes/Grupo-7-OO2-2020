package com.unla.Grupo7OO22020.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.SucursalModel;



@Component("sucursalConverter")
public class SucursalConverter {
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;
	
	public SucursalModel entityToModel(Sucursal sucursal) {
		return new SucursalModel(
				sucursal.getIdSucursal(), 
				sucursal.getTelefono(), 
				sucursal.getLocalidad(), 
				sucursal.getDireccion(), 
				sucursal.getLatitud(), 
				sucursal.getLongitud(), 
				gerenteConverter.entityToModel(sucursal.getGerente()));
	}
	
	public Sucursal modelToEntity(SucursalModel sucursalModel) {
		if (sucursalModel != null) {
			return new Sucursal(
				sucursalModel.getIdSucursal(), 
				sucursalModel.getTelefono(), 
				sucursalModel.getLocalidad(), 
				sucursalModel.getDireccion(), 
				sucursalModel.getLatitud(), 
				sucursalModel.getLongitud(),
				gerenteConverter.modelToEntity(sucursalModel.getGerente()));
		}else {
			return null;
		}
	}
}
