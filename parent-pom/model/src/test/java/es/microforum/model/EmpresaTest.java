package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {

	Empresa emp1;
	Empresa emp2;
	Empresa emp3;
	
	@Before
	public void setUp() throws Exception {
		emp1 = new Empresa("nif1");
		emp2 = new Empresa("nif1");
		emp3 = new Empresa("nif3");
	}

	@After
	public void tearDown() throws Exception {
		emp1 = null;
		emp2 = null;
		emp3 = null;
	}

	@Test
	public void testEquals() {
		assertTrue(emp1.equals(emp2));
		assertTrue(!emp1.equals(emp3));
	}
	
	@Test
	public void testToString() {
		assertTrue( emp1.toString().contains("nif1"));
	}

}
