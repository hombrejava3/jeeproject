package es.microforum.integrationtest;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import es.microforum.model.Empresa;
import es.microforum.serviceapi.EmpresaService;

/*
 * @author Alejandro Carmona Mejía
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-data-app-context.xml"})
@TransactionConfiguration(defaultRollback=true)
public class EmpresaServiceImplTest {

	// Contexto de Spring
	@Autowired
	private ApplicationContext ctxSpring;
	// Bean de servicio
	@Autowired
	EmpresaService empresaService;
	// Empresas
	Empresa empresa1;
	// Objeto para realizar parseo de fechas
	SimpleDateFormat sdf;

	@Before
	public void setUp() throws Exception {
		// Creación del bean de servicio
		//empresaService = ctxSpring.getBean("springJpaEmpresaService", EmpresaService.class);
		// SimpleDateFormat
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		// Creación de una empresa
		empresa1 = new Empresa("nifJUnit", "empresaJUnit", "Calle 1, 1A", sdf.parse("01/01/2013"), null);
	}
	
	@Test
	@Transactional
	public void testAgregarModificarEmpresa() {
		// Agrego una empresa
		empresaService.agregarModificarEmpresa(empresa1);
	}
	
	@Test
	@Transactional
	public void testEliminarEmpresa() {
		// Elimino la empresa y compruebo que al consultarla no exista
		empresaService.eliminarEmpresa(empresa1);
		assertTrue(empresaService.consultarEmpresaPorNif(empresa1.getNif()) == null);
	}
	
	@Test
	@Transactional
	public void testConsultarEmpresaPorNif() {
		// Agrego una empresa para poder consultarla
		testAgregarModificarEmpresa();
		// Consulto la empresa y verifico que sea la esperada
		Empresa empresa = empresaService.consultarEmpresaPorNif(empresa1.getNif());
		assertTrue(empresa.getNombre().equals("empresaJUnit"));
	}

	@Test
	@Transactional
	public void testConsultarEmpresas() {
		// Agrego una empresa para poder consultarla
		testAgregarModificarEmpresa();
		// Consulto todos los empleados en la base de datos
		List<Empresa> empresas = empresaService.consultarEmpresas();
		// Compruebo que exista al menos una empresa (la agregada)
		assertTrue(empresas.size() > 0);
		assertTrue(empresas.contains(empresa1));
	}

}
