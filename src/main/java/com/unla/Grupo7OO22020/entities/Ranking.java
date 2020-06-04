package com.unla.Grupo7OO22020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ranking")
public class Ranking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRanking;
	
	@Column(name="nombreProd")
	private String nombreProd;
	
	@Column(name="cantidad")
	private int cantidad;
	
	public Ranking() {
	}

	
	public Ranking(long idRanking, String nombreProd, long cantidad) {
		super();
		this.idRanking = idRanking;
		this.nombreProd = nombreProd;
		this.cantidad = (int) cantidad;
	}


	public Ranking(String nombreProd, int cantidad) {
		super();
		this.nombreProd = nombreProd;
		this.cantidad = cantidad;
	}

	public String getnombreProd() {
		return nombreProd;
	}

	public void setnombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getIdRanking() {
		return idRanking;
	}

	public void setIdRanking(long idRanking) {
		this.idRanking = idRanking;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	@Override
	public String toString() {
		return "Ranking [idRanking=" + idRanking + ", nombreProd=" + nombreProd + ", cantidad=" + cantidad + "]";
	}

	
	
	

}
