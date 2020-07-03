package demo.springcrud.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import demo.springcrud.crudapp.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager; 
	
	// Either use this field injection or make it constructor injection
//	@Autowired
//	public EmployeeDAOJPAImpl(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query query = entityManager.createQuery("from Employee");
		
		// execute the query and get a Result List
		List<Employee> employees = query.getResultList();
		
		// return the list
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// get Employee
		Employee employee = entityManager.find(Employee.class, id);
		// return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// save or Update the Employee
		Employee theEmployee = entityManager.merge(employee);
		// if id is 0, they will insert, if not, it will do an update
		
		// updated id from db... so we can get generated id for save/insert
		employee.setId(theEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		
		//delete the object with primary key
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
















