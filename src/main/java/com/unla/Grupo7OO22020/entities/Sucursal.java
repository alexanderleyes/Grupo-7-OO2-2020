package com.unla.Grupo7OO22020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="sucursal")
public class Sucursal {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSucursal;
	
	@JoinColumn(name="idGerente" , unique = true)
	@OneToOne()
	private Gerente gerente; //temporario hasta saber como hacer traerlo bien;
	
	@Column(name="telefono")
	private String telefono; 
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="direccion")
	private String direccion; 
	
	@Column(name="latitud")
	private float latitud; 
	
	@Column(name="longitud")
	private float longitud;
	
	public Sucursal() {}

	public Sucursal(long idSucursal, Gerente gerente, String telefono, String localidad, String direccion,
			float latitud, float longitud) {
		super();
		this.idSucursal = idSucursal;
		this.gerente = gerente;
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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
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

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", gerente=" + gerente + ", telefono=" + telefono + ", localidad="
				+ localidad + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	};
	
	
	
	
}
