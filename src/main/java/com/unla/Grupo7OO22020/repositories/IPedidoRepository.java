package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Pedido;

@Repository("pedidoRepository")
public abstract interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {
	
	public Pedido findByIdPedido(long id);

}
