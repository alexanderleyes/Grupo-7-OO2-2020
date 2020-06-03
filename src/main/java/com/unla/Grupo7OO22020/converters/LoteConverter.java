package com.unla.Grupo7OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.LoteModel;

@Component("loteConverter")
public class LoteConverter {
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	
	public LoteModel entityToModel(Lote lote) {
		return new LoteModel(
				lote.getIdLote(),
				lote.getCantidad(),
				productoConverter.entityToModel(lote.getProducto()),
				sucursalConverter.entityToModel(lote.getSucursal()));		
	}
	
	public Lote ModelToEntity(LoteModel loteModel) {
		return new Lote(
				loteModel.getIdLote(),
				loteModel.getCantidad(),
				productoConverter.modelToEntity(loteModel.getProducto()),
				sucursalConverter.modelToEntity(loteModel.getSucursal()),
				loteModel.isDisponible());		
	}

	
}