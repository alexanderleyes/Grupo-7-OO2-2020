package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class GerenteModel extends EmpleadoModel {

	private long idGerente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAscenso;
	
	public GerenteModel() {}
	
	
	public GerenteModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, String horaIngreso,
			String horasXjornada, double plusSueldolong, long idGerente, LocalDate fechaAscenso) {
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
	public LocalDate getFechaAscenso() {
		return fechaAscenso;
	}
	public void setFechaAscenso(LocalDate fechaAscenso) {
		this.fechaAscenso = fechaAscenso;
	}
	
	
	
}
