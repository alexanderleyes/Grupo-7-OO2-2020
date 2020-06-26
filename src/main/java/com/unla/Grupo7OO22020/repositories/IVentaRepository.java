package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.SucursalModel;

@Repository("ventaRepository")
public interface IVentaRepository extends JpaRepository<Venta, Serializable>{	
	public List<Venta> findAll();
	
	//@Query("SELECT s FROM Venta v JOIN FETCH v.items i WHERE i.producto = (:producto) and i.cantidad >= (:cantidad)")
	//public List<Venta> findByProducto(Producto producto, int cantidad);
	
	public Venta findByIdVenta(long id);
	
	@Query("SELECT v FROM Venta v WHERE v.sucursal = (:sucursal) and v.fecha BETWEEN (:fechaUno) AND (:fechaDos)")
	public abstract List<Venta> ventasPorSucursalEntreFechas(@Param("sucursal") Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos);
	
	@Query("SELECT v FROM Venta v WHERE v.sucursal = (:sucursal)")
	public abstract List<Venta> ventasPorSucursal(@Param("sucursal") Sucursal sucursal);
	
	@Query("SELECT i FROM Item i WHERE i.venta = (:venta)")
	public List<Item> itemsPorVenta(Venta venta);
	
	@Query("SELECT i FROM Item i JOIN FETCH i.venta v WHERE v.vendedor = (:vendedor) and v.fecha BETWEEN (:fechaUno) AND (:fechaDos)")
	public List<Item> itemsVentasPorVendedorEntreFechas(@Param("vendedor") Vendedor vendedor, LocalDate fechaUno, LocalDate fechaDos);	
	
	@Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN (:fechaUno) AND (:fechaDos) and v.idVenta = (:idVenta)")
	public abstract Venta ventasEntreFechas(long idVenta, LocalDate fechaUno, LocalDate fechaDos);
}
