package com.unla.Grupo7OO22020.models;

public class ItemModel {
	
	private long idItem;	
	private ProductoModel producto;	
	private double cantidad;

	public ItemModel() {}	

	public ItemModel(long idItem, ProductoModel producto, double cantidad) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
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

	@Override
	public String toString() {
		return "ItemModel [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
}