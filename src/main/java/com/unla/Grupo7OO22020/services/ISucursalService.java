package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;

public interface ISucursalService {
	public List<Sucursal> getAll();		
	public boolean remove(long id);
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel);
	public SucursalModel findByIdSucursal(long id);
	public List<Sucursal> distancias(SucursalModel sucursal, ProductoModel producto, int cantidad);
	
	
	
	
}
