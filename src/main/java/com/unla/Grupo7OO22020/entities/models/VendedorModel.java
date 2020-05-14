package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;

public class VendedorModel extends EmpleadoModel {

	private long idVendedor;
		
	public VendedorModel() {}	
	
	public VendedorModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, String usuario, String password, LocalTime horaIngreso,
			LocalTime horasXjornada, double plusSueldolong, boolean baja) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, usuario, password, horaIngreso, horasXjornada,  plusSueldolong, baja);
		
		this.idVendedor = idVendedor;
		
	}		
	
	public long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}
	
		
}
