package com.luv2code.springboot.thymeleafdemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	//we remove @Transactional
	

	@Override
	public List<Employee> findAll() {
		 
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		 
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null ;
		 if(result.isPresent())
			 employee = result.get();
		 else {
			 // we handle this in controller
			// throw new EmployeeNotFoundException("this employees with id = " + id + " not found");
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		 
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		 
		employeeRepository.deleteById(id);
	}

}
