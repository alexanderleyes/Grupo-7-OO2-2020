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
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="sucursal")
public class Sucursal {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSucursal;	
	
	private long telefono;
	
	private String localidad;
	
	private String direccion;
	
	private double latitud;
	
	private double longitud;
	
	@OneToOne(fetch=FetchType.EAGER)	
	private Gerente gerente;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sucursal")
	private Set<Lote> lotes = new HashSet<Lote>();

	public Sucursal() {}
	
	

	public Sucursal(long idSucursal, long telefono, String localidad, String direccion, double latitud, double longitud, Gerente gerente) {
		super();
		this.idSucursal = idSucursal;
		this.telefono = telefono;
		this.localidad = localidad;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.gerente  = gerente;
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


	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}



	public Set<Lote> getLotes() {
		return lotes;
	}



	public void setLotes(Set<Lote> lotes) {
		this.lotes = lotes;
	}



	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", telefono=" + telefono + ", localidad=" + localidad
				+ ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + ", gerente="
				+ gerente + ", lotes=" + lotes + "]";
	}

	
	


	
	
	

}
