package com.unla.Grupo7OO22020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long idItem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="producto_id", nullable=true)
	private Producto producto;	
	
	@Column(name="cantidad")
	private double cantidad;
	

	@ManyToOne(fetch = FetchType.EAGER)
	private Venta venta;	

	public Item() {		
	}

	public Item(long idItem, Producto producto, double cantidad , Venta venta) {
		super();
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
		this.venta = venta;
		
	}

	public Item(double cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	
	
	
}