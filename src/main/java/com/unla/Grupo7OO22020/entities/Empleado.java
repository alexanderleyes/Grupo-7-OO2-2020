package com.unla.Grupo7OO22020.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmpleado;
	
	@Column(name="usuario")
	private String usuario;	

	@Column(name="password")
	private String password;

	@Column(name="horaIngreso")
	private LocalTime horaIngreso;

	@Column(name="horasXjornada")
	private LocalTime horasXjornada;
	
	@Column(name="plusSueldo")
	private double plusSueldo;
	
	public Empleado() {};
	
	public Empleado(long idEmpleado, String usuario, String password, LocalTime horaIngreso, LocalTime horasXjornada,
			double plusSueldo) {
		super();
		this.idEmpleado = idEmpleado;
		this.usuario = usuario;
		this.password = password;
		this.horaIngreso = horaIngreso;
		this.horasXjornada = horasXjornada;
		this.plusSueldo = plusSueldo;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
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
		

}
