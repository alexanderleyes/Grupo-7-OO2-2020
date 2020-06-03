package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.EstadoVentaConverter;
import com.unla.Grupo7OO22020.entities.EstadoVenta;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.repositories.IEstadoVentaRepository;
import com.unla.Grupo7OO22020.services.IEstadoVentaService;

@Service("estadoVentaService")
public class EstadoVentaService implements IEstadoVentaService{

	@Autowired
	@Qualifier("estadoVentaConverter")
	private EstadoVentaConverter estadoVentaConverter;
	
	@Autowired
	@Qualifier("estadoVentaRepository")
	private IEstadoVentaRepository estadoVentaRepository;

	@Override
	public List<EstadoVenta> getAll() {
		return estadoVentaRepository.findAll();
	}

	
	@Override
	public EstadoVentaModel findByIdEstadoVenta(long id) {				
		EstadoVenta estadoVenta = null;
		estadoVenta = estadoVentaRepository.findByIdEstadoVenta(id);
		return estadoVentaConverter.entityToModel(estadoVenta);
	}

	
	@Override
	public boolean remove(long id) {
		try {
			estadoVentaRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}	
		
	}

	@Override
	public EstadoVentaModel insertOrUpdate(EstadoVentaModel estadoVentaModel) {
		EstadoVenta estadoVenta = estadoVentaRepository.save(estadoVentaConverter.modelToEntity(estadoVentaModel));
		return estadoVentaConverter.entityToModel(estadoVenta);
	}
	
}
