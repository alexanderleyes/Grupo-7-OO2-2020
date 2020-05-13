package com.unla.Grupo7OO22020.models;


public class LocalModel extends EmpleadoModel {

	private long idLocal;
	private long telefono;
	private String localidad;
	private String direccion;
	private double latitud;
	private double longitud;
	
	public LocalModel() {}	
	
	public LocalModel(long idLocal, long telefono, String localidad, String direccion, double latitud, double longitud) {
		super();
		this.idLocal = idLocal;
		this.telefono = telefono;
		this.localidad = localidad;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
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


	@Override
	public String toString() {
		return "LocalModel [idLocal=" + idLocal + ", telefono=" + telefono + ", localidad=" + localidad + ", direccion="
				+ direccion + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}	
	
	
		
}
