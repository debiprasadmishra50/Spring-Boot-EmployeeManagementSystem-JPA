package demo.springcrud.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import demo.springcrud.crudapp.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define fields for EntityManager
	@Autowired
	private EntityManager entityManager;
	
	// set up constructor injection or use the field injection
//	@Autowired
//	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
	
	@Override
//	@Transactional // org.springframework.transaction.annotation.Transactional // Remove, because we have a service layer to do the transaction
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class); //org.hibernate.Session
		
		// create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class); //org.hibernate.query.Query;
		
		// execute the query
		List<Employee> employees = query.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {

		// get the Hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee = session.get(Employee.class, id);
		
		// return the desired employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// get the current session
		Session session = entityManager.unwrap(Session.class);
		
		// save the employee
		session.saveOrUpdate(employee); // If the primary key of ID is 0, it will do an insert, else it will do an update
	}

	@Override
	public void deleteById(int id) {
		// get the current session
		Session session = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
















