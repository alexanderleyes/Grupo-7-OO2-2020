package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.SucursalModel;

public interface ISucursalService {
	public List<Sucursal> getAll();	
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel);
	public boolean remove(long idSucursal);
	public SucursalModel findByGerente(Gerente gerente);
	
	public SucursalModel findByIdSucursal(long id);
}
