package com.unla.Grupo7OO22020.converters;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.models.GerenteModel;

@Component("gerenteConverter")
public class GerenteConverter {
	
	public GerenteModel entityToModel(Gerente gerente) {
		return new GerenteModel(gerente.getIdPersona(),  gerente.getNombre(), gerente.getApellido(), gerente.getFechaNacimiento(), gerente.getDni(), gerente.getIdPersona(), gerente.getUsuario(), gerente.getPassword(), gerente.getHoraIngreso(),
				gerente.getHorasXjornada(), gerente.getPlusSueldo(), gerente.getIdPersona(), gerente.getFechaAscenso());
	}
	
	public Gerente modelToEntity(GerenteModel gerenteModel) {
		return new Gerente(gerenteModel.getIdPersona(),gerenteModel.getNombre(), gerenteModel.getApellido(), gerenteModel.getFechaNacimiento(), gerenteModel.getDni(),  gerenteModel.getUsuario(), 
				gerenteModel.getPassword(), gerenteModel.getHoraIngreso(), gerenteModel.getHorasXjornada(), gerenteModel.getPlusSueldo(), gerenteModel.isBaja(),/*H*/ gerenteModel.getFechaAscenso());
	}
}
