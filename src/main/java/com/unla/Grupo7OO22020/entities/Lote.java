package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name="lote")
public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long idLote;
	
	@Column(name="cantidad")
	private int cantidad;
	
	
	@Column(name="fechaIngreso")
	@CreationTimestamp
	private LocalDate fechaIngreso;
	
	private long idProducto;
	
	@ManyToOne
	@JoinColumn(name="producto")
	private Producto producto;
	


	public Lote() {		
	}

		

	public Lote(long idLote, int cantidad, long idProducto) {
		super();
		this.idLote = idLote;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		
	}


	public Lote(int cantidad) {
		super();
		this.cantidad = cantidad;
	}


	public long getIdLote() {
		return idLote;
	}


	public void setIdLote(long idLote) {
		this.idLote = idLote;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public long getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}








	
	


	

	


}



	



	



	
	
	
	
	


