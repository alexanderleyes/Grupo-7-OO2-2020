package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Local;
import com.unla.Grupo7OO22020.models.LocalModel;

public interface ILocalService {
	public List<Local> getAll();		
	public LocalModel findByIdLocal(long id);
	public boolean remove(long id);
	public LocalModel insertOrUpdate(LocalModel localModel);	
	
}
