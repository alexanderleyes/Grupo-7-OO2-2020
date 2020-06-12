package com.unla.Grupo7OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Parametro;
import com.unla.Grupo7OO22020.models.ParametroModel;


@Component("parametroConverter")
public class ParametroConverter {
	
	
	public ParametroModel entityToModel(Parametro parametro) {
		return new ParametroModel(
				parametro.getIdParametro(),				
				parametro.getDescripcion(),
				parametro.getValor());			
	}
	
	public Parametro modelToEntity(ParametroModel parametroModel) {
		return new Parametro(
				parametroModel.getIdParametro(),				
				parametroModel.getDescripcion(),
				parametroModel.getValor());
	}
}
