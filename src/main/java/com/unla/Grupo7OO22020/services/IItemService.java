package com.unla.Grupo7OO22020.services;

import java.util.List;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.models.ItemModel;
import com.unla.Grupo7OO22020.models.VentaModel;

public interface IItemService {
	
	public List<Item> getAll();
	
	public ItemModel findById(long id);	
	
	public ItemModel insertOrUpdate(ItemModel itemModel);
	
	public boolean remove(long id);
	
	public List<ItemModel> findAllByVenta(VentaModel ventaModel);
	

}
