package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Gerente;
import com.unla.Grupo7OO22020.entities.Sucursal;


@Repository("sucursalRepository")
public interface ISucursalRepository extends JpaRepository<Sucursal, Serializable>{
	

	public Sucursal findByGerente(Gerente Gerente);
	
	public List<Sucursal> findAll();
	
}
