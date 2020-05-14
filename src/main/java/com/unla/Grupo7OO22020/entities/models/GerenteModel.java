package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;

import com.unla.Grupo7OO22020.entities.Sucursal;

public class GerenteModel extends EmpleadoModel {

	private long idGerente;
	private String fechaAscenso;
	private SucursalModel sucursal;
	
	public GerenteModel() {}
	
	
	public GerenteModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, String usuario, 
			String password, LocalTime horaIngreso,	LocalTime horasXjornada, double plusSueldolong, boolean baja) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, usuario, password, horaIngreso, horasXjornada, plusSueldolong, baja);
		
		this.idGerente = idGerente;		
	}	
		
	public long getIdGerente() {
		return idGerente;
	}
	public void setIdGerente(long idGerente) {
		this.idGerente = idGerente;
	}
	public String getFechaAscenso() {
		return fechaAscenso;
	}
	public void setFechaAscenso(String fechaAscenso) {
		this.fechaAscenso = fechaAscenso;
	}

	public SucursalModel getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalModel sucursal) {
		this.sucursal = sucursal;
	}	
	
}
