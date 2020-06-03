package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.models.ProductoModel;




@Repository("sucursalRepository")
public interface ISucursalRepository extends JpaRepository<Sucursal, Serializable>{	
	public List<Sucursal> findAll();
	
	@Query("SELECT s FROM Sucursal s JOIN FETCH s.lotes l WHERE l.producto = (:producto) and l.cantidad >= (:cantidad)")
	public List<Sucursal>  findByProdcuto(Producto producto, int cantidad);
	
	@Query("SELECT s FROM Sucursal s JOIN FETCH s.lotes l WHERE l.producto = (:producto)")
	public List<Sucursal>  findByProdcuto(Producto producto);
	
	@Query("SELECT s FROM Sucursal  s WHERE s <> (:sucursal)")
	public List<Sucursal>  findAllExcept(Sucursal sucursal);
	
	public Sucursal findByIdSucursal(long id);

	public Sucursal findByGerente(Gerente gerente);
}
