package com.unla.Grupo7OO22020.converters;

import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.models.ProductoModel;


@Component("productoConverter")
public class ProductoConverter {
	
	public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(
				producto.getIdProducto(),
				producto.getDescripcion(),
				producto.getPrecioUnitario());
	}

	public Producto modelToEntity(ProductoModel productoModel) {
		return new Producto(
				productoModel.getIdProducto(),
				productoModel.getDescripcion(),
				productoModel.getPrecioUnitario());
		
	}
}
