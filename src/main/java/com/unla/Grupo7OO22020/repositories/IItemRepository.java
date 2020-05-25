package com.unla.Grupo7OO22020.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.Grupo7OO22020.entities.Item;

@Repository("itemRepository")
public interface IItemRepository extends JpaRepository<Item, Serializable>{
	
	public abstract Item findByIdItem(long id);
	
}
