package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Venta;

@Repository("ventaRepository")
public interface IVentaRepository extends JpaRepository<Venta, Serializable>{	
	public List<Venta> findAll();
	
	@Query("SELECT s FROM Venta v JOIN FETCH v.items i WHERE i.producto = (:producto) and i.cantidad >= (:cantidad)")
	public List<Venta> findByProducto(Producto producto, int cantidad);
	
	public Venta findByIdVenta(long id);
}
