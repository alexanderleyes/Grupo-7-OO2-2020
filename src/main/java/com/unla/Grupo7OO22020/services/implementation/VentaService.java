package com.unla.Grupo7OO22020.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.ProductoConverter;
import com.unla.Grupo7OO22020.converters.VentaConverter;
import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;
import com.unla.Grupo7OO22020.models.VentaModel;
import com.unla.Grupo7OO22020.repositories.IVentaRepository;
import com.unla.Grupo7OO22020.services.IEstadoVentaService;
import com.unla.Grupo7OO22020.services.IVentaService;

@Service("ventaService")
public class VentaService implements IVentaService {

	@Autowired
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;

	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<Venta> getAll() {
		return ventaRepository.findAll();
	}

	@Autowired
	@Qualifier("estadoVentaService")
	private IEstadoVentaService estadoVentaService;

	@Override
	public VentaModel findByIdVenta(long id) {
		return ventaConverter.entityToModel(ventaRepository.findByIdVenta(id));
	}

	@Override
	public boolean remove(long id) {
		try {
			ventaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public VentaModel insertOrUpdate(VentaModel ventaModel) {
		Venta venta = ventaRepository.save(ventaConverter.modelToEntity(ventaModel));
		return ventaConverter.entityToModel(venta);
	}

	@Override
	public List<Venta> ventasPorSucursal(Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos) {
		List<Venta> lstVentas = ventaRepository.ventasPorSucursal(sucursal, fechaUno, fechaDos);

		return lstVentas;
	}

	@Override
	public List<Item> itemsPorVenta(Venta venta) {
		List<Item> lstItems = ventaRepository.itemsPorVenta(venta);
		return lstItems;
	}

	@Override
	public List<Item> ProductosEntreFechasPorSucursal(Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos) {

		List<Venta> lstVentas = ventasPorSucursal(sucursal, fechaUno, fechaDos);
		List<Item> lstItems = new ArrayList();
		List<Item> lstItemsResult = new ArrayList();
		for (Venta v : lstVentas) {

			lstItems = itemsPorVenta(v);

			for (Item i : lstItems) {

				lstItemsResult.add(i);
			}

		}

		return lstItemsResult;
	}

	//para setear estado FINALIZADO una vez que esten todos los pedidos despachados 
	public void EstadoFinalizado(List<Pedido> lstPedidos, VentaModel venta) {
		int contadorDespacha = 0;
		

		for (int i = 0; i < lstPedidos.size(); i++) {
			Pedido p = lstPedidos.get(i);
			
			if (p.getVendedorDespacha() != null) {
				contadorDespacha++;
			}
			if (contadorDespacha == lstPedidos.size()) {
				EstadoVentaModel estadoV = estadoVentaService.findByIdEstadoVenta(3);
				venta.setEstado(estadoV);
				insertOrUpdate(venta);

			}

		}
	}
}
