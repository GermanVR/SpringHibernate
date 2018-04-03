package com.german.spring.hibernate.Dao.Implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.german.spring.hibernate.Dao.IEmpleadoDao;
import com.german.spring.hibernate.entity.Empleado;

@Repository
public class EmpleadoDaoImp implements IEmpleadoDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* Se obtiene la sesión actual de hibernate */
	public Session sf() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void create(Empleado entidad) {
		sf().beginTransaction();
		sf().save(entidad);
		sf().getTransaction().commit();
	}

	@Override
	public Empleado read(Long id) {
		return (Empleado) sf().get(Empleado.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> readAll() {
		return (List<Empleado>) sf().createQuery("From Empleado").list();
	}

	@Override
	public void update(Empleado entidad) {
		sf().update(entidad);
	}

	@Override
	public void delete(Long id) {
		sf().delete(id);
	}

}
