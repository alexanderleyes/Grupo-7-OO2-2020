package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Parametro;
import com.unla.Grupo7OO22020.models.ParametroModel;

public interface IParametroService {
	public List<Parametro> getAll();	
	public ParametroModel insertOrUpdate(ParametroModel parametroModel);
	public boolean remove(long idParametro);	
	public ParametroModel findByIdParametro(long idParametro);
	
	
}
