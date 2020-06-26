package com.unla.Grupo7OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.HistoricoComisiones;
import com.unla.Grupo7OO22020.models.HistoricoComisionesModel;

@Component("historicoComisionesConverter")
public class HistoricoComisionesConverter {
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	public HistoricoComisionesModel entityToModel(HistoricoComisiones historico) {
		return new HistoricoComisionesModel(
				historico.getIdHistorico(),				
				historico.getFecha(),
				vendedorConverter.entityToModel(historico.getVendedor()),
				historico.getComision(),
				sucursalConverter.entityToModel(historico.getSucursal()));			
	}
	
	public HistoricoComisiones modelToEntity(HistoricoComisionesModel historico) {
		return new HistoricoComisiones(
				historico.getIdHistorico(),				
				historico.getFecha(),
				vendedorConverter.modelToEntity(historico.getVendedor()),
				historico.getComision(),
				sucursalConverter.modelToEntity(historico.getSucursal()));
	}

}
