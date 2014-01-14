package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.microforum.model.Empleado;
import es.microforum.model.EmpleadoTest;
import es.microforum.model.Empresa;

public class EmpleadoTest {

	@Test
	public void testEquals() {
		byte[] imagen2 = null;
		Empleado e= new Empleado("20102541", new Empresa(), "jose",
				"Las Palmas", "tecnico", "empleadocoluma",
				20000.0, 50.0, 160.0, imagen2);
		Empleado j= new Empleado("20102541", new Empresa(), "jose",
				"Las Palmas", "tecnico", "empleadocol",
				20000.0, 50.0, 160.0, imagen2);
		assertTrue(e.equals(j));
			System.out.println("ok");
		
	}	
}
