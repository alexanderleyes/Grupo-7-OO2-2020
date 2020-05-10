package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="gerente")
@PrimaryKeyJoinColumn(name = "idGerente")
public class Gerente extends Empleado {	
	
	@Column(name="fechaAscenso")
	private LocalDate fechaAscenso;
	
	public Gerente(){}

	public Gerente(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento,	 int dni, long idEmpleado, String usuario, String password, LocalTime horaIngreso, LocalTime horasXjornada,
			double plusSueldo, boolean baja,/*H*/ LocalDate fechaAscenso) {
		super(idPersona, nombre, apellido, fechaNacimiento,	dni, idEmpleado, usuario, password, horaIngreso, horasXjornada,	plusSueldo, baja);		
		this.fechaAscenso = fechaAscenso;
	}

	public LocalDate getFechaAscenso() {
		return fechaAscenso;
	}

	public void setFechaAscenso(LocalDate fechaAscenso) {
		this.fechaAscenso = fechaAscenso;
	}

	@Override
	public String toString() {
		return "Gerente [fechaAscenso=" + fechaAscenso + ", idPersona=" + idPersona + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + "]";
	}

	
	
	

}