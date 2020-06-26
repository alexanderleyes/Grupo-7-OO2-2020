package com.unla.Grupo7OO22020.models;

import java.time.LocalDate;


public class HistoricoComisionesModel {
	
	private long 	 		idHistorico;
	private LocalDate 		fecha;
	private VendedorModel 	vendedor;
	private double 	 		comision;	
	private SucursalModel	sucursal;
	
	public HistoricoComisionesModel() {}

	
	public HistoricoComisionesModel(long idHistorico, LocalDate fecha, VendedorModel vendedor, double comision,
			SucursalModel sucursal) {
		super();
		this.idHistorico = idHistorico;
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

	public VendedorModel getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorModel vendedor) {
		this.vendedor = vendedor;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public SucursalModel getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalModel sucursal) {
		this.sucursal = sucursal;
	}


	@Override
	public String toString() {
		return "HistoricoComisionesModel [idHistorico=" + idHistorico + ", fecha=" + fecha + ", vendedor=" + vendedor
				+ ", comision=" + comision + ", sucursal=" + sucursal + "]";
	}

	
	


}
