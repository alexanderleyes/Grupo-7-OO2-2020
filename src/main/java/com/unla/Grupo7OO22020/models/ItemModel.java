package com.unla.Grupo7OO22020.models;

public class ItemModel {
	
	private long idItem;	
	private ProductoModel producto;	
	private double cantidad;
	private VentaModel venta;

	public ItemModel() {}	

	public ItemModel(long idItem, ProductoModel producto, double cantidad , VentaModel venta) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
		this.venta = venta;
	}

	public ItemModel(ProductoModel producto, double cantidad, VentaModel venta) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.venta = venta;
	}
	
	public ItemModel(ProductoModel producto, double cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
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

	public VentaModel getVenta() {
		return venta;
	}

	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}
	
	

	@Override
	public String toString() {
		return "ItemModel [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + ", venta=" + venta
				+ "]";
	}

	
}