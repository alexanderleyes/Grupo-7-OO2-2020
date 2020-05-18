package com.unla.Grupo7OO22020.services;

import java.util.List;
import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.models.LoteModel;

public interface ILoteService {
	
	public List<Lote> getAll();
	
	public LoteModel findById(long id);	
	
	public LoteModel insertOrUpdate(LoteModel loteModel);
	
	public boolean remove(long id);
	

}
