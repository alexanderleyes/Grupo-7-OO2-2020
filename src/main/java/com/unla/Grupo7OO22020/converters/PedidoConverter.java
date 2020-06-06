package com.unla.Grupo7OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.models.PedidoModel;

@Component("pedidoConverter")
public class PedidoConverter {
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	
	
	
	
	
	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel(
				pedido.getIdPedido(),
				sucursalConverter.entityToModel(pedido.getSucOrigen()),
				sucursalConverter.entityToModel(pedido.getSucDestino()),
				vendedorConverter.entityToModel(pedido.getVendedorSolicita()),
				vendedorConverter.entityToModel(pedido.getVendedorDespacha()),
				productoConverter.entityToModel(pedido.getProducto()), 
				pedido.getCantidad());
	}
	
	public PedidoModel entityToModelSinDespachante(Pedido pedido) {
		return new PedidoModel(
				pedido.getIdPedido(),
				sucursalConverter.entityToModel(pedido.getSucOrigen()),
				sucursalConverter.entityToModel(pedido.getSucDestino()),
				vendedorConverter.entityToModel(pedido.getVendedorSolicita()),				
				productoConverter.entityToModel(pedido.getProducto()), 
				pedido.getCantidad());
	}
	
	
	/***********************************************************************************/
	public Pedido modelToEntitySinDespachante(PedidoModel pedidoModel) {
		return new Pedido(
				pedidoModel.getIdPedido(),
				sucursalConverter.modelToEntity(pedidoModel.getSucOrigen()),
				sucursalConverter.modelToEntity(pedidoModel.getSucDestino()),
				vendedorConverter.modelToEntity(pedidoModel.getVendedorSolicita()),				
				productoConverter.modelToEntity(pedidoModel.getProducto()), 
				pedidoModel.getCantidad());
	}
	public Pedido modelToEntity(PedidoModel pedidoModel) {
		return new Pedido(
				pedidoModel.getIdPedido(),
				sucursalConverter.modelToEntity(pedidoModel.getSucOrigen()),
				sucursalConverter.modelToEntity(pedidoModel.getSucDestino()),
				vendedorConverter.modelToEntity(pedidoModel.getVendedorSolicita()),
				vendedorConverter.modelToEntity(pedidoModel.getVendedorDespacha()),
				productoConverter.modelToEntity(pedidoModel.getProducto()),
				pedidoModel.getCantidad());
		
	}
	
	/*****************************************************************************************/
	
	public PedidoModel entityToModelSinDespachanteConIdVenta(Pedido pedido) {
		return new PedidoModel(
				pedido.getIdPedido(),
				sucursalConverter.entityToModel(pedido.getSucOrigen()),
				sucursalConverter.entityToModel(pedido.getSucDestino()),
				vendedorConverter.entityToModel(pedido.getVendedorSolicita()),				
				productoConverter.entityToModel(pedido.getProducto()), 
				pedido.getCantidad(),
				pedido.getIdVenta());
	}
	
	
	public Pedido modelToEntitySinDespachanteConIdVenta(PedidoModel pedidoModel) {
		return new Pedido(
				pedidoModel.getIdPedido(),
				sucursalConverter.modelToEntity(pedidoModel.getSucOrigen()),
				sucursalConverter.modelToEntity(pedidoModel.getSucDestino()),
				vendedorConverter.modelToEntity(pedidoModel.getVendedorSolicita()),				
				productoConverter.modelToEntity(pedidoModel.getProducto()), 
				pedidoModel.getCantidad(),
				pedidoModel.getIdVenta()
				);
	}
	
	/***********************************************************************************************/
	
	public PedidoModel entityToModelConDespachanteConId(Pedido pedido) {
		return new PedidoModel(
				pedido.getIdPedido(),
				sucursalConverter.entityToModel(pedido.getSucOrigen()),
				sucursalConverter.entityToModel(pedido.getSucDestino()),
				vendedorConverter.entityToModel(pedido.getVendedorSolicita()),	
				vendedorConverter.entityToModel(pedido.getVendedorDespacha()),
				productoConverter.entityToModel(pedido.getProducto()), 
				pedido.getCantidad(),
				pedido.getIdVenta());
	}
	
	
	public Pedido modelToEntityConDespachanteConIdVenta(PedidoModel pedidoModel) {
		return new Pedido(
				pedidoModel.getIdPedido(),
				sucursalConverter.modelToEntity(pedidoModel.getSucOrigen()),
				sucursalConverter.modelToEntity(pedidoModel.getSucDestino()),
				vendedorConverter.modelToEntity(pedidoModel.getVendedorSolicita()),	
				vendedorConverter.modelToEntity(pedidoModel.getVendedorDespacha()),
				productoConverter.modelToEntity(pedidoModel.getProducto()), 
				pedidoModel.getCantidad(),
				pedidoModel.getIdVenta()
				);
	}
	
}
