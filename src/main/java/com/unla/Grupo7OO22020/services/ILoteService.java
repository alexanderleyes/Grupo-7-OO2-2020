package com.unla.Grupo7OO22020.services;

import java.util.List;
import java.util.Set;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.LoteModel;
import com.unla.Grupo7OO22020.models.SucursalModel;

public interface ILoteService {
	
	public List<Lote> getAll();
	
	public LoteModel findById(long id);	
	
	public LoteModel insertOrUpdate(LoteModel loteModel);
	
	public Lote insertOrUpdate(Lote lote);
	
	public boolean remove(long id);	

	public Set<LoteModel> findAllBySucursal(SucursalModel sucursalModel);
	
	public void deshabilitar (long idLote);
	

}
