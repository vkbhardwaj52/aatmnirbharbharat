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
import org.springframework.web.bind.annotation.RequestMapping;

import com.vivek.myrestapifinal.dao.CategoriesDAO;
import com.vivek.myrestapifinal.model.Categories;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	CategoriesDAO categoriesDAO;	
	
	//To get all categories
	@GetMapping("/getAllCategories")
	public List<Categories> getAllCategories()
	{
		return categoriesDAO.findAll();
	}	
	
	//Get categories by id
	@GetMapping("/getCategoriesById/id/{id}")
	public ResponseEntity<Categories> getEmployeeById(@PathVariable(value="id") String id){
		
		Long categoriesId = Long.parseLong(id);
		Categories cat=categoriesDAO.findOne(categoriesId);
		
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cat);		
	}
	
	//Save an categories
	@PostMapping("/saveCategories")
	public Categories createEmployee(@Valid @RequestBody Categories emp)
	{
		return categoriesDAO.save(emp);
	}	
	
	/*Update an categories by id*/
	@PutMapping("/updateCategoriesById/id/{id}")
	public ResponseEntity<Categories> updateEmployee(@PathVariable(value="id") String id,@Valid @RequestBody Categories categories){
		
		Long categoriesId = Long.parseLong(id);
		Categories cat=categoriesDAO.findOne(categoriesId);
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}		
		cat.setCategoriesDesc(categories.getCategoriesDesc());		
		Categories updateEmployee=categoriesDAO.save(cat);
		return ResponseEntity.ok().body(updateEmployee);		
	}
	
	/*Delete an categories by id*/
	@DeleteMapping("/deleteCategoriesById/id/{id}")
	public ResponseEntity<Categories> deleteEmployee(@PathVariable(value="id") String id){
		
		Long categoriesId = Long.parseLong(id);
		Categories cat=categoriesDAO.findOne(categoriesId);
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		categoriesDAO.delete(cat);		
		return ResponseEntity.ok().build();		
	}

}
