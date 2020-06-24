package com.unla.Grupo7OO22020.models;

public class EstadoVentaModel {
	private long idEstadoVenta;
	private String nombre;
	private String descripcion;
	//private VentaModel venta;
	
	public EstadoVentaModel() {}
	
	public EstadoVentaModel(long idEstadoVenta, String nombre, String descripcion) {
		super();
		this.idEstadoVenta = idEstadoVenta;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}



	public long getIdEstadoVenta() {
		return idEstadoVenta;
	}

	public void setIdEstadoVenta(long idEstadoVenta) {
		this.idEstadoVenta = idEstadoVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoVentaModel [idEstadoVenta=" + idEstadoVenta + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}
	
	

}
