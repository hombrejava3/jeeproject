package es.microforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import es.microforum.model.Empresa;
import es.microforum.repository.EmpleadoRepository;
import es.microforum.repository.EmpresaRepository;
import es.microforum.serviceapi.EmpresaService;

@Service("springJpaEmpresaService")
@Repository
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public void agregarModificarEmpresa(Empresa empresa) {
		empresaRepository.save(empresa);
	}

	@Override
	public void eliminarEmpresa(Empresa empresa) {
		empresaRepository.delete(empresa);
	}

	@Override
	public Empresa consultarEmpresaPorNif(String nif) {
		return empresaRepository.findOne(nif);
	}

	@Override
	public List<Empresa> consultarEmpresas() {
		return Lists.newArrayList(empresaRepository.findAll());
	}

	@Override
	public Page<Empresa> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
