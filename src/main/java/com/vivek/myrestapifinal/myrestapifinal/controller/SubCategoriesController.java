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

import com.vivek.myrestapifinal.dao.SubCategoriesDAO;
import com.vivek.myrestapifinal.model.SubCategories;

@RestController
@RequestMapping("/subcategories")
public class SubCategoriesController {
	
	@Autowired
	SubCategoriesDAO subCategoriesDAO;	
	
	//To get all categories
	@GetMapping("/getAllSubCategories")
	public List<SubCategories> getAllCategories()
	{
		return subCategoriesDAO.findAll();
	}	
	
	//Get categories by id
	@GetMapping("/getSubCategoriesById/id/{id}")
	public ResponseEntity<SubCategories> getEmployeeById(@PathVariable(value="id") String id){
		
		Long categoriesId = Long.parseLong(id);
		SubCategories cat=subCategoriesDAO.findOne(categoriesId);
		
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(cat);		
	}
	
	//Save an categories
	@PostMapping("/saveSubCategories")
	public SubCategories createEmployee(@Valid @RequestBody SubCategories emp)
	{
		return subCategoriesDAO.save(emp);
	}	
	
	/*Update an categories by id*/
	@PutMapping("/updateSubCategoriesById/id/{id}")
	public ResponseEntity<SubCategories> updateEmployee(@PathVariable(value="id") String id,@Valid @RequestBody SubCategories subCategories){
		
		Long categoriesId = Long.parseLong(id);
		SubCategories cat=subCategoriesDAO.findOne(categoriesId);
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}		
		cat.setSubCategoriesDesc(subCategories.getSubCategoriesDesc());		
		cat.setCategoriesId(subCategories.getCategoriesId());
		SubCategories updateEmployee=subCategoriesDAO.save(cat);
		return ResponseEntity.ok().body(updateEmployee);		
	}
	
	/*Delete an categories by id*/
	@DeleteMapping("/deleteSubCategoriesById/id/{id}")
	public ResponseEntity<SubCategories> deleteEmployee(@PathVariable(value="id") String id){
		
		Long subCategoriesId = Long.parseLong(id);
		SubCategories cat=subCategoriesDAO.findOne(subCategoriesId);
		if(cat==null) {
			return ResponseEntity.notFound().build();
		}
		subCategoriesDAO.delete(cat);		
		return ResponseEntity.ok().build();		
	}

}