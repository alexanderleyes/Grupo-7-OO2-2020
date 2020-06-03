package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.EstadoVenta;


@Repository("estadoVentaRepository")
public interface IEstadoVentaRepository extends JpaRepository<EstadoVenta, Serializable>{	
	public List<EstadoVenta> findAll();
	public EstadoVenta findByIdEstadoVenta(long id);
}
