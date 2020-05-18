package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.entities.Producto;



@Repository("productoRepository")
public abstract interface IProductoRepository extends JpaRepository<Producto, Serializable> {
	
	public  Producto findByIdProducto(long id);
	public  Producto findByDescripcion(String descripcion);

}
