package com.unla.Grupo7OO22020.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="HistoricoComisiones")
public class HistoricoComisiones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long 	 idHistorico;
	
	private LocalDate fecha;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	private Vendedor vendedor;
	
	private double 	 comision;		
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	private Sucursal sucursal;
	
	public HistoricoComisiones() {}

	
	public HistoricoComisiones(long idHistorico, LocalDate fecha, Vendedor vendedor, double comision,
			Sucursal sucursal) {
		super();
		this.idHistorico = idHistorico;
		this.fecha = fecha;
		this.vendedor = vendedor;
		this.comision = comision;
		this.sucursal = sucursal;
	}
	
	public HistoricoComisiones(LocalDate fecha, Vendedor vendedor, double comision,
			Sucursal sucursal) {
		super();		
		this.fecha = fecha;
		this.vendedor = vendedor;
		this.comision = comision;
		this.sucursal = sucursal;
	}


	public long getIdHistorico() {
		return idHistorico;
	}


	public void setIdHistorico(long idHistorico) {
		this.idHistorico = idHistorico;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}


	public Sucursal getSucursal() {
		return sucursal;
	}


	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}


	@Override
	public String toString() {
		return "HistoricoComisiones [idHistorico=" + idHistorico + ", fecha=" + fecha + ", vendedor=" + vendedor
				+ ", comision=" + comision + ", sucursal=" + sucursal + "]";
	}	
	

	
	
	
	
	
	
	

}
