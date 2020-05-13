package com.unla.Grupo7OO22020.models;


import java.time.LocalDate;
import java.time.LocalTime;


public class VendedorModel extends EmpleadoModel {

	private long idVendedor;
	private LocalModel localModel;
	private long idLocal;
	
	public VendedorModel() {}	
	
	
	public VendedorModel(long idPersona, LocalModel localModel,  long idLocal, String nombre, String apellido, LocalDate fechaNacimiento, int dni, long idEmpleado, String usuario, String password, LocalTime horaIngreso,
			LocalTime horasXjornada, double plusSueldolong, long idVendedor) {
		super(idPersona, nombre, apellido, fechaNacimiento, dni, idEmpleado, usuario, password, horaIngreso, horasXjornada,  plusSueldolong);
		
		this.idVendedor = idVendedor;
		this.localModel	= localModel;
		this.idLocal = idLocal;
		
	}	
	
	
	public long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}


	public LocalModel getLocalModel() {
		return localModel;
	}


	public void setLocalModel(LocalModel local) {
		this.localModel = local;
	}


	public long getIdLocal() {
		return idLocal;
	}


	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}
	
	
	
		
}
