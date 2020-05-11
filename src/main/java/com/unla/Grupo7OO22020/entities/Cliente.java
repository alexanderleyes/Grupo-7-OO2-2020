package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
@PrimaryKeyJoinColumn(name = "idCliente")
public class Cliente extends Persona {
		
	public Cliente(){}	
	
	public Cliente(long idPersona, String nombre, String apellido, LocalDate fechaNacimiento, int dni){
		super(idPersona, nombre, apellido, fechaNacimiento, dni);
		
		
	}	


		
	

}
