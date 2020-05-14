package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;

public class PersonaModel {

	
	public long idPersona;
	public String nombre;
	public String apellido;
	public LocalDate fechaNacimiento;
	public int dni;	
	
	
	public PersonaModel() {};
	
	public PersonaModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni) {
		super();
		this.setIdPersona(idPersona);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}
	

	
		
	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimientoM(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Persona [IdPersona=" + this.idPersona + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimientoM=" + fechaNacimiento + ", dni=" + dni + "]";
	}
	
	
	
}
