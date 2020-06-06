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
import org.springframework.web.bind.annotation.RestController;

import com.vivek.myrestapifinal.dao.CategoriesDAO;
import com.vivek.myrestapifinal.model.Categories;

@RestController
//@RequestMapping("/company")
public class CategoriesController {
	
	@Autowired
	CategoriesDAO categoriesDAO;
	
	
	//To save an employee
	@PostMapping("/categories")
	public Categories createEmployee(@Valid @RequestBody Categories emp)
	{
		return categoriesDAO.save(emp);
	}
	
	//To get all employee
	@GetMapping("/getAllCategories")
	public List<Categories> getAllCategories()
	{
		return categoriesDAO.findAll();
	}
	
	
	//To get all employee
	@GetMapping("/test")
	public String getTestData()
	{
		return "Test Success";
	}
	
	//To get employee by id
	@GetMapping("/getCategoriesById/id/{id}")
	public ResponseEntity<Categories> getEmployeeById(@PathVariable(value="id") String id){
		
		Long categoriesId = Long.parseLong(id);
		Categories emp=categoriesDAO.findOne(categoriesId);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/categories/{id}")
	public ResponseEntity<Categories> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Categories empDetails){
		
		Categories emp=categoriesDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setCategoriesDesc(empDetails.getCategoriesDesc());		
		Categories updateEmployee=categoriesDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Categories> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Categories emp=categoriesDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		categoriesDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}

}
