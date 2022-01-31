package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

 

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	 @Autowired
	 EmployeeService employeeService;
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		
		// add to the spring model
		theModel.addAttribute("employees", employeeService.findAll());
		
		return "employees/list-employees";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormAddEmployee( Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	
	// update
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id ,Model model ) {
		model.addAttribute("employee", employeeService.findById(id));
		
		return "employees/employee-form";
	}
	
	
	@GetMapping("delete")
	public String delete(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	
}









