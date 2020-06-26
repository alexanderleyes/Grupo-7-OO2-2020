package com.unla.Grupo7OO22020.services;

import java.time.LocalDate;
import java.util.List;

import com.unla.Grupo7OO22020.entities.HistoricoComisiones;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.HistoricoComisionesModel;
import com.unla.Grupo7OO22020.models.VendedorModel;

public interface IHistoricoComisionesService {
	public List<HistoricoComisiones> getAll();	
	public HistoricoComisiones insertOrUpdate(HistoricoComisiones historicoComisiones);
	public boolean remove(long idHistoricoComisiones);	
	public HistoricoComisionesModel findByIdHistorico(long idHistoricoComisiones);
	public List<HistoricoComisiones> findByFecha(LocalDate fecha);	
	public List<HistoricoComisiones> findByFechaAndSucursal(LocalDate fecha, Sucursal sucursal);	
}

