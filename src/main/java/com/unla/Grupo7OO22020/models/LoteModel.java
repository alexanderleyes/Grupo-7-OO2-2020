package com.unla.Grupo7OO22020.models;



import com.unla.Grupo7OO22020.entities.Lote;

public class LoteModel {
	
	private long idLote;	
	private int cantidad;	
	private ProductoModel producto;
	private SucursalModel sucursal;
	private boolean disponible;
	
	
	
	public LoteModel() {}	
	
	public LoteModel(long idLote, int cantidad, ProductoModel producto, SucursalModel sucursal) {
		super();
		this.idLote = idLote;
		this.cantidad = cantidad;
		this.producto = producto;
		this.sucursal = sucursal;
		this.disponible = false;
	}
	
	public LoteModel(int cantidad, ProductoModel producto,SucursalModel sucursal) {
		super();		
		this.cantidad = cantidad;
		this.producto = producto;
		this.sucursal = sucursal;

	}

	public long getIdLote() {
		return idLote;
	}

	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Lote getLote() {
		return null;
	}


	public ProductoModel getProducto() {
		return producto;
	}


	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public SucursalModel getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalModel sucursal) {
		this.sucursal = sucursal;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
}