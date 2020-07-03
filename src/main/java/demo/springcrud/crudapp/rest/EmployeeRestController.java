package demo.springcrud.crudapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springcrud.crudapp.entity.Employee;
import demo.springcrud.crudapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService; // either use field injection or constructor injection
	
//	@Autowired
//	public EmployeeRestController(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}

	// expose the "/employees" : return all the employees,  method : GET
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}") 
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null){
			throw new RuntimeException("Employee id not found : "+employeeId);
		}
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		// also just in case they pass id in JSON... set id to 0
		// this is to force save of a new item... insert instead of update
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	// add mapping for PUT /employees -
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	// add mapping for DELETE /employees/{employeeId} - Delete an existing employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		// throw Exception if employee is null or doesn't exist
		if(theEmployee == null) {
			throw new RuntimeException("Employee Doesn't exist with id "+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		return "Deleted Employee with id : "+employeeId;
	}
	
}










