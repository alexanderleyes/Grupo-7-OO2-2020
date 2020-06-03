package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.ProductoConverter;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Ranking;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.repositories.IProductoRepository;
import com.unla.Grupo7OO22020.repositories.IRankingRepository;
import com.unla.Grupo7OO22020.repositories.ISucursalRepository;
import com.unla.Grupo7OO22020.services.IProductoService;
import com.unla.Grupo7OO22020.services.IRankingService;

@Service("rankingService")
public class RankingService implements IRankingService{
	
	@Autowired
	@Qualifier("rankingRepository")
	private IRankingRepository rankingRepository;
	
	@Autowired
	@Qualifier("sucursalRepository")
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<Ranking> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(String nombreProd, int cantidad) {
		Ranking r = new Ranking(nombreProd,cantidad);
		 rankingRepository.save(r);
		
	}

	@Override
	public boolean remove(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ranking> ranking() {
		List<Ranking> ranking = rankingRepository.ranking();
		return ranking;
	}

}
