package com.unla.Grupo7OO22020.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.unla.Grupo7OO22020.converters.HistoricoComisionesConverter;
import com.unla.Grupo7OO22020.entities.HistoricoComisiones;
import com.unla.Grupo7OO22020.models.HistoricoComisionesModel;
import com.unla.Grupo7OO22020.repositories.IHistoricoComisionesRepository;
import com.unla.Grupo7OO22020.services.IHistoricoComisionesService;

@Service("historicoComisionesService")
public class HistoricoComisionesService implements  IHistoricoComisionesService{

	@Autowired
	@Qualifier("historicoComisionesRepository")
	private IHistoricoComisionesRepository historicoComisionesRepository;
	
	@Autowired
	@Qualifier("historicoComisionesConverter")
	private HistoricoComisionesConverter historicoComisionesConverter;
	

	
	@Override
	public List<HistoricoComisiones> getAll(){
		return historicoComisionesRepository.findAll();
	}

	@Override
	public HistoricoComisiones insertOrUpdate(HistoricoComisiones historicoComisiones) {
		HistoricoComisiones historicoComisionesAux = historicoComisionesRepository.save(historicoComisiones);
		return historicoComisionesAux;
	}
	
	@Override
	public boolean remove(long idHistorico) {
		try {
			historicoComisionesRepository.deleteByIdHistorico(idHistorico);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}

	@Override
	public HistoricoComisionesModel findByIdHistorico(long idHistorico) {	
		HistoricoComisiones historicoComisiones = null;
		historicoComisiones = historicoComisionesRepository.findByIdHistorico(idHistorico);			
		return historicoComisionesConverter.entityToModel(historicoComisiones);
	}
	
	@Override
	public List<HistoricoComisiones> findByFecha(LocalDate fecha) {	
		List<HistoricoComisiones> historicos = null;
		historicos = historicoComisionesRepository.findByFecha(fecha);			
		return historicos;
	}
	
	

	



	
		
}
