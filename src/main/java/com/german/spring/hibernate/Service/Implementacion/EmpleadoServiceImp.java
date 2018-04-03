package com.german.spring.hibernate.Service.Implementacion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.german.spring.hibernate.Dao.IEmpleadoDao;
import com.german.spring.hibernate.Service.IEmpleadoService;
import com.german.spring.hibernate.entity.Empleado;

@Service
public class EmpleadoServiceImp implements IEmpleadoService<Empleado, Long> {

	@Autowired
	private IEmpleadoDao iEmpleadoDao;

	@Override
	@Transactional
	public void create(Empleado entidad) {
		iEmpleadoDao.create(entidad);
	}

	@Override
	public Empleado obtieneEmpleado(Long id) {
		return iEmpleadoDao.read(id);
	}

	@Override
	public List<Empleado> readAll() {
		return iEmpleadoDao.readAll();
	}

	@Override
	public void update(Empleado entidad) {
		iEmpleadoDao.update(entidad);
	}

	@Override
	public void delete(Long id) {
		iEmpleadoDao.delete(id);
	}
}
