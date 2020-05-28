package com.unla.Grupo7OO22020.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.EstadoVenta;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;

@Component("estadoVentaConverter")
public class EstadoVentaConverter {
	
	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;
	
	public EstadoVentaModel entityToModel(EstadoVenta estadoVenta) {
		return new EstadoVentaModel(estadoVenta.getIdEstadoVenta(), 
				estadoVenta.getNombre(), 
				estadoVenta.getDescripcion()/*,
				ventaConverter.entityToModel(estadoVenta.getVenta())*/);
	}
	
	public EstadoVenta modelToEntity(EstadoVentaModel estadoVentaModel) {
		return new EstadoVenta(estadoVentaModel.getIdEstadoVenta(), 
				estadoVentaModel.getNombre(), 
				estadoVentaModel.getDescripcion()/*, 
				ventaConverter.modelToEntity(estadoVentaModel.getVenta())*/);
	}
}
