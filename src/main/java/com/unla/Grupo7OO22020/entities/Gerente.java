package com.unla.Grupo7OO22020.entities;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="gerente")
@PrimaryKeyJoinColumn(name = "idGerente")
public class Gerente extends Empleado {	
	
	
	private LocalDate fechaAscenso;
	
	public Gerente(){}	
	
	public Gerente(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni,  String usuario, String password, String horaIngreso, String horasXjornada,
			double plusSueldo, boolean baja,/*H*/ LocalDate fechaAscenso) {
		super(idPersona, nombre, apellido, fechaNacimiento,	dni, usuario, password, horaIngreso, horasXjornada,	plusSueldo, baja);		
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
		return "Gerente [fechaAscenso=" + fechaAscenso + ", idPersona=" + getIdPersona() + ", nombre=" + getNombre()
				+ ", apellido=" + getApellido() + ", fechaNacimiento=" + getFechaNacimiento() + ", dni=" + getDni() + "]";
	}

	
	
	

}
