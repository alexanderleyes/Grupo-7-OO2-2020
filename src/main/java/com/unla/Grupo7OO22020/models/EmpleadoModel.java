package com.unla.Grupo7OO22020.models;

import java.time.LocalTime;

public class EmpleadoModel {
	
	private long idEmpleado;
	private String usuario;
	private String password;
	private LocalTime horaIngreso;
	private LocalTime horasXjornada;
	private double plusSueldo;
	
	public EmpleadoModel() {}
	
	public EmpleadoModel(long idEmpleado, String usuario, String password, LocalTime horaIngreso,
			LocalTime horasXjornada, double plusSueldo) {
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


	@Override
	public String toString() {
		return "EmpleadoModel [idEmpleado=" + idEmpleado + ", usuario=" + usuario + ", password=" + password
				+ ", plusSueldo=" + plusSueldo + "]";
	}
	
	
	
	
	
}
