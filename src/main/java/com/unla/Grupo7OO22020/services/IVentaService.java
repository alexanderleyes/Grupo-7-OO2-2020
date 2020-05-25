package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.VentaModel;

public interface IVentaService {
	public List<Venta> getAll();		
	public boolean remove(long id);
	public VentaModel insertOrUpdate(VentaModel ventaModel);
	public VentaModel findByIdVenta(long id);
	
}
