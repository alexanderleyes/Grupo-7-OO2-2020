package com.unla.Grupo7OO22020.services.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.GerenteConverter;
import com.unla.Grupo7OO22020.converters.LoteConverter;
import com.unla.Grupo7OO22020.converters.ProductoConverter;
import com.unla.Grupo7OO22020.converters.SucursalConverter;
import com.unla.Grupo7OO22020.entities.Lote;
import com.unla.Grupo7OO22020.entities.Pedido;
import com.unla.Grupo7OO22020.entities.Producto;
import com.unla.Grupo7OO22020.entities.Sucursal;
import com.unla.Grupo7OO22020.helpers.Funciones;
import com.unla.Grupo7OO22020.models.GerenteModel;
import com.unla.Grupo7OO22020.models.PedidoModel;
import com.unla.Grupo7OO22020.models.ProductoModel;
import com.unla.Grupo7OO22020.models.SucursalModel;
import com.unla.Grupo7OO22020.repositories.ILoteRepository;
import com.unla.Grupo7OO22020.repositories.IProductoRepository;
import com.unla.Grupo7OO22020.repositories.ISucursalRepository;
import com.unla.Grupo7OO22020.services.ILoteService;
import com.unla.Grupo7OO22020.services.ISucursalService;

@Service("sucursalService")
public class SucursalService implements  ISucursalService{


	
	@Autowired
	@Qualifier("sucursalConverter")
	private SucursalConverter sucursalConverter;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Autowired
	@Qualifier("gerenteConverter")
	private GerenteConverter gerenteConverter;
	
	@Autowired
	@Qualifier("sucursalRepository")
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@Override
	public List<Sucursal> getAll() {
		return sucursalRepository.findAll();
	}

	@Override
	public SucursalModel findByIdSucursal(long id) {				
		return sucursalConverter.entityToModel(sucursalRepository.findByIdSucursal(id));
	}

	@Override
	public boolean remove(long id) {
		try {
			sucursalRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}	
		
	}

	@Override
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel) {
		Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
		return sucursalConverter.entityToModel(sucursal);
	}
	
			

	@Override
	public List<Sucursal> distancias(SucursalModel sucursal, ProductoModel producto, int cantidad) {
		
		List <Sucursal> sucursalesa = sucursalRepository.findAll();	
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		List<Sucursal>sucursalesCom =new ArrayList<Sucursal>();		
		double[] miArray = new double[] {999999999,999999999,999999999,999999999};
		int contador;
		long[] idArray = new long[] {0,0,0,0};
		SucursalModel sucursal2;		
		
		
		for (Sucursal s: sucursalesa ) {
			int stock = stock(s.getIdSucursal(),producto.getIdProducto());
			if(stock >= cantidad){
				sucursales.add(s);				
			}
		}
		
		
		if(sucursales.size() <=2) {			
			return sucursales;
		}
		
		for(contador = 0;contador< sucursales.size();contador++)
		{	
			sucursal2 = sucursalConverter.entityToModel(sucursales.get(contador));							
				double distanciaPivote = Funciones.distancia(sucursal, sucursal2);			 
				for(int i = 0 ; i<3; i++ ) {				
					if  (distanciaPivote < miArray[i]) {
							for(int j=2; j>=i ; j=j-1) {					
							miArray[j+1]=miArray[j];
							idArray[j+1]=idArray[j];
							
						}
						miArray[i]=distanciaPivote;
						idArray[i]=sucursal2.getIdSucursal();
						
						break;
					}
				}				
		}
		
		sucursalesCom.add(sucursalRepository.findByIdSucursal(idArray[0]));
		sucursalesCom.add(sucursalRepository.findByIdSucursal(idArray[1]));		
		sucursalesCom.add(sucursalRepository.findByIdSucursal(idArray[2]));
		
		return sucursalesCom;
}

	@Override
	public SucursalModel findByGerente(GerenteModel gerenteModel) {		
		return sucursalConverter.entityToModel(sucursalRepository.findByGerente(gerenteConverter.modelToEntity(gerenteModel)));
	}

	@Override
	public List<SucursalModel> findAllExcept(SucursalModel sucursalModel) {
		 ;
		 
		 List<Sucursal> sucursalesEntities = sucursalRepository.findAllExcept(sucursalConverter.modelToEntity(sucursalModel));
		 List<SucursalModel> sucursalesModels = new ArrayList<SucursalModel>();
		 for (Sucursal s : sucursalesEntities) {
			 sucursalesModels.add(sucursalConverter.entityToModel(s));
		 }		 
		 
		return sucursalesModels;
	}

	
	@Override
	public int stock(long idSucursal, long idProducto) {
	 Set<Lote> stock = loteRepository.findAllBySucursal(sucursalRepository.findByIdSucursal(idSucursal));
	 List<Lote>lote = new ArrayList<Lote>();
	 int disponible = 0;
		
	 for(Lote l: stock) {
			if(l.getProducto().equals(productoRepository.findByIdProducto(idProducto)) ) {
				lote.add(l);
			}
			
		}
	 
	 for(Lote l1: lote) {
		disponible = disponible + l1.getCantidad();
	 }
		
		return disponible;
	}

	@Override
	public List<Lote> stock(long idSucursal, long idProducto, int cantidad) {
		
		 Set<Lote> stock = loteRepository.findAllBySucursal(sucursalRepository.findByIdSucursal(idSucursal));
		 List<Lote>lote = new ArrayList<Lote>();
			
		 for(Lote l: stock) {
				if(l.getProducto().equals(productoRepository.findByIdProducto(idProducto)) ) {
					lote.add(l);
				}
				
		 }
		return lote;
	}

	@Override
	public void consumir(long idSucursal, long idProducto, int cantidad) {
		List<Lote> lote = stock(idSucursal,idProducto,cantidad);
		int resta;
		while (cantidad > 0) {
			for(Lote l: lote) {	

				if(l.getCantidad() >= cantidad) {
					resta =l.getCantidad() - cantidad;
					l.setCantidad(resta);
					cantidad = 0;				
					loteService.insertOrUpdate(l);
					loteService.deshabilitar(l.getIdLote());				
					break;
				} else {
					cantidad = cantidad - l.getCantidad();
					l.setCantidad(0); 
					loteService.insertOrUpdate(l);
					loteService.deshabilitar(l.getIdLote());	
					if(cantidad==0) {
						break;
					}
				}

			}

		}
		
		
	}

	
	
	
	

}
