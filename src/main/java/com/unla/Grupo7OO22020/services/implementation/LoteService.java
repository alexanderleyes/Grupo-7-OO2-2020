package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.Grupo7OO22020.converters.LoteConverter;
import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.models.LoteModel;
import com.unla.Grupo7OO22020.repositories.ILoteRepository;
import com.unla.Grupo7OO22020.services.ILoteService;




@Service("loteService")

public class LoteService implements ILoteService {
	
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;

	@Override
	public List<Lote> getAll() {
		return loteRepository.findAll();
		
	}


	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) {
	  Lote lote = loteRepository.save(loteConverter.ModelToEntity(loteModel));
	return loteConverter.entityToModel(lote);
		
	}	
	
	
	@Override
	public boolean remove(long id) {
		try {
			loteRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


	@Override
	public LoteModel findById(long id) {
		return loteConverter.entityToModel(loteRepository.findByIdLote(id));
			}



	
	
	
	
	}


