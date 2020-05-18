package com.unla.Grupo7OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Empleado;
import com.unla.Grupo7OO22020.models.EmpleadoModel;

@Component("empleadoConverter")
public class EmpleadoConverter {
	
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(empleado.getIdPersona(), empleado.getNombre(), empleado.getApellido(), empleado.getFechaNacimiento(), empleado.getDni(), empleado.getIdPersona(), empleado.getUsuario(), empleado.getPassword(), empleado.getHoraIngreso(), empleado.getHorasXjornada(), empleado.getPlusSueldo());
	}
	
	public Empleado modelToEntity(EmpleadoModel empleadoModel) {
		return new Empleado(empleadoModel.getIdPersona(), empleadoModel.getNombre(), empleadoModel.getApellido(), empleadoModel.getFechaNacimiento(), empleadoModel.getDni(), /**/ empleadoModel.getUsuario(), empleadoModel.getPassword(), empleadoModel.getHoraIngreso(), empleadoModel.getHorasXjornada(), empleadoModel.getPlusSueldo(), empleadoModel.isBaja());
	}
}
