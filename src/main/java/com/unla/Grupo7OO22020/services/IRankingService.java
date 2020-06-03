package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Ranking;
import com.unla.Grupo7OO22020.models.ProductoModel;

public interface IRankingService {
	
	public List<Ranking> getAll();

	
	public boolean remove(long id);
	
	public boolean eliminar(long id);

	void insertOrUpdate(String nombreProd, int cantidad);

	public List<Ranking> ranking();

}
