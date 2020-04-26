package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import datos.Persona;
import datos.TipoEmpleado;
import negocio.PersonaABM;

public class testPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonaABM abmPersona = new PersonaABM();
		
		
		try {
		//	long idPersona = abmPersona.agregar("Alexander", "Leyes", LocalDate.of(1986, 11, 4), 32525748);
			
			 abmPersona.agregar("V", "v", LocalDate.of(1995, 12, 30), 11222333);
			 abmPersona.agregar("Jung", "Kook", LocalDate.of(1997, 9, 1), 44555666);
			 abmPersona.agregar("Rap", "Monster", LocalDate.of(1994, 9, 12), 7888999);
			 abmPersona.agregar("Jim", "In", LocalDate.of(1995, 10, 13), 10111111);
			 abmPersona.agregar("J", "in", LocalDate.of(1992, 12, 4), 12131314);
			 abmPersona.agregar("J", "Hope", LocalDate.of(1994, 2, 18), 15161718);
			 abmPersona.agregar("Su", "ga", LocalDate.of(1993, 3, 9), 192021223);
			
			 Set<Persona> items = new HashSet<Persona>(abmPersona.traer());  
			for (Persona item: items) {
				System.out.println(item);
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
