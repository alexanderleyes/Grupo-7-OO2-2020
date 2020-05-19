package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.models.PedidoModel;

public interface IPedidoService {

	public PedidoModel findById(long id);

	public List<Pedido> getAll();

	public PedidoModel insertOrUpdate(PedidoModel pedidoModel);

	public boolean remove(long id);

}
