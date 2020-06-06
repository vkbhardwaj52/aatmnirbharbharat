package com.vivek.myrestapifinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.myrestapifinal.dao.CategoriesDAO;
import com.vivek.myrestapifinal.model.Categories;

@RestController
//@RequestMapping("/company")
public class CategoriesController {
	
	@Autowired
	CategoriesDAO employeeDAO;
	
	
	//To save an employee
	@PostMapping("/categories")
	public Employee createEmployee(@Valid @RequestBody Categories emp)
	{
		return employeeDAO.save(emp);
	}
	
	//To get all employee
	@GetMapping("/categories")
	public List<Categories> getAllEmployees()
	{
		return employeeDAO.findAll();
	}
	
	//To get employee by id
	@GetMapping("/categories/{id}")
	public ResponseEntity<Categories> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Categories emp=employeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
}
	
	
	
	
	
