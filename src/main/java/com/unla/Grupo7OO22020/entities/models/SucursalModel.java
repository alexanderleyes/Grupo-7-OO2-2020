package com.unla.Grupo7OO22020.models;



public class SucursalModel {	
	
	private long idSucursal;
	//private GerenteModel gerente; 
	private long idGerente;
	private String telefono; 
	private String localidad;
	private String direccion; 
	private float latitud; 
	private float longitud;
	
	public SucursalModel() {}

	public SucursalModel(long idSucursal, long idGerente, String telefono, String localidad, String direccion, 
			float latitud, float longitud) {
		super();
		this.idSucursal = idSucursal;		
		this.telefono = telefono;
		this.localidad = localidad;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.idGerente = idGerente;
	}

	public long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

//	public GerenteModel getGerenteModel() {
//		return gerente;
//	}
//
//	public void setGerenteModel(GerenteModel gerente) {
//		this.gerente = gerente;
//	}

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
	
	
	public long getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(long idGerente) {
		this.idGerente = idGerente;
	}

	@Override
	public String toString() {
		return "SucursalModel [idSucursal=" + idSucursal + ", telefono=" + telefono
				+ ", localidad=" + localidad + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	};
	
	
	
	
	

}
