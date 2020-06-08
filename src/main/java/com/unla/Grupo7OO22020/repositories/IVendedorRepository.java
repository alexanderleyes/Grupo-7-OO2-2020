package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;


@Repository("vendedorRepository")
public interface IVendedorRepository extends JpaRepository<Vendedor, Serializable>{
	
	public Vendedor findByApellido(String apellido);
	public Vendedor findByDni(int dni);
	public Vendedor findByUsuario(String Usuario);
	public List<Vendedor> findAll();
	public Vendedor findByIdPersona(long id);
	
	@Query("SELECT v FROM Vendedor v WHERE v.sucursal = (:sucursal)")
	public List<Vendedor>  findAllBySucursal(Sucursal sucursal);
}
