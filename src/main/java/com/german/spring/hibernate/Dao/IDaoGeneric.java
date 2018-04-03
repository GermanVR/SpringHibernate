package com.german.spring.hibernate.Dao;

import java.io.Serializable;
import java.util.List;

public interface IDaoGeneric<T, ID extends Serializable> {

	public void create(T entidad);

	public T read(ID id);

	public List<T> readAll();

	public void update(T entidad);

	public void delete(ID id);

}
