package com.unla.Grupo7OO22020.services;

import java.util.List;
import java.util.Set;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;

public interface ISucursalService {
	public List<Sucursal> getAll();		
	public boolean remove(long id);
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel);
	public SucursalModel findByIdSucursal(long id);
	public List<Sucursal> distancias(SucursalModel sucursal, ProductoModel producto, int cantidad);
	public SucursalModel findByGerente(GerenteModel gerenteModel );
	public List<SucursalModel>  findAllExcept(SucursalModel sucursalModel);
	public int stock (long idSucursal, long idProducto);
	
	
	
	
	
}
