package com.unla.Grupo7OO22020.models;



import com.unla.Grupo7OO22020.entities.Lote;

public class LoteModel {
	
	private long idLote;
	
	private int cantidad;
	
	private long idProducto;
	
	public LoteModel() {
	}
	
	
		public LoteModel(long idLote, int cantidad, long idProducto) {
		super();
		this.idLote = idLote;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
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
	
	public Lote getLote() {
		return null;
	}


	public long getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}


	


	


	

	
	
	

}
