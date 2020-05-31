package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;



@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository<Lote, Serializable>{
	
	
	public Lote findByIdLote(long id);	
	
	
	@Query("SELECT l FROM Lote l WHERE l.sucursal = (:sucursal) and l.disponible = 0")
	public abstract Set<Lote> findAllBySucursal(@Param("sucursal") Sucursal sucursal );
	
	//public Set<Lote> findBySucursalId(long id);

}
