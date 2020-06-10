package com.unla.Grupo7OO22020.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@Column(name="idVenta")
	private long idVenta;
	
	@OneToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Item item;

	public Pedido() {
		
	}
	
	public Pedido(long idPedido, Sucursal sucOrigen, Sucursal sucDestino, Vendedor vendedorSolicita,
			Vendedor vendedorDespacha, Producto producto, double cantidad, Item item) {
		super();
		this.idPedido = idPedido;
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;
		this.vendedorDespacha = vendedorDespacha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.item = item;
	}
	
	
	public Pedido(long idPedido, Sucursal sucOrigen, Sucursal sucDestino, Vendedor vendedorSolicita,
			 Producto producto, double cantidad, Item item) {
		super();
		this.idPedido = idPedido;
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;
		this.producto = producto;
		this.cantidad = cantidad;
		this.item = item;
	}

	
	public Pedido(long idPedido, Sucursal sucOrigen, Sucursal sucDestino, Vendedor vendedorSolicita,
			 Producto producto, double cantidad, Item item, long idVenta) {
		super();
		this.idPedido = idPedido;
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;
		this.producto = producto;
		this.cantidad = cantidad;
		this.idVenta = idVenta;
		this.item = item;
	
	}
	
	

	public Pedido(long idPedido, Sucursal sucOrigen, Sucursal sucDestino, Vendedor vendedorSolicita,
			Vendedor vendedorDespacha, Producto producto, double cantidad, Item item, long idVenta) {
		super();
		this.idPedido = idPedido;
		this.sucOrigen = sucOrigen;
		this.sucDestino = sucDestino;
		this.vendedorSolicita = vendedorSolicita;
		this.vendedorDespacha = vendedorDespacha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.idVenta = idVenta;
		this.item = item;
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

	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}	
	
	

	}
