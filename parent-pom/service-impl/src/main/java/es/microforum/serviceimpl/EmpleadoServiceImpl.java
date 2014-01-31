package es.microforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.microforum.model.Empleado;
import es.microforum.repository.EmpleadoRepository;
import es.microforum.serviceapi.EmpleadoService;

import com.google.common.collect.Lists;

@Service("springJpaEmpleadoService")
@Repository
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public void agregarModificarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		empleadoRepository.delete(empleado);
	}

	@Override
	public Empleado consultarEmpleadoPorDni(String dni) {
		return empleadoRepository.findOne(dni);
	}

	@Override
	public List<Empleado> consultarEmpleados() {
		return Lists.newArrayList(empleadoRepository.findAll());
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Empleado> findAll(Pageable pageable) {
		return empleadoRepository.findAll(pageable);
	}	


}
