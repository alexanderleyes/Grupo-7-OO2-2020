package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;

public class EmpleadoModel extends PersonaModel{
	
	private long idEmpleado;
	private String usuario;
	private String password;
	private String horaIngreso;
	private String horasXjornada;
	private double plusSueldo;
	private boolean baja;		
	
	public EmpleadoModel() {};
	
	public EmpleadoModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, String horaIngreso,
			String horasXjornada, double plusSueldo) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni);
		
		this.setIdEmpleado(idEmpleado);
		this.usuario 		= usuario;
		this.password 		= password;
		this.horaIngreso 	= horaIngreso; 
		this.horasXjornada 	= horasXjornada;
		this.plusSueldo 	= plusSueldo;
		this.baja			= false;
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

	@Override
	public String toString() {
		return "EmpleadoModel [idEmpleado=" + idEmpleado + ", usuario=" + usuario + ", password=" + password
				+ ", horaIngreso=" + horaIngreso + ", horasXjornada=" + horasXjornada + ", plusSueldo=" + plusSueldo
				+ ", baja=" + baja + "]";
	}

	
	
	
	
}
