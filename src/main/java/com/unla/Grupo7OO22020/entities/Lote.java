package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@OneToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Producto producto;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sucursal_id", nullable=false)
	private Sucursal sucursal;
	
	private boolean disponible;


	public Lote() {	}		

	public Lote(long idLote, int cantidad, Producto producto, Sucursal sucursal, boolean disponible) {
		super();
		this.idLote = idLote;
		this.cantidad = cantidad;
		this.producto = producto;
		this.sucursal = sucursal;
		this.disponible= disponible;
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



	public Sucursal getSucursal() {
		return sucursal;
	}



	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	
}