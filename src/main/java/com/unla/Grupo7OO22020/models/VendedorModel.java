package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;




public class VendedorModel extends EmpleadoModel {

	private long idVendedor;
	private SucursalModel sucursal;
	
	
	public VendedorModel() {}	
	
	
	public VendedorModel(long idPersona, SucursalModel sucursalModel, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, String horaIngreso,
			String horasXjornada, double plusSueldolong, long idVendedor) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, idEmpleado, usuario, password, horaIngreso, horasXjornada,  plusSueldolong);		
		this.idVendedor = idVendedor;
		this.sucursal	= sucursalModel;
	}
		

	public VendedorModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, String horaIngreso,
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


	public SucursalModel getSucursal() {
		return sucursal;
	}


	public void setSucursal(SucursalModel sucursal) {
		this.sucursal = sucursal;
	}


		
	
	
		
	
	
		
}
