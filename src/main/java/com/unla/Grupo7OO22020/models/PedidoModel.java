package com.unla.Grupo7OO22020.models;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;

public class PedidoModel{
	
	private long idPedido;	
	private SucursalModel sucOrigen;	
	private SucursalModel sucDestino;
	private VendedorModel vendedorSolicita;
	private VendedorModel vendedorDespacha;
	private ProductoModel producto;
	private double cantidad;

	public PedidoModel() {
	}

	public PedidoModel(long idPedido, SucursalModel sucOrigen, SucursalModel sucDestino, VendedorModel vendedorSolicita,
			VendedorModel vendedorDespacha, ProductoModel producto, double cantidad) {
		super();
		this.setIdPedido(idPedido);
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;
		this.vendedorDespacha = vendedorDespacha;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	
	/*Constructor Sin despachante*/
	public PedidoModel(long idPedido, SucursalModel sucOrigen, SucursalModel sucDestino, VendedorModel vendedorSolicita,
			ProductoModel producto, double cantidad) {
		super();
		this.setIdPedido(idPedido);
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;		
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public SucursalModel getSucOrigen() {
		return sucOrigen;
	}

	public void setSucOrigen(SucursalModel sucOrigen) {
		this.sucOrigen = sucOrigen;
	}

	public SucursalModel getSucDestino() {
		return sucDestino;
	}

	public void setSucDestino(SucursalModel sucDestino) {
		this.sucDestino = sucDestino;
	}

	public VendedorModel getVendedorSolicita() {
		return vendedorSolicita;
	}

	public void setVendedorSolicita(VendedorModel vendedorSolicita) {
		this.vendedorSolicita = vendedorSolicita;
	}

	public VendedorModel getVendedorDespacha() {
		return vendedorDespacha;
	}

	public void setVendedorDespacha(VendedorModel vendedorDespacha) {
		this.vendedorDespacha = vendedorDespacha;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "PedidoModel [idPedido=" + idPedido + ", sucOrigen=" + sucOrigen + ", sucDestino=" + sucDestino
				+ ", vendedorSolicita=" + vendedorSolicita + ", vendedorDespacha=" + vendedorDespacha + ", producto="
				+ producto + ", cantidad=" + cantidad + "]";
	}


}
