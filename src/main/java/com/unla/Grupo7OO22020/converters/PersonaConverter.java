package com.unla.Grupo7OO22020.converters;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Persona;
import com.unla.Grupo7OO22020.models.PersonaModel;


@Component("personaConverter")
public class PersonaConverter {
	
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;
	
	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(persona.getIdPersona(),
				persona.getNombre(),
				persona.getApellido(),
				persona.getFechaNacimiento(),
				persona.getDni());
	}
	
	public Persona modelToEntity(PersonaModel personaModel) {
		return new Persona(personaModel.getIdPersona(),
				personaModel.getNombre(),
				personaModel.getApellido(),
				personaModel.getFechaNacimiento(),
				personaModel.getDni());
	}
}
