package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;



@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long idPersona;
	
	
	@Column(name="nombre")
	public String nombre;
	

	@Column(name="apellido")	
	public String apellido;
	
	@Column(name="fechaNacimiento")
	public LocalDate fechaNacimiento;
	
	@Column(name="dni")
	public int dni;
	
	public Persona(){}
	
	public Persona(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}
	
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento, int dni) {
		super();		
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

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimientoM=" + fechaNacimiento + ", dni=" + dni + "]";
	}
}
