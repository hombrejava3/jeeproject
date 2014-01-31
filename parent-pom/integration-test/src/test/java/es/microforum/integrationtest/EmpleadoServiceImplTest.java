package es.microforum.integrationtest;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import es.microforum.model.Empleado;
import es.microforum.serviceapi.EmpleadoService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/*
 * @author Alejandro Carmona Mejía
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-data-app-context.xml"})
@TransactionConfiguration(defaultRollback=true)
public class EmpleadoServiceImplTest {
	
	// Contexto de Spring
	@Autowired
	private ApplicationContext ctxSpring;
	@Autowired 
	EmpleadoService empleadoService;
	// Empleados
	Empleado empleado1;

	@Before
	public void setUp() throws Exception {
		// Creacion del bean de servicio
		//empleadoService = ctxSpring.getBean("springJpaEmpleadoService", EmpleadoService.class);
		// Creacion de un empleado para las pruebas
		empleado1 = new Empleado("dniJUnit", null, "empleadoJUnit", "Calle 1, 1A", "tipoEmpleado1", "empleadoCol1", 18000.0, 12.5, 148.0, null);
	}

	@Test
	@Transactional
	public void testAgregarModificarEmpleado() {
		// Agrego un empleado
		empleadoService.agregarModificarEmpleado(empleado1);
		assertTrue(empleadoService.consultarEmpleadoPorDni(empleado1.getDni()).getNombre().equals("empleadoJUnit"));
	}

	@Test
	@Transactional
	public void testEliminarEmpleado() {
		// Elimino el empleado
		empleadoService.eliminarEmpleado(empleado1);
		assertTrue(empleadoService.consultarEmpleadoPorDni(empleado1.getDni()) == null);
	}
	
	@Test
	@Transactional
	public void testConsultarEmpleadoPorDni() {
		// Agrego un empleado para poder consultarlo
		testAgregarModificarEmpleado();
		// Consulto el empleado y verifico que sea el esperado
		Empleado empleado = empleadoService.consultarEmpleadoPorDni(empleado1.getDni());
		assertTrue(empleado.getNombre().equals("empleadoJUnit"));
	}

	@Test
	@Transactional
	public void testConsultarEmpleados() {
		// Agrego un empleado para poder consultarlo
		testAgregarModificarEmpleado();
		// Consulto todos los empleados en la base de datos
		List<Empleado> empleados = empleadoService.consultarEmpleados();
		// Compruebo que exista al menos un empleado (el agregado)
		assertTrue(empleados.size() > 0);
		assertTrue(empleados.contains(empleado1));
	}

}
