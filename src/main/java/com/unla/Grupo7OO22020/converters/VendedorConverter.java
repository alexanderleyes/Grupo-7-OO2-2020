package com.unla.Grupo7OO22020.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.VendedorModel;

@Component("vendedorConverter")
public class VendedorConverter {
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	public VendedorModel entityToModel(Vendedor vendedor) {
		return new VendedorModel(
				vendedor.getIdPersona(),
				sucursalConverter.entityToModel(vendedor.getSucursal()),
				vendedor.getNombre(),
				vendedor.getApellido(),
				vendedor.getFechaNacimiento(),
				vendedor.getDni(),
				vendedor.getIdPersona(),
				vendedor.getUsuario(),
				vendedor.getPassword(),
				vendedor.getHoraIngreso(),
				vendedor.getHorasXjornada(),
				vendedor.getPlusSueldo(),
				vendedor.getIdPersona());
	}
	
	public Vendedor modelToEntity(VendedorModel vendedorModel) {
		return new Vendedor(
				sucursalConverter.modelToEntity(vendedorModel.getSucursal()),
				vendedorModel.getIdPersona(),
				vendedorModel.getNombre(),
				vendedorModel.getApellido(),
				vendedorModel.getFechaNacimiento(),
				vendedorModel.getDni(),
				vendedorModel.getUsuario(), 
				vendedorModel.getPassword(),
				vendedorModel.getHoraIngreso(),
				vendedorModel.getHorasXjornada(),
				vendedorModel.getPlusSueldo(),
				vendedorModel.isBaja());
	}
}
