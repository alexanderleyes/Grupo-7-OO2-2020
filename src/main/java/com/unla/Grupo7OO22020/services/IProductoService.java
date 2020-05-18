package com.unla.Grupo7OO22020.services;

import java.util.List;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.models.ProductoModel;



public interface IProductoService {

	public ProductoModel findById(long id);

	public List<Producto> getAll();

	public ProductoModel insertOrUpdate(ProductoModel productoModel);

	public boolean remove(long id);


	public ProductoModel findByDescripcion(String name);



}
