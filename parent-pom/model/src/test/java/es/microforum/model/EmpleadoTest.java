package es.microforum.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import es.microforum.model.Empleado;
import es.microforum.model.EmpleadoTest;
import es.microforum.model.Empresa;

public class EmpleadoTest {

	@Test
	public void testEquals() {
		byte[] imagen2 = null;
		Empleado emp= new Empleado("458214", new Empresa(), "jose",
				"Las Palmas", "tecnico", "empleadocoluma",
				20000.0, 50.0, 160.0, imagen2);
		Empleado emp2= new Empleado("458214", new Empresa(), "jose",
				"Las Palmas", "tecnico", "empleadocolumna",
				20000.0, 50.0, 160.0, imagen2);
		assertTrue(emp.equals(emp2));
			
		
	}	
	
	@Test
	public void testToString() {
		String dni="458214";
		byte[] imagen2 = null;
		Empleado ab= new Empleado(dni, new Empresa(),"jose",
				"Las Palmas","tecnico", "empleadoc",
				 20000.0, 50.0, 160.0, imagen2);
		assertTrue( ab.toString().contains("458214"));
		System.out.println("test empleado verificado");
	}
}
