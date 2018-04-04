package com.german.spring.hibernate.Service.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.german.spring.hibernate.Dao.IEmpleadoDao;
import com.german.spring.hibernate.Service.IEmpleadoService;
import com.german.spring.hibernate.entity.Empleado;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao iEmpleadoDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void create(Empleado entidad) {
		iEmpleadoDao.create(entidad);
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Empleado obtieneEmpleado(long id) {
		return iEmpleadoDao.read(id);
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Empleado> readAll() {
		return iEmpleadoDao.readAll();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update(Empleado entidad) {
		iEmpleadoDao.update(entidad);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void delete(long id) {
		iEmpleadoDao.delete(id);
	}
}
