package com.unla.Grupo7OO22020.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.VentaModel;

@Component("ventaConverter")
public class VentaConverter {
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Autowired
	@Qualifier("estadoVentaConverter")
	private EstadoVentaConverter estadoVentaConverter;	
	
	public VentaModel entityToModel(Venta venta) { 
		return new VentaModel(
				venta.getIdVenta(), 
				sucursalConverter.entityToModel(venta.getSucursal()),
				vendedorConverter.entityToModel(venta.getVendedor()),
				personaConverter.entityToModel(venta.getCliente()),
				estadoVentaConverter.entityToModel(venta.getEstado()));
	}
	

	
	public Venta modelToEntity(VentaModel ventaModel) { 
		
		return new Venta(
				ventaModel.getIdVenta(), 
				sucursalConverter.modelToEntity(ventaModel.getSucursal()),
				vendedorConverter.modelToEntity(ventaModel.getVendedor()),
				personaConverter.modelToEntity(ventaModel.getCliente()),
				estadoVentaConverter.modelToEntity(ventaModel.getEstado()));
	}
}
