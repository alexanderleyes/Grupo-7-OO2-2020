package com.unla.Grupo7OO22020.entities;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="empleado")
@PrimaryKeyJoinColumn(name = "idEmpleado")
public class Empleado extends Persona {
		

	@Column(name="usuario")
	private String usuario;	

	@Column(name="password")
	private String password;

	@Column(name="horaIngreso")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime horaIngreso;

	@Column(name="horasXjornada")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime horasXjornada;
	
	@Column(name="plusSueldo")
	private double plusSueldo;
	
	@Column(name="baja")
	private boolean baja;
	
	public Empleado() {};
	
	
	public Empleado(/*H*/long idPersona, String nombre, String apellido, LocalDate fechaNacimiento,	 int dni, /*H*/ String usuario, String password, LocalTime horaIngreso, LocalTime horasXjornada,
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

	public LocalTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalTime getHorasXjornada() {
		return horasXjornada;
	}

	public void setHorasXjornada(LocalTime horasXjornada) {
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
