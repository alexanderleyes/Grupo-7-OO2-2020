package com.unla.Grupo7OO22020.models;

import java.time.LocalDate;

public class ClienteModel extends PersonaModel{
	private long idCliente;

	
	public ClienteModel() {}
	
	public ClienteModel(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni, /*H*/long idCliente) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni);
		this.idCliente = idCliente;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "ClienteModel [idCliente=" + idCliente + ", idPersona=" + getIdPersona() + ", nombre=" + getNombre()
				+ ", apellido=" + getApellido() + ", fechaNacimiento=" + getFechaNacimiento() + ", dni=" + getDni() + "]";
	}

	
	
	

}
