package com.unla.Grupo7OO22020.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo7OO22020.converters.VendedorConverter;
import com.unla.Grupo7OO22020.entities.UserRole;
import com.unla.Grupo7OO22020.entities.Vendedor;
import com.unla.Grupo7OO22020.models.VendedorModel;
import com.unla.Grupo7OO22020.repositories.IUserRoleRepository;
import com.unla.Grupo7OO22020.repositories.IVendedorRepository;
import com.unla.Grupo7OO22020.services.IUserRoleService;
import com.unla.Grupo7OO22020.services.IVendedorService;

@Service("userRoleService")
public class UserRoleService implements  IUserRoleService{

	@Autowired
	@Qualifier("userRoleRepository")
	private IUserRoleRepository userRoleRepository;	
	
	public UserRole insertOrUpdate(UserRole role) {		
		UserRole roleAux = userRoleRepository.save(role);
		return roleAux;
	}
	
		
	
	
}
