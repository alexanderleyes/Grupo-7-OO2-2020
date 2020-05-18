package com.unla.Grupo7OO22020.entities;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="empleado")
@PrimaryKeyJoinColumn(name = "idEmpleado")
public class Empleado extends Persona {
		

	
	private String usuario;	


	private String password;


	//@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private String horaIngreso;

	
	//@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private String horasXjornada;	
	
	private double plusSueldo;	

	private boolean baja;
	
	public Empleado() {};
	
	
	public Empleado(/*H*/long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, /*H*/ String usuario, String password, String horaIngreso, String horasXjornada,
			double plusSueldo, boolean baja) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni);
		
		
		this.usuario = usuario;
		this.password = password;
		this.horaIngreso = horaIngreso;
		this.horasXjornada = horasXjornada;
		this.plusSueldo = plusSueldo;
		this.baja		= baja;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getHoraIngreso() {
		return horaIngreso;
	}


	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}


	public String getHorasXjornada() {
		return horasXjornada;
	}


	public void setHorasXjornada(String horasXjornada) {
		this.horasXjornada = horasXjornada;
	}


	public double getPlusSueldo() {
		return plusSueldo;
	}


	public void setPlusSueldo(double plusSueldo) {
		this.plusSueldo = plusSueldo;
	}


	public boolean isBaja() {
		return baja;
	}


	public void setBaja(boolean baja) {
		this.baja = baja;
	}	
	


	
		
	

}
