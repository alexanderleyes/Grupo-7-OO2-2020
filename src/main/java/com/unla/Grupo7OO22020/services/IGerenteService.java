package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.models.GerenteModel;

public interface IGerenteService {
	public List<Gerente> getAll();	
	public GerenteModel insertOrUpdate(GerenteModel gerenteModel);
	public boolean remove(long idgerente);
	public GerenteModel findByApellido(String Apellido);
	public GerenteModel findByDni(int dni);
	public GerenteModel findByUsuario(String usuario);
}
