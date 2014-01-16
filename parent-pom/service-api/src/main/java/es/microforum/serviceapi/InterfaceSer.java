package es.microforum.serviceapi;

import java.util.List;

import es.microforum.model.Empresa;

public interface InterfaceSer {

	// lista empresas
	public List<Empresa> findAll();

	public List<Empresa> findAllWithDetail();

	public Empresa findByNif(String nif);

	// Insert or update a empresa
	public Empresa save(Empresa empresa);

	// Delete a empresa
	public void delete(Empresa empresa);

}
