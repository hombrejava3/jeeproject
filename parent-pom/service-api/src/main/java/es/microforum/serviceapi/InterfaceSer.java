package es.microforum.serviceapi;

import java.util.List;

import es.microforum.model.Empresa;



public interface InterfaceSer {
	
		// lista empresas
		public List<Empresa> FindByEmpresas();
		
		// Insert or update a empresa	
		public Empresa save(Empresa empresa);
		
		// Delete a empresa	
		public void delete(Empresa empresa);
		
		// Find contacts by criteria query
		public List<Empresa> findByCriteriaQuery(String nif, String nombre);
		
		// Find contacts by nif
		public List<Empresa> findBynif(String nif);
		
		
	}


