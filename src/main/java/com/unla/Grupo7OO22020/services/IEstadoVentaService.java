package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.EstadoVenta;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;

public interface IEstadoVentaService {
	public List<EstadoVenta> getAll();		
	public boolean remove(long id);
	public EstadoVentaModel insertOrUpdate(EstadoVentaModel estadoVentaModel);
	public EstadoVentaModel findByIdEstadoVenta(long id);	
	
}
