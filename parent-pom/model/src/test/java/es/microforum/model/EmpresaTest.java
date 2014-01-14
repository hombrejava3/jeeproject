package es.microforum.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import es.microforum.model.Empleado;
import es.microforum.model.Empresa;

public class EmpresaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testObject() {
		HashSet empleados=new HashSet();
		Empresa empresa= new Empresa("458214", "viprisa", "Gran via",
				new Date(), empleados);
		Empresa empresa1=new Empresa("458214", "viprisa", "Gran via",
				new Date(), empleados);
		assertTrue(empresa.equals(empresa1));
		System.out.println("equals Empresa verificado");
			
		
	}

	
}
