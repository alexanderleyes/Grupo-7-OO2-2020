package com.unla.Grupo7OO22020.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public long idPedido;	
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Sucursal sucOrigen;	

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Sucursal sucDestino;	
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Vendedor vendedorSolicita;	

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Vendedor vendedorDespacha;	
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Producto producto;	
		
	@Column(name="cantidad")
	private double cantidad;
	

	public Pedido() {
		
	}
	
	public Pedido(long idPedido, Sucursal sucOrigen, Sucursal sucDestino, Vendedor vendedorSolicita,
			Vendedor vendedorDespacha, Producto producto, double cantidad) {
		super();
		this.idPedido = idPedido;
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;
		this.vendedorDespacha = vendedorDespacha;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public Sucursal getSucOrigen() {
		return sucOrigen;
	}

	public void setSucOrigen(Sucursal sucOrigen) {
		this.sucOrigen = sucOrigen;
	}

	public Sucursal getSucDestino() {
		return sucDestino;
	}

	public void setSucDestino(Sucursal sucDestino) {
		this.sucDestino = sucDestino;
	}

	public Vendedor getVendedorSolicita() {
		return vendedorSolicita;
	}

	public void setVendedorSolicita(Vendedor vendedorSolicita) {
		this.vendedorSolicita = vendedorSolicita;
	}

	public Vendedor getVendedorDespacha() {
		return vendedorDespacha;
	}

	public void setVendedorDespacha(Vendedor vendedorDespacha) {
		this.vendedorDespacha = vendedorDespacha;
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

	}
