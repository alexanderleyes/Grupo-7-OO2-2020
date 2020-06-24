package com.unla.Grupo7OO22020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estadoVenta")
public class EstadoVenta {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstadoVenta;	
	
	@Column(name="nombre")	
	private String nombre;
	
	@Column(name="descripcion")	
	private String descripcion;
	

	public EstadoVenta() {}



	public EstadoVenta(long idEstadoVenta, String nombre, String descripcion) {
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
		return "EstadoVenta [idEstadoVenta=" + idEstadoVenta + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
	}

	
	
	

}
