package test;

import java.util.HashSet;
import java.util.Set;

import antlr.collections.List;
import datos.TipoEmpleado;
import negocio.TipoEmpleadoABM;

public class testEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TipoEmpleado tipoEmpleado = new TipoEmpleado();
		TipoEmpleadoABM abmTipoEmpleado = new TipoEmpleadoABM();
		
		try {
			
			abmTipoEmpleado.agregar("Gerente", "Gerente de una Sucursal", 50000);
			abmTipoEmpleado.agregar("Vendedor", "Uno de los tantos vendedores  de una Sucursal", 35000);	
			

			Set<TipoEmpleado> items = new HashSet<TipoEmpleado>(abmTipoEmpleado.traer());  
			
			for (TipoEmpleado item: items) {
				System.out.println(item);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
