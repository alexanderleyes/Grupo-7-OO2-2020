package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.TipoEmpleadoDao;
import datos.TipoEmpleado;


public class TipoEmpleadoABM {
	
	TipoEmpleadoDao dao = new TipoEmpleadoDao();
	
	public List<TipoEmpleado> traer(){
		return dao.traer();
	}	
	
	public TipoEmpleado traer(long idTipoEmpleado) {
		TipoEmpleado obj = dao.traer(idTipoEmpleado);
		return obj;
	}
	

	public int agregar(String nombre, String descripcion, double sueldoBasico)  throws Exception {
	
		if (dao.traer(nombre) != null) {
			throw new Exception("Ya existe un TipoEmpleado con Nombre: " + nombre);			
		} else {
			TipoEmpleado p = new TipoEmpleado(nombre, descripcion, sueldoBasico);
			return dao.agregar(p);
		}			
	}
	
	
	
	public void modificar(TipoEmpleado p) throws Exception {	
		TipoEmpleado objAux = null;
		objAux = dao.traer(p.getNombre());	
		
		if (objAux != null){			
			throw new Exception("Ya existe otro TipoEmpleado con el nombre: " + p.getNombre());
		}else {
			dao.actualizar(p);
		}			
	}

	public void eliminar(long idPersona) throws Exception{
		TipoEmpleado p = null;
		p = dao.traer(idPersona);		 
		if (p == null) {
			throw new Exception("No se puede eliminar, no existe Persona con ID: " + idPersona);
		}else {
			dao.eliminar(p);
		}		
	}	
	
	
}
