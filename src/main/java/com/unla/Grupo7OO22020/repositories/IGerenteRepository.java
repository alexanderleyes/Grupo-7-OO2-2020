package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Gerente;


@Repository("gerenteRepository")
public interface IGerenteRepository extends JpaRepository<Gerente, Serializable>{
	
	public Gerente findByApellido(String apellido);
	public Gerente findByDni(int dni);
	public Gerente findByUsuario(String Usuario);
	public List<Gerente> findAll();
	public Gerente findByIdPersona(long id);
	

}
