package com.unla.Grupo7OO22020.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.Grupo7OO22020.services.ISucursalService;

@Component("calculador")
public class calculador {
	
	@Autowired
	@Qualifier("sucursalService")
	private ISucursalService sucursalService;
	
	public double calcularSubTotal(long cantidad, double precioUnitario) {
		return cantidad * precioUnitario;
	}
	
	public double stockDelProducto(long idSucursal, long idProducto) {		
		return sucursalService.stock(idSucursal, idProducto);
	}
}