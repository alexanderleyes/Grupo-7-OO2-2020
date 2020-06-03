package com.unla.Grupo7OO22020.components;

import org.springframework.stereotype.Component;

@Component("calculador")
public class calculador {
	
	
	public double calcularSubTotal(long cantidad, double precioUnitario) {
		return cantidad * precioUnitario;
	}
}