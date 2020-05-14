package com.unla.Grupo7OO22020.converters;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.SucursalModel;


@Component("sucursalConverter")
public class SucursalConverter {
	
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;
	
	public SucursalModel entityToModel(Sucursal sucursal) {
		return new SucursalModel( sucursal.getIdSucursal(), sucursal.getIdGerente(), sucursal.getTelefono(), sucursal.getLocalidad(), sucursal.getDireccion(), sucursal.getLatitud(), sucursal.getLongitud());
	}
	
	public Sucursal modelToEntity(SucursalModel sucursalModel) {
		return new Sucursal(sucursalModel.getIdSucursal(), sucursalModel.getIdGerente(), sucursalModel.getTelefono(), sucursalModel.getLocalidad(), sucursalModel.getDireccion(), sucursalModel.getLatitud(), sucursalModel.getLongitud());
	}
}
