package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Parametro;


@Repository("parametroRepository")
public interface IParametroRepository extends JpaRepository<Parametro, Serializable>{
	

	public Parametro findByIdParametro(long idParametro);
	
	
}
