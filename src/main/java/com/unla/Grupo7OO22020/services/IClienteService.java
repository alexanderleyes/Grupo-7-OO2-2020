package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Cliente;
import com.unla.Grupo7OO22020.models.ClienteModel;

public interface IClienteService {
	public List<Cliente> getAll();	
	public ClienteModel insertOrUpdate(ClienteModel clienteModel);
	public boolean remove(long idCliente);
	public ClienteModel findByDni(int dni);
	public Object findByIdCliente(long idCliente);
	
}
