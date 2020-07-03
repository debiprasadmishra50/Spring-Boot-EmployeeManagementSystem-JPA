package demo.springcrud.crudapp.service;

import java.util.List;

import demo.springcrud.crudapp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
}
