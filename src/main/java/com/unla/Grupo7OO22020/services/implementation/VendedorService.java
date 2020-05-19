package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.VendedorConverter;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.repositories.IVendedorRepository;
import com.unla.Grupo7OO22020.services.IVendedorService;

@Service("vendedorService")
public class VendedorService implements  IVendedorService{

	@Autowired
	@Qualifier("vendedorRepository")
	private IVendedorRepository vendedorRepository;
	
	@Autowired
	@Qualifier("vendedorConverter")
	private VendedorConverter vendedorConverter;
	
	@Override
	public List<Vendedor> getAll(){
		return vendedorRepository.findAll();
	}
		
	
	@Override
	public VendedorModel findByApellido(String apellido){
		
			Vendedor vendedor = null;
			vendedor = vendedorRepository.findByApellido(apellido);
			
			if(vendedor == null) {
				System.out.println("Vendedor null");
				vendedor = new Vendedor();
				vendedor.setUsuario("dummy");
			}else {
				return vendedorConverter.entityToModel(vendedor);
			}			
			return vendedorConverter.entityToModel(vendedor);
	}
	
	
	@Override
	public VendedorModel findByDni(int dni){
		
			Vendedor vendedor = null;
			vendedor = vendedorRepository.findByDni(dni);
			
			if(vendedor == null) {
				System.out.println("Vendedor null");
				vendedor = new Vendedor();
				vendedor.setUsuario("dummy");
			}else {
				return vendedorConverter.entityToModel(vendedor);
			}			
			return vendedorConverter.entityToModel(vendedor);
	}	
	
	@Override
	public VendedorModel findByUsuario(String usuario){
		
		Vendedor vendedor = null;
		vendedor = vendedorRepository.findByUsuario(usuario);
		
		if(vendedor != null) {			
			return vendedorConverter.entityToModel(vendedor);			
		}				
		return null ;
		
}	
	
	
	
	@Override
	public VendedorModel insertOrUpdate(VendedorModel vendedorModel) {		
		Vendedor vendedor = vendedorRepository.save(vendedorConverter.modelToEntity(vendedorModel));
		return vendedorConverter.entityToModel(vendedor);
	}
	
	@Override
	public boolean remove(long idVendedor) {
		try {
			vendedorRepository.deleteById(idVendedor);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}


	@Override
	public VendedorModel findByIdVendedor(long id) {
		Vendedor empleado = null;
		empleado = vendedorRepository.findByIdPersona(id);			
		return vendedorConverter.entityToModel(empleado);
	}
	
	
	
}
