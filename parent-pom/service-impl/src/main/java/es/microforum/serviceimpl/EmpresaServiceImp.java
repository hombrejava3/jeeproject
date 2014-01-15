package es.microforum.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import es.microforum.serviceimpl.EmpresaRepository;
import es.microforum.serviceapi.InterfaceSer;
import es.microforum.model.Empresa;

@Service("springJpaEmpresaService")
@Repository
@Transactional
public class EmpresaServiceImp implements InterfaceSer {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Transactional(readOnly = true)
	public List<Empresa> FindByEmpresas() {
		return Lists.newArrayList(((EmpresaServiceImp) empresaRepository).FindByEmpresas());
			
	}

	@Override
	public Empresa save(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Empresa empresa) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Empresa> findByCriteriaQuery(String nif, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> findBynif(String nif) {
		// TODO Auto-generated method stub
		return null;
	}

}
