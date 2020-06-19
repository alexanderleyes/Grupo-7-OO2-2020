package com.unla.Grupo7OO22020.services;

import java.time.LocalDate;
import java.util.List;

import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VentaModel;

public interface IVentaService {
	public List<Venta> getAll();		
	public boolean remove(long id);
	public VentaModel insertOrUpdate(VentaModel ventaModel);
	public VentaModel findByIdVenta(long id);
	public List<Venta> ventasPorSucursalEntreFechas(Sucursal sucursal,LocalDate fechaUno, LocalDate fechaDos);
	public List<Item> itemsPorVenta(Venta venta);
	public List<Item> ProductosEntreFechasPorSucursal(Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos);
	public void EstadoFinalizado(List<Pedido>lstPedidos,VentaModel venta);
	public List<VentaModel> ventasPorSucursal(SucursalModel sucursalModel);
	
}
