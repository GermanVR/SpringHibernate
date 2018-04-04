package com.german.spring.hibernate.Service;

import java.util.List;

import com.german.spring.hibernate.entity.Empleado;

public interface IEmpleadoService {

	public void create(Empleado entidad);

	public Empleado obtieneEmpleado(long id);

	public List<Empleado> readAll();

	public void update(Empleado entidad);

	public void delete(long id);

}
