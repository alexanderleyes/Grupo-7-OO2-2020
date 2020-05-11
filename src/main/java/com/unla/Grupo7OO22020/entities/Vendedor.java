package com.unla.Grupo7OO22020.entities;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="vendedor")
@PrimaryKeyJoinColumn(name = "idVendedor")
public class Vendedor extends Empleado {	
		
	public Vendedor(){}	
	
	public Vendedor(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni,  String usuario, String password, LocalTime horaIngreso, LocalTime horasXjornada,
			double plusSueldo, boolean baja) {
		super(idPersona, nombre, apellido, fechaNacimiento,	dni, usuario, password, horaIngreso, horasXjornada,	plusSueldo, baja);		
		
	}

	

	@Override
	public String toString() {
		return "Vendedor [, idVendedor=" + idPersona + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + "]";
	}

	
	
	

}
