package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;



public class VendedorModel extends EmpleadoModel {

	private long idVendedor;
	private SucursalModel sucursalModel;
	
	
	public VendedorModel() {}	
	
	
	public VendedorModel(long idPersona, SucursalModel sucursalModel, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, String horaIngreso,
			String horasXjornada, double plusSueldolong, long idVendedor) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, idEmpleado, usuario, password, horaIngreso, horasXjornada,  plusSueldolong);		
		this.idVendedor = idVendedor;		
	}
	
	
	

	public long getIdVendedor() {
		return idVendedor;
	}


	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}


	public SucursalModel getSucursalModel() {
		return sucursalModel;
	}


	public void setSucursalModel(SucursalModel sucursalModel) {
		this.sucursalModel = sucursalModel;
	}		
	
	
		
	
	
		
}
