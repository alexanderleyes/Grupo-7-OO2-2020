package com.unla.Grupo7OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Cliente;
import com.unla.Grupo7OO22020.models.ClienteModel;


@Component("clienteConverter")
public class ClienteConverter {
	
	
	public ClienteModel entityToModel(Cliente cliente) {
		return new ClienteModel(cliente.getIdPersona(), cliente.getNombre(), cliente.getApellido(), cliente.getFechaNacimiento(), cliente.getDni(), /*H*/cliente.getIdPersona());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		return new Cliente(clienteModel.getIdCliente(),  clienteModel.getNombre(),  clienteModel.getApellido(),  clienteModel.getFechaNacimiento(),  clienteModel.getDni());
	}
}
