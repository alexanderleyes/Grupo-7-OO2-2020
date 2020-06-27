package com.unla.Grupo7OO22020.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.ProductoConverter;
import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.converters.VentaConverter;
import com.unla.Grupo7OO22020.entities.Item;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.EstadoVentaModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VentaModel;
import com.unla.Grupo7OO22020.repositories.IVentaRepository;
import com.unla.Grupo7OO22020.services.IEstadoVentaService;
import com.unla.Grupo7OO22020.services.IPedidoService;
import com.unla.Grupo7OO22020.services.IVendedorService;
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
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;

	@Override
	public List<Venta> getAll() {
		return ventaRepository.findAll();
	}

	@Autowired
	@Qualifier("estadoVentaService")
	private IEstadoVentaService estadoVentaService;
	
	@Autowired
	@Qualifier("vendedorService")
	private IVendedorService vendedorService;	
	

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;	

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
	public List<Venta> ventasPorSucursalEntreFechas(Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos) {
		List<Venta> lstVentas = ventaRepository.ventasPorSucursalEntreFechas(sucursal, fechaUno, fechaDos);

		return lstVentas;
	}

	@Override
	public List<Item> itemsPorVenta(Venta venta) {
		List<Item> lstItems = ventaRepository.itemsPorVenta(venta);
		return lstItems;
	}

	@Override
	public List<Item> ProductosEntreFechasPorSucursal(Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos) {

		List<Venta> lstVentas = ventasPorSucursalEntreFechas(sucursal, fechaUno, fechaDos);
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
	
	@Override
	public List<VentaModel> ventasPorSucursal(SucursalModel sucursalModel) {
		
		List<VentaModel> ventasModel = new ArrayList<VentaModel>();
		List<Venta> ventasEntities = ventaRepository.ventasPorSucursal(sucursalConverter.modelToEntity(sucursalModel));
		
		for (Venta venta : ventasEntities) {
			if (venta.getFecha() != null) {
				venta.setFecha(venta.getFecha().plusDays(1));
			}
			ventasModel.add(ventaConverter.entityToModel(venta));			
		}
		
		return ventasModel;
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
	
	public List<Vendedor> comisionesEntreFechas(Sucursal sucursal, LocalDate fechaUno, LocalDate fechaDos) {
		double comision;
		List<Vendedor> lstVendedores = vendedorService.findAllBySucursal(sucursal);		
		
		for (Vendedor v : lstVendedores) {
			v.setPlusSueldo(0);
			List<Item> lstItems = ventaRepository.itemsVentasPorVendedorEntreFechas(v, fechaUno, fechaDos);
			
			for (Item i : lstItems) {
				Pedido pedido = pedidoService.findByItem(i);
				if(pedido == null) {
					comision = i.getCantidad() * i.getProducto().getPrecioUnitario() * 0.05;
					v.setPlusSueldo(v.getPlusSueldo() + comision);
				}else {				
					comision = i.getCantidad() * i.getProducto().getPrecioUnitario() * 0.03;
					v.setPlusSueldo(v.getPlusSueldo() + comision);
					
					
				}
			}
			
			List<Pedido> lstPedidos = pedidoService.findAllByVendedorDes(v);
			for (Pedido p : lstPedidos) {
				Venta venta = ventasEntreFechas(p.getIdVenta(), fechaUno, fechaDos);
				if (venta != null){
					comision = p.getCantidad() * p.getProducto().getPrecioUnitario() * 0.02;
					v.setPlusSueldo(v.getPlusSueldo() + comision);
				}
			}
			
		}
		
		
		return lstVendedores;
	}
	
	public Venta ventasEntreFechas(long idVenta, LocalDate fechaUno, LocalDate fechaDos) {
		Venta venta = null;
		venta = ventaRepository.ventasEntreFechas(idVenta, fechaUno, fechaDos);
		return venta;
	}
}
