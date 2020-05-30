package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;

@Repository("pedidoRepository")
public abstract interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {
	
	public Pedido findByIdPedido(long id);
	
	
	@Query("SELECT p FROM Pedido p WHERE p.sucDestino=(:sucursal)")
	public abstract List<Pedido> findAllBySucursalDes(@Param("sucursal") Sucursal sucursal );
	
	@Query("SELECT p FROM Pedido p WHERE p.sucOrigen=(:sucursal)")
	public abstract List<Pedido> findAllBySucursalOri(@Param("sucursal") Sucursal sucursal );
	
	@Query("SELECT p FROM Pedido p WHERE p.sucOrigen=(:sucursal) and p.vendedorSolicita <> (:vendedor)")
	public abstract List<Pedido> findAllBySucursalExceptVendedor(@Param("sucursal") Sucursal sucursal, @Param("vendedor") Vendedor vendedor );
	
	@Query("SELECT p FROM Pedido p WHERE  p.vendedorSolicita = (:vendedor)")
	public abstract List<Pedido> findAllByVendedor(@Param("vendedor") Vendedor vendedor );
	
}
