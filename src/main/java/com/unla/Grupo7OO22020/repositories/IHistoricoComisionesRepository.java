package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.HistoricoComisiones;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.VendedorModel;


@Repository("historicoComisionesRepository")
public interface IHistoricoComisionesRepository extends JpaRepository<HistoricoComisiones, Serializable>{
	

	public HistoricoComisiones findByIdHistorico(long idHistorico);

	public boolean deleteByIdHistorico(long idHistorico);

	public List<HistoricoComisiones> findByFecha(LocalDate fecha);
	
	@Query("SELECT h FROM HistoricoComisiones h  WHERE h.fecha = (:fecha) and h.sucursal = (:sucursal)")
	public List<HistoricoComisiones> findByFechaAndSucursal(LocalDate fecha, Sucursal sucursal);
	

	
}
