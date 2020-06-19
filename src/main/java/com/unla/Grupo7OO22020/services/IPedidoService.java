package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;

public interface IPedidoService {

	public PedidoModel findById(long id);

	public List<Pedido> getAll();

	public PedidoModel insertOrUpdate(PedidoModel pedidoModel);

	public boolean remove(long id);	

	public List<PedidoModel> findAllBySucursalDesPending(SucursalModel sucursal);

	public List<PedidoModel> findAllBySucursalExceptVendedor(SucursalModel sucursal, VendedorModel vendedor);

	public List<PedidoModel> findAllByVendedor(VendedorModel vendedor);

	public List<PedidoModel> findAllBySucursalOri(SucursalModel sucursal);
	
	public List<Pedido> findAllByIDVenta(long id);

	public List<PedidoModel> findAllBySucursalDes(SucursalModel sucursal);
	
	


	


}
