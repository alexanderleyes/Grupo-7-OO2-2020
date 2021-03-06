package com.unla.Grupo7OO22020.models;



public class SucursalModel extends EmpleadoModel {

	private long idSucursal;
	private long telefono;
	private String localidad;
	private String direccion;
	private double latitud;
	private double longitud;
	private GerenteModel gerente;
	
	
	
	
	public SucursalModel() {}	
	
	
	
	
	
	public SucursalModel(long idSucursal, long telefono, String localidad, String direccion, double latitud,
			double longitud, GerenteModel gerente) {
		super();
		this.idSucursal = idSucursal;
		this.telefono = telefono;
		this.localidad = localidad;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.gerente  = gerente;
		
	}
	
	
	
	public SucursalModel(long telefono, String localidad, String direccion, double latitud,
			double longitud,  GerenteModel gerente) {
		super();
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

	public GerenteModel getGerente() {
		return gerente;
	}


	public void setGerente(GerenteModel gerente) {
		this.gerente = gerente;
	}





	@Override
	public String toString() {
		return "SucursalModel [idSucursal=" + idSucursal + ", telefono=" + telefono + ", localidad=" + localidad + ", direccion="
				+ direccion + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}	
	
	
		
}
