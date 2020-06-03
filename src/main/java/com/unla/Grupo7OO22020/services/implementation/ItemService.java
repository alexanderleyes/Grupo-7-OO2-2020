package com.unla.Grupo7OO22020.services.implementation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.ItemConverter;
import com.unla.Grupo7OO22020.converters.VentaConverter;
import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.models.ItemModel;
import com.unla.Grupo7OO22020.models.VentaModel;
import com.unla.Grupo7OO22020.repositories.IItemRepository;
import com.unla.Grupo7OO22020.services.IItemService;

@Service("itemService")

public class ItemService implements IItemService {

	@Autowired
	@Qualifier("itemRepository")
	private IItemRepository itemRepository;

	@Autowired
	@Qualifier("itemConverter")
	private ItemConverter itemConverter;
	
	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;
	
	@Override
	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	@Override
	public ItemModel insertOrUpdate(ItemModel itemModel) {
		Item item = itemRepository.save(itemConverter.ModelToEntity(itemModel));
		return itemConverter.entityToModel(item);

	}	

	@Override
	public boolean remove(long id) {
		try {
			itemRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public ItemModel findById(long id) {
		return itemConverter.entityToModel(itemRepository.findByIdItem(id));
	}
	
	public List<ItemModel> findAllByVenta(VentaModel ventaModel){
		 List<Item> items = itemRepository.findAllByVenta(ventaConverter.modelToEntity(ventaModel));
		 List<ItemModel> itemsModels = new ArrayList<ItemModel>();
		
		for(Item i : items) {	
			itemsModels.add(itemConverter.entityToModel(i));
		}
		return itemsModels;
		
	}
	
	
	

}


