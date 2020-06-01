package com.unla.Grupo7OO22020.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="venta")
public class Venta {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenta;	
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Sucursal sucursal;	

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Vendedor vendedor;	
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Persona cliente;	

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private EstadoVenta estado;	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="venta")
	private Set<Item> items = new HashSet<Item>();

	public Venta() {}

	public Venta(long idVenta, Sucursal sucursal, Vendedor vendedor, Persona cliente, EstadoVenta estado) {
		super();
		this.idVenta = idVenta;
		this.sucursal = sucursal;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.estado = estado;
	}

	public long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public EstadoVenta getEstado() {
		return estado;
	}

	public void setEstado(EstadoVenta estado) {
		this.estado = estado;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
