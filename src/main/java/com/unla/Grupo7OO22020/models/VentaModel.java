package com.unla.Grupo7OO22020.models;

import java.util.HashSet;
import java.util.Set;

public class VentaModel{
	
	private long idVenta;	
	private SucursalModel sucursal;	
	private VendedorModel vendedor;
	private PersonaModel cliente;
	private EstadoVentaModel estado;
	private Set<ItemModel> items = new HashSet<ItemModel>();

	public VentaModel() {
	}
	
	public VentaModel(long idVenta, SucursalModel sucursal, VendedorModel vendedor, PersonaModel cliente,
			EstadoVentaModel estado) {
		super();
		this.setIdVenta(idVenta);
		this.sucursal = sucursal;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.estado = estado;
	}

	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public SucursalModel getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalModel sucursal) {
		this.sucursal = sucursal;
	}

	public VendedorModel getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorModel vendedor) {
		this.vendedor = vendedor;
	}

	public PersonaModel getCliente() {
		return cliente;
	}

	public void setCliente(PersonaModel cliente) {
		this.cliente = cliente;
	}

	public EstadoVentaModel getEstadoVenta() {
		return estado;
	}

	public void setEstadoVenta(EstadoVentaModel estado) {
		this.estado = estado;
	}

	public Set<ItemModel> getItems() {
		return items;
	}

	public void setItems(Set<ItemModel> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "VentaModel [idVenta=" + idVenta + ", sucursal=" + sucursal + ", vendedor=" + vendedor + ", cliente="
				+ cliente + ", estadoVenta=" + estado + "]";
	}

}