package com.unla.Grupo7OO22020;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import negocio.PersonaABM;

@SpringBootTest
class Grupo7Oo22020ApplicationTests {

	@Test
	void contextLoads() {
		
PersonaABM abmPersona = new PersonaABM();
		
		
		try {
			long idPersona = abmPersona.agregar("Alexander", "Leyes", LocalDate.of(1986, 11, 4), 32525748);
			
			System.out.println(abmPersona.traer(idPersona));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
