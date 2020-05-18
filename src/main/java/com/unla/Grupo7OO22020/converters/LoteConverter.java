package com.unla.Grupo7OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.models.LoteModel;

@Component("loteConverter")
public class LoteConverter {
	
	public LoteModel entityToModel(Lote lote) {
		return new LoteModel(
				lote.getIdLote(),
				lote.getCantidad(),
				lote.getIdProducto());
	}
	
	public Lote ModelToEntity(LoteModel loteModel) {
		return new Lote(
				loteModel.getIdLote(),
				loteModel.getCantidad(),
				loteModel.getIdProducto());
		
	}
}
