package demo.springcrud.crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.springcrud.crudapp.dao.EmployeeDAO;
import demo.springcrud.crudapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDAOJPAImpl")
	private EmployeeDAO employeeDAO; // Either Field injection or Constructor injection
	
//	@Autowired
//	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO employeeDAO) {
//		this.employeeDAO = employeeDAO;
//	}

	@Override
	@Transactional //org.springframework.transaction.annotation.Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional //org.springframework.transaction.annotation.Transactional
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional //org.springframework.transaction.annotation.Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional //org.springframework.transaction.annotation.Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
