package com.unla.Grupo7OO22020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parametro")
public class Parametro {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long 	idParametro; 
	@Column(unique=true)	
	private String 	descripcion;
	private String 	valor;
	
	public Parametro(){};
	
	public Parametro(long idParametro, String descripcion, String valor) {
		super();
		this.idParametro = idParametro;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public long getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(long idParametro) {
		this.idParametro = idParametro;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Parametro [idParametro=" + idParametro + ", descripcion=" + descripcion
				+ ", valor=" + valor + "]";
	}

	
	
	
	
	
}
