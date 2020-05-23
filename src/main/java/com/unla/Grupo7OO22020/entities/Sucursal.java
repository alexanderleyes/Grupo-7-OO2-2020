package com.unla.Grupo7OO22020.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="sucursal")
public class Sucursal {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSucursal;	
	
	@Column(name="telefono")	
	private long telefono;
	
	@Column(name="localidad")	
	private String localidad;
	
	@Column(name="direccion")	
	private String direccion;
	
	@Column(name="latitud")	
	private double latitud;
	
	@Column(name="longitud")	
	private double longitud;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sucursal")
	private Set<Lote> lotes = new HashSet<Lote>();

	public Sucursal() {}
	
	

	public Sucursal(long idSucursal, long telefono, String localidad, String direccion, double latitud, double longitud) {
		super();
		this.idSucursal = idSucursal;
		this.telefono = telefono;
		this.localidad = localidad;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}



	public Set<Lote> getLotes() {
		return lotes;
	}



	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}

	
	


	
	
	

}
