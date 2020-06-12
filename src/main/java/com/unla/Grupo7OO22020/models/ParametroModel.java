package com.unla.Grupo7OO22020.models;

public class ParametroModel {

	private long 	idParametro;	
	private String 	descripcion;
	private String 	valor;
	
	public ParametroModel(){};
	
	public ParametroModel(long idParametro, String descripcion, String valor) {
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
		return "ParametroModel [idParametro=" + idParametro + ", descripcion=" + descripcion
				+ ", valor=" + valor + "]";
	}

	
	
}
