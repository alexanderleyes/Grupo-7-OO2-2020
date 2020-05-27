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
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.repositories.IPedidoRepository;
import com.unla.Grupo7OO22020.services.IPedidoService;

@Service("pedidoService")
public class PedidoService implements IPedidoService{
	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
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
		
		Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModelSinDespachante(pedido);
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
			pedidoModel =  pedidoConverter.entityToModelSinDespachante(pedido);	
		}
		return pedidoModel;
	}

	@Override
	public List<PedidoModel>  findAllBySucursal(SucursalModel sucursal) {			
		List<Pedido> pedidosEntities = pedidoRepository.findAllBySucursal(sucursalConverter.modelToEntity(sucursal));
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

}
