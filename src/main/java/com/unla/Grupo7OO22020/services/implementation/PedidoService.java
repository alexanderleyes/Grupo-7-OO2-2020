package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.PedidoConverter;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.models.PedidoModel;
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

	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) {
		
		System.out.println(pedidoModel.getSucDestino());
		System.out.println(pedidoModel.getSucOrigen());
		 Pedido pedido = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		return pedidoConverter.entityToModel(pedido);
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
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(id));
		
	}


}
