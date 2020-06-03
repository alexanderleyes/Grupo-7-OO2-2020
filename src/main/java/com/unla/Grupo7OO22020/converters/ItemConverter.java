package com.unla.Grupo7OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.models.ItemModel;

@Component("itemConverter")
public class ItemConverter {
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;
	
	
	public ItemModel entityToModel(Item item) {
		return new ItemModel(
				item.getIdItem(),
				productoConverter.entityToModel(item.getProducto()),
				item.getCantidad(),
				ventaConverter.entityToModel(item.getVenta()));
	}
	
	public Item ModelToEntity(ItemModel itemModel) {
		return new Item(
				itemModel.getIdItem(),
				productoConverter.modelToEntity(itemModel.getProducto()),
				itemModel.getCantidad(),
				ventaConverter.modelToEntity(itemModel.getVenta()));
	}
}