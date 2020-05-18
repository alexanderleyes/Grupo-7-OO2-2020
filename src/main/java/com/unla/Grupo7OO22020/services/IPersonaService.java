package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Persona;
import com.unla.Grupo7OO22020.models.PersonaModel;

public interface IPersonaService {
	public List<Persona> getAll();	
	public PersonaModel findByDni(long dni); 
	public PersonaModel findByIdPersona(long idPersona); 
	public PersonaModel insertOrUpdate(PersonaModel personaModel);
	public boolean remove(long idPersona);

}
