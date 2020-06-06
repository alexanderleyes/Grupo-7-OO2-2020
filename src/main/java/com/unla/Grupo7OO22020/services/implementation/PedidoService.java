package com.unla.Grupo7OO22020.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.PedidoConverter;
import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.converters.VendedorConverter;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Venta;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.repositories.IPedidoRepository;
import com.unla.Grupo7OO22020.repositories.IVentaRepository;
import com.unla.Grupo7OO22020.services.IPedidoService;

@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;


	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) {
		Pedido pedido = null;
		PedidoModel pedidoModelAux = null;
		
		
		if (pedidoModel.getVendedorDespacha() == null) {
			
			Venta v  = ventaRepository.findByIdVenta(pedidoModel.getIdVenta()); 
			if(v.getEstado().getIdEstadoVenta()==2) {
				
				pedido = pedidoRepository.save(pedidoConverter.modelToEntitySinDespachanteConIdVenta(pedidoModel));
				
			}else {
			
				pedido = pedidoRepository.save(pedidoConverter.modelToEntitySinDespachante(pedidoModel));
			
			}
		}
		else{
			Venta v = ventaRepository.findByIdVenta(pedidoModel.getIdVenta());
			if(v.getEstado().getIdEstadoVenta()==3) {
				
				pedido = pedidoRepository.save(pedidoConverter.modelToEntityConDespachanteConIdVenta(pedidoModel));
			}else {
			
				pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
			
			}
		}
		
		
		if (pedido.getVendedorDespacha() == null) {
			pedidoModelAux = pedidoConverter.entityToModelSinDespachante(pedido);
		}
		else{
			pedidoModelAux = pedidoConverter.entityToModel(pedido);
		}		
		
		return pedidoModelAux;
	}
	

	@Override
	public boolean remove(long id) {
		try {
			pedidoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public PedidoModel findById(long id) {
		Pedido pedido = pedidoRepository.findByIdPedido(id);
		PedidoModel pedidoModel = null;
		if (pedido.getVendedorDespacha() != null) {
			
			
			pedidoModel = pedidoConverter.entityToModel(pedido);
			
			
		}else {
			
			if(pedido.getIdVenta()!=0) {
				pedidoModel = pedidoConverter.entityToModelSinDespachanteConIdVenta(pedido);
			}else {
				
				pedidoModel =  pedidoConverter.entityToModelSinDespachante(pedido);	
			}
			
		}
		return pedidoModel;
	}

	@Override
	public List<PedidoModel>  findAllBySucursalDes(SucursalModel sucursal) {			
		List<Pedido> pedidosEntities = pedidoRepository.findAllBySucursalDes(sucursalConverter.modelToEntity(sucursal));
		List<PedidoModel> pedidosModels = new ArrayList<PedidoModel>();
		for (Pedido p : pedidosEntities) {
			if (p.getVendedorDespacha() == null) {
				pedidosModels.add(pedidoConverter.entityToModelSinDespachante(p));
			}else {
				pedidosModels.add(pedidoConverter.entityToModel(p));
			}			
	    }		
		return pedidosModels;	
	}
	
	
	@Override
	public List<PedidoModel>  findAllBySucursalOri(SucursalModel sucursal) {			
		List<Pedido> pedidosEntities = pedidoRepository.findAllBySucursalOri(sucursalConverter.modelToEntity(sucursal));
		List<PedidoModel> pedidosModels = new ArrayList<PedidoModel>();
		for (Pedido p : pedidosEntities) {
			if (p.getVendedorDespacha() == null) {
				pedidosModels.add(pedidoConverter.entityToModelSinDespachante(p));
			}else {
				pedidosModels.add(pedidoConverter.entityToModel(p));
			}			
	    }		
		return pedidosModels;	
	}

	@Override
	public List<PedidoModel> findAllByVendedor(VendedorModel vendedor) {
		List<Pedido> pedidosEntities = pedidoRepository.findAllByVendedor(vendedorConverter.modelToEntity(vendedor));
		List<PedidoModel> pedidosModels = new ArrayList<PedidoModel>();
		for (Pedido p : pedidosEntities) {
			if (p.getVendedorDespacha() == null) {
				pedidosModels.add(pedidoConverter.entityToModelSinDespachante(p));
			}else {
				pedidosModels.add(pedidoConverter.entityToModel(p));
			}	
	    }		
		return pedidosModels;	
	}

	@Override
	public List<PedidoModel> findAllBySucursalExceptVendedor(SucursalModel sucursal, VendedorModel vendedor) {
		List<Pedido> pedidosEntities = pedidoRepository.findAllBySucursalExceptVendedor(sucursalConverter.modelToEntity(sucursal), vendedorConverter.modelToEntity(vendedor));
		List<PedidoModel> pedidosModels = new ArrayList<PedidoModel>();
		for (Pedido p : pedidosEntities) {
			if (p.getVendedorDespacha() == null) {
				pedidosModels.add(pedidoConverter.entityToModelSinDespachante(p));
			}else {
				pedidosModels.add(pedidoConverter.entityToModel(p));
			}	
	    }		
		return pedidosModels;	
	}

	@Override
	public List<Pedido> findAllByIDVenta(long id) {
		
		
		List<Pedido> pedidos= pedidoRepository.findAllByIDVenta(id);
		
		
		return pedidos;
	}	

}
