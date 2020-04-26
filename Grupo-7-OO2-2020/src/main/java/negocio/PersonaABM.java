package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;


public class PersonaABM {
	
	PersonaDao dao = new PersonaDao();
	
	public List<Persona> traer(){
		return dao.traer();
	}	
	
	public Persona traer(long idPersona) {
		Persona obj = dao.traer(idPersona);
		return obj;
	}

	public Persona traer(int dni) {
		Persona obj = dao.traer(dni);
		return obj;
	}

	public int agregar(String nombre, String apellido, LocalDate fechaNacimiento, int dni)  throws Exception {
	
		if (dao.traer(dni) != null) {
			throw new Exception("Ya existe un Persona con DNI: " + dni);			
		} else {
			Persona obj = new Persona(apellido, nombre, fechaNacimiento, dni);
			return dao.agregar(obj);
		}			
	}
	
	
	
	public void modificar(Persona obj) throws Exception {	
		Persona objAux = null;
		objAux = dao.traer(obj.getDni());		
		
		if (objAux != null){
			if (objAux.getIdPersona() == obj.getIdPersona()){
				throw new Exception("Es el mismo DNI!!!");
			}
			throw new Exception("Ya existe otro usuario con el DNI: " + obj.getDni());
		}else {
			dao.actualizar(obj);
		}			
	}

	public void eliminar(long idPersona) throws Exception{
		Persona obj = null;
		obj = dao.traer(idPersona);		 
		if (obj == null) {
			throw new Exception("No se puede eliminar, no existe Persona con ID: " + idPersona);
		}else {
			dao.eliminar(obj);
		}		
	}	
	
	
}
