package es.microforum.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmpleadoTest {

	Empleado emp1;
	Empleado emp2;
	Empleado emp3;
	
	@Before
	public void setUp() throws Exception {
		emp1 = new Empleado("dni1");
		emp2 = new Empleado("dni1");
		emp3 = new Empleado("dni3");
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
		assertTrue( emp1.toString().contains("dni1"));
	}

}
