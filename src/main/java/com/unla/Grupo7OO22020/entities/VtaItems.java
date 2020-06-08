package com.unla.Grupo7OO22020.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VtaItems {
	
	@Id
	private long id;
	private String ids;
	private String cnt;
	private String sux;
	
	
	public VtaItems() {	super();}	
	
	

	public VtaItems(long id, String ids, String cnt, String sux) {
		super();
		this.id = id;
		this.ids = ids;
		this.cnt = cnt;
		this.sux = sux;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}



	public String getCnt() {
		return cnt;
	}



	public void setCnt(String cnt) {
		this.cnt = cnt;
	}



	public String getSux() {
		return sux;
	}



	public void setSux(String sux) {
		this.sux = sux;
	}



	@Override
	public String toString() {
		return "VtaItems [id=" + id + ", ids=" + ids + ", cnt=" + cnt + ", sux=" + sux + "]";
	}

	public List<Long> getListaIndices(){
		String text = this.getIds();
		List<Long> prodIndices = new ArrayList<Long>();
		text.replace(" ", "");
		int largo = text.length();
		String valor = "";
		for (int i=1; i<largo; i++) {
			char ch =text.charAt(i);
			if(ch != '_') {
				valor = valor + ch;				
			}else {
				prodIndices.add(Long.parseLong(valor.trim()));
				valor = "";
			}			
		}
		
		prodIndices.add(Long.parseLong(valor.trim()));		
		return prodIndices;	
	}
	
	public List<Long> getListaCantidad(){
		String text = this.getCnt();
		List<Long> prodCantidades = new ArrayList<Long>();
		text.replace(" ", "");
		int largo = text.length();
		String valor = "";
		for (int i=1; i<largo; i++) {
			char ch =text.charAt(i);
			if(ch != '_') {
				valor = valor + ch;				
			}else {
				prodCantidades.add(Long.parseLong(valor.trim()));
				valor = "";
			}			
		}
		
		prodCantidades.add(Long.parseLong(valor.trim()));		
		return prodCantidades;		
	}
	
	
	public List<Long> getListaSucusales(){
		String text = this.getSux();
		List<Long> sucursalex = new ArrayList<Long>();
		text.replace(" ", "");
		int largo = text.length();
		String valor = "";
		for (int i=1; i<largo; i++) {
			char ch =text.charAt(i);
			if(ch != '_') {
				valor = valor + ch;				
			}else {
				sucursalex.add(Long.parseLong(valor.trim()));
				valor = "";
			}			
		}
		
		sucursalex.add(Long.parseLong(valor.trim()));		
		return sucursalex;		
	}
	
	
	
}

