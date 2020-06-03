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
	
	
	public VtaItems() {	super();}	
	
	public VtaItems(long id, String ids, String cnt) {
		super();
		this.id = id;
		this.ids = ids;
		this.cnt = cnt;
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

	@Override
	public String toString() {
		return "VtaItems [id=" + id + ", ids=" + ids + ", cnt=" + cnt + "]";
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
	
}

