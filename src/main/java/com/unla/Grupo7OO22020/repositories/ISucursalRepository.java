package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.ProductoModel;




@Repository("sucursalRepository")
public interface ISucursalRepository extends JpaRepository<Sucursal, Serializable>{	
	public List<Sucursal> findAll();
	
	@Query("SELECT s FROM Sucursal s JOIN FETCH s.lotes l WHERE l.producto = (:producto) and l.cantidad >= (:cantidad)")
	public List<Sucursal>  findByProdcuto(Producto producto, int cantidad);
	
	public Sucursal findByIdSucursal(long id);
}
