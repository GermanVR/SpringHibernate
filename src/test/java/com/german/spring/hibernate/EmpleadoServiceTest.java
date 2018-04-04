package com.german.spring.hibernate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.german.spring.hibernate.Dao.IEmpleadoDao;
import com.german.spring.hibernate.entity.Empleado;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/spring/practica27/orm-hibernate4-application-context.xml")
@ContextConfiguration(locations = "classpath:/webapp/WEB-INF/hibernate.xml")
@Transactional
@Rollback(false)
//@ActiveProfiles("h2-in-memory")
public class EmpleadoServiceTest {

	@Autowired
	private IEmpleadoDao empleadoDao;

	@Before
	public void setUp() {
		Assert.assertNotNull(empleadoDao);
	}

	@Test
	public void createCustomerTest() {
		log.info("createCustomerTest -------------------");

		Empleado empleado = Empleado.builder().nombre("german").apellidoM("renteria").apellidoP("vazquez").edad(24)
				.sexo("M").build();

		empleadoDao.create(empleado);

		log.info("newCustomer : {} {}", empleado, System.identityHashCode(empleado));

		Empleado customer = empleadoDao.read(empleado.getId());

		Assert.assertEquals(customer, empleado);

		log.info("customer : {} {}", customer, System.identityHashCode(customer));

		
	}

//	@SuppressWarnings("unchecked")
//	@Test
//	public void updateCustomerTest() {
//		log.info("updateCustomerTest -------------------");
//
//		User newUser = User.builder().username("laura123").password("123123").build();
//
//		Customer newCustomer = Customer.builder().name("Laura").lastName("Montes").user(newUser).build();
//
//		newUser.setCustomer(newCustomer);
//
//		empleadoDao.insert(newCustomer);
//
//		log.info("newCustomer : {} {}", newCustomer, System.identityHashCode(newCustomer));
//
//		((IHibernateExtraOperationsDAO<Customer, Long>) empleadoDao).detach(newCustomer);
//
//		log.info("newCustomer (detached) : {} {}", newCustomer, System.identityHashCode(newCustomer));
//
//		Customer customer = empleadoDao.findById(newCustomer.getId());
//
//		Assert.assertEquals(customer, newCustomer);
//
//		log.info("customer : {} {}", customer, System.identityHashCode(customer));
//
//		customer.setName("Laura Valeria");
//		customer.setLastName("Manrique");
//
//		customer.getUser().setUsername("lauravaleria123");
//		customer.getUser().setPassword("123456789");
//
//		empleadoDao.update(customer);
//
//		log.info("customer (modified) : {} {}", customer, System.identityHashCode(customer));
//
//		Customer modifiedCustomer = empleadoDao.findById(customer.getId());
//
//		Assert.assertEquals(modifiedCustomer, customer);
//
//		log.info("modifiedCustomer : {} {}", modifiedCustomer, System.identityHashCode(modifiedCustomer));
//
//		User user = empleadoDao.findById(modifiedCustomer.getUser().getId());
//
//		Assert.assertEquals(user, modifiedCustomer.getUser());
//
//		log.info("user : {} {}", user, System.identityHashCode(user));
//	}

//	@SuppressWarnings("unchecked")
//	@Test
//	public void deleteCustomerTest() {
//		log.info("deleteCustomerTest -------------------");
//
//		User newUser = User.builder().username("laura123").password("123123").build();
//
//		Customer newCustomer = Customer.builder().name("Laura").lastName("Montes").user(newUser).build();
//
//		newUser.setCustomer(newCustomer);
//
//		empleadoDao.insert(newCustomer);
//
//		log.info("newCustomer : {} {}", newCustomer, System.identityHashCode(newCustomer));
//
//		((IHibernateExtraOperationsDAO<Customer, Long>) empleadoDao).detach(newCustomer);
//
//		log.info("newCustomer (detached) : {} {}", newCustomer, System.identityHashCode(newCustomer));
//
//		Customer customer = empleadoDao.findById(newCustomer.getId());
//
//		Assert.assertEquals(customer, newCustomer);
//
//		log.info("customer : {} {}", customer, System.identityHashCode(customer));
//
//		empleadoDao.delete(customer);
//
//		log.info("customer (deleted) : {} {}", customer, System.identityHashCode(customer));
//
//		Customer deletedCustomer = empleadoDao.findById(customer.getId());
//
//		Assert.assertNull(deletedCustomer);
//
//		log.info("deletedCustomer : {} {}", deletedCustomer, System.identityHashCode(deletedCustomer));
//
//		User user = empleadoDao.findById(customer.getUser().getId());
//
//		Assert.assertNull(user);
//
//		log.info("user : {} {}", user, System.identityHashCode(user));
//	}
}