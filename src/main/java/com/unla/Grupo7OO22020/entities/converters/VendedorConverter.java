package com.unla.Grupo7OO22020.converters;


import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.VendedorModel;

@Component("vendedorConverter")
public class VendedorConverter {
	
	public VendedorModel entityToModel(Vendedor vendedor) {
		return new VendedorModel(vendedor.getIdPersona(),  vendedor.getNombre(), vendedor.getApellido(), vendedor.getFechaNacimiento(), vendedor.getDni(), 
				 vendedor.getUsuario(), vendedor.getPassword(), vendedor.getHoraIngreso(),	vendedor.getHorasXjornada(), vendedor.getPlusSueldo(), vendedor.isBaja() );
	}
	
	public Vendedor modelToEntity(VendedorModel vendedorModel) {
		return new Vendedor(vendedorModel.getIdPersona(),vendedorModel.getNombre(), vendedorModel.getApellido(), vendedorModel.getFechaNacimiento(), vendedorModel.getDni(),  vendedorModel.getUsuario(), 
				vendedorModel.getPassword(), vendedorModel.getHoraIngreso(), vendedorModel.getHorasXjornada(), vendedorModel.getPlusSueldo(), vendedorModel.isBaja());
	}
}
