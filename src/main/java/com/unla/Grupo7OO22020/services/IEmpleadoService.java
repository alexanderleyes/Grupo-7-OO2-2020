package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Empleado;
import com.unla.Grupo7OO22020.models.EmpleadoModel;

public interface IEmpleadoService {
	public List<Empleado> getAll();	
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel);
	public boolean remove(long idEmpleado);
	public EmpleadoModel findByUsuario(String Usuario);
	public Object findByIdEmpleado(long idEmpleado);
	
}
