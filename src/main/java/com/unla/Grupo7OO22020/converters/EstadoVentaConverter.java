package com.unla.Grupo7OO22020.converters;


import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.EstadoVenta;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;

@Component("estadoVentaConverter")
public class EstadoVentaConverter {
	
	public EstadoVentaModel entityToModel(EstadoVenta estadoVenta) {
		return new EstadoVentaModel(estadoVenta.getIdEstadoVenta(), estadoVenta.getNombre(), estadoVenta.getDescripcion());
	}
	
	public EstadoVenta modelToEntity(EstadoVentaModel estadoVentaModel) {
		return new EstadoVenta(estadoVentaModel.getIdEstadoVenta(), estadoVentaModel.getNombre(), estadoVentaModel.getDescripcion());
	}
}
