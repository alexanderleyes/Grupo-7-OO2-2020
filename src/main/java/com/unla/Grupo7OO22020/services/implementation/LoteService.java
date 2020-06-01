package com.unla.Grupo7OO22020.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.GerenteConverter;
import com.unla.Grupo7OO22020.converters.LoteConverter;
import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.models.LoteModel;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
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
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;

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
	public Lote insertOrUpdate(Lote lote) {
		Lote lote1 = loteRepository.save(lote);
		return lote1;
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
	public boolean eliminar(long id) {
		if(loteRepository.findById(id).get().getCantidad() == 0)
		{
			return remove(id);
		}else {

			return false;
		}
	}	
	


	@Override
	public LoteModel findById(long id) {
		return loteConverter.entityToModel(loteRepository.findByIdLote(id));
			}


	@Override
	public Set<LoteModel> findAllBySucursal(SucursalModel sucursalModel) {
		
		Set<Lote> lotesEntities = loteRepository.findAllBySucursal(sucursalConverter.modelToEntity(sucursalModel));
		
		Set<LoteModel> lotesModels = new HashSet<LoteModel>();
		
		for (Lote l : lotesEntities) {
			lotesModels.add(loteConverter.entityToModel(l));
	    }		
		return lotesModels;	
	}


	@Override
	public void deshabilitar(long idLote) {
		Lote lote = loteRepository.findByIdLote(idLote);
		
		if(lote.getCantidad() == 0) {
		lote.setDisponible(true);
		loteService.insertOrUpdate(lote);
		}
		
		
	}


	


	
	
	}


