package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.EmpleadoConverter;
import com.unla.Grupo7OO22020.entities.Empleado;
import com.unla.Grupo7OO22020.models.EmpleadoModel;
import com.unla.Grupo7OO22020.repositories.IEmpleadoRepository;
import com.unla.Grupo7OO22020.services.IEmpleadoService;

@Service("empleadoService")
public class EmpleadoService implements  IEmpleadoService{

	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Override
	public List<Empleado> getAll(){
		return empleadoRepository.findAll();
	}
		
	
	@Override
	public EmpleadoModel findByUsuario(String usuario){
		
			Empleado empleado = null;
			empleado = empleadoRepository.findByUsuario(usuario);
			
			if(empleado == null) {
				System.out.println("Empleado null");
				empleado = new Empleado();
				empleado.setUsuario("dummy");
			}else {
				return empleadoConverter.entityToModel(empleado);
			}			
			return empleadoConverter.entityToModel(empleado);
	}		
	
	@Override
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel) {
		Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
		return empleadoConverter.entityToModel(empleado);
	}
	
	@Override
	public boolean remove(long idEmpleado) {
		try {
			empleadoRepository.deleteById(idEmpleado);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}

	@Override
	public EmpleadoModel findByIdEmpleado(long idEmpleado) {	
		Empleado empleado = null;
		empleado = empleadoRepository.findByIdPersona(idEmpleado);			
		return empleadoConverter.entityToModel(empleado);
	}
	
	
	
}
