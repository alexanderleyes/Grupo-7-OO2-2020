package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.ProductoConverter;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.repositories.IProductoRepository;
import com.unla.Grupo7OO22020.services.IProductoService;


@Service("productoService")
public class ProductoService implements IProductoService{
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
		
	}


	@Override
	public ProductoModel insertOrUpdate(ProductoModel productoModel) {
		 Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
		return productoConverter.entityToModel(producto);
		
	}

	@Override
	public boolean remove(long id) {
		try {
			productoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


	

	@Override
	public ProductoModel findByDescripcion(String descripcion) {
		return productoConverter.entityToModel(productoRepository.findByDescripcion(descripcion));
	}


	@Override
	public ProductoModel findByIdProducto(long id) {
		return productoConverter.entityToModel(productoRepository.findByIdProducto(id));	
		
	}

	
	
	
	

}
