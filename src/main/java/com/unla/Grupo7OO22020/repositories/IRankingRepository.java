package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Ranking;
import com.unla.Grupo7OO22020.entities.Sucursal;

@Repository("rankingRepository")
public interface IRankingRepository  extends JpaRepository<Ranking, Serializable>{

	
	@Query("SELECT new com.unla.Grupo7OO22020.entities.Ranking(COUNT(r.idRanking) as idProducto ,r.nombreProd as nombreProd ,SUM(r.cantidad) as cantidad) FROM Ranking r group by r.nombreProd order by SUM(r.cantidad) desc")
	public abstract List<Ranking> ranking();


}
