package es.microforum.integrationtest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.assertTrue;
import es.microforum.integrationtest.Transacciones;
import es.microforum.model.Empresa;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:it-context.xml"})
public class EmpresaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
