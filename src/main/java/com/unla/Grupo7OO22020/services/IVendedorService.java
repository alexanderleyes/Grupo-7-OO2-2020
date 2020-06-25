package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;

public interface IVendedorService {
	public List<Vendedor> getAll();	
	public VendedorModel insertOrUpdate(VendedorModel vendedorModel);
	public boolean remove(long idvendedor);
	public VendedorModel findByApellido(String Apellido);
	public VendedorModel findByDni(int dni);
	public VendedorModel findByUsuario(String usuario);
	public VendedorModel findByIdVendedor(long id);
	public List<VendedorModel> findAllBySucursal(SucursalModel sucursalModel);
	
}
