package com.unla.Grupo7OO22020.models;

public class ProductoModel{
	
	private long idProducto;	
	private String descripcion;	
	private double precioUnitario;
	
	

	public ProductoModel() {
	}

	public ProductoModel(long idProducto, String descripcion, double precioUnitario) {
		super();
		this.setIdProducto(idProducto);
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
	
	

}
