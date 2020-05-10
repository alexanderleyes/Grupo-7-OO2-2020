package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Persona;


@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable>{
	

	public Persona findByDni(long dni);
	
	public List<Persona> findAll();

	public Persona findByIdPersona(long idPersona);
	
	
}
