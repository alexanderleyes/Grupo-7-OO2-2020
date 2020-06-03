package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Venta;

@Repository("itemRepository")
public interface IItemRepository extends JpaRepository<Item, Serializable>{
	
	public abstract Item findByIdItem(long id);	
	
	@Query("SELECT i FROM Item i WHERE i.venta=(:venta)")
	public abstract List<Item> findAllByVenta(@Param("venta") Venta venta );
	
}
