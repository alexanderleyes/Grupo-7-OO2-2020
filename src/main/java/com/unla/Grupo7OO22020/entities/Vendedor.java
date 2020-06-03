package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="vendedor")
@PrimaryKeyJoinColumn(name = "idVendedor")
public class Vendedor extends Empleado {	
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Sucursal sucursal;
	
	public Vendedor(){}	
	
	
	public Vendedor(Sucursal sucursal, /**/ long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni,  String usuario, String password, String horaIngreso, String horasXjornada,
			double plusSueldo, boolean baja) {		
		super(idPersona, nombre, apellido, fechaNacimiento,	dni, usuario, password, horaIngreso, horasXjornada,	plusSueldo, baja);	
		
		this.setSucursal(sucursal);
		
	}
		
	public Vendedor(  long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni,  String usuario, String password, String horaIngreso, String horasXjornada,
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
		return "Vendedor [, idVendedor=" + getIdPersona() + ", nombre=" + getNombre()
				+ ", apellido=" + getApellido() + ", fechaNacimiento=" + getFechaNacimiento() + ", dni=" + getDni() + "]";
	}

	
	
	

}
