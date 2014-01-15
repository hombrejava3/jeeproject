package es.microforum.serviceimpl;

import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;
import es.microforum.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, String> {

	public List FindByEmpresa(String nombre);
	public List findByCriteriaQuery(String nif, String nombre);

}
