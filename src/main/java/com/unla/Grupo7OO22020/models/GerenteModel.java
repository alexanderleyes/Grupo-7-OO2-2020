package com.unla.Grupo7OO22020.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import com.unla.Grupo7OO22020.entities.Empleado;

public class GerenteModel extends Empleado {

	private long idGerente;
	private LocalDate fechaAscenso;
	
	public GerenteModel() {}
	
	
	public GerenteModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, LocalTime horaIngreso,
			LocalTime horasXjornada, double plusSueldo, boolean baja,/*H*/long idGerente, LocalDate fechaAscenso) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, idEmpleado, usuario, password, horaIngreso, horasXjornada, plusSueldo, baja);
		
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
