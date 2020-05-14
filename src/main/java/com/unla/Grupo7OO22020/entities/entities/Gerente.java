package com.unla.Grupo7OO22020.entities;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="gerente")
@PrimaryKeyJoinColumn(name = "idGerente")
public class Gerente extends Empleado {	
			
	@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "idSucursal", nullable = true)
	private Sucursal sucursal;
	
	public Gerente(){}	
	
	public Gerente(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni,  String usuario, String password, LocalTime horaIngreso, LocalTime horasXjornada,
			double plusSueldo, boolean baja) {
		super(idPersona, nombre, apellido, fechaNacimiento,	dni, usuario, password, horaIngreso, horasXjornada,	plusSueldo, baja);			
	}	
	
	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public String toString() {
		return "Gerente [idPersona=" + idPersona + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + "]";
	}

	
	
	

}
