package com.german.spring.hibernate.Service;

import java.util.List;

public interface IEmpleadoService<T, ID> {

	public void create(T entidad);

	public T obtieneEmpleado(ID id);

	public List<T> readAll();

	public void update(T entidad);

	public void delete(ID id);

}
