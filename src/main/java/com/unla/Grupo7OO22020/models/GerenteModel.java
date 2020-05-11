package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;

public class GerenteModel extends EmpleadoModel {

	private long idGerente;
	private String fechaAscenso;
	
	public GerenteModel() {}
	
	
	public GerenteModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, LocalTime horaIngreso,
			LocalTime horasXjornada, double plusSueldolong, long idGerente, String fechaAscenso) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, idEmpleado, usuario, password, horaIngreso, horasXjornada,  plusSueldolong);
		
		this.idGerente = idGerente;
		this.fechaAscenso = fechaAscenso;
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
	
	
	
}
