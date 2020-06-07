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

import com.vivek.myrestapifinal.dao.ItemProfileDAO;
import com.vivek.myrestapifinal.model.ItemProfile;

@RestController
@RequestMapping("/item")
public class ItemProfileController {
	
	@Autowired
	ItemProfileDAO itemProfileDAO;	
	
	//To get all item
	@GetMapping("/getAllItems")
	public List<ItemProfile> getAllCategories()
	{
		return itemProfileDAO.findAll();
	}	
	
	//Get item by id
	@GetMapping("/getItemById/id/{id}")
	public ResponseEntity<ItemProfile> getEmployeeById(@PathVariable(value="id") String id){
		
		Long itemId = Long.parseLong(id);
		ItemProfile item=itemProfileDAO.findOne(itemId);
		
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(item);		
	}
	
	//Get item by id
	@GetMapping("/getItemBySubCategoriesId/subCategoriesId/{id}")
	public List<ItemProfile> getItemBySubCategoriesId(@PathVariable(value="id") String id){
		
		
		return itemProfileDAO.findAllWithConditions(id);
	}
	
	//Save an item
	@PostMapping("/saveItem")
	public ItemProfile createEmployee(@Valid @RequestBody ItemProfile emp)
	{
		return itemProfileDAO.save(emp);
	}	
	
	/*Update an item by id*/
	@PutMapping("/updateItemById/id/{id}")
	public ResponseEntity<ItemProfile> updateEmployee(@PathVariable(value="id") String id,@Valid @RequestBody ItemProfile item){
		
		Long itemId = Long.parseLong(id);
		ItemProfile itemProfile=itemProfileDAO.findOne(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}		
		item.setItemShortDesc(item.getItemShortDesc());
		item.setItemLongDesc(item.getItemLongDesc());
		item.setItemPrice(item.getItemPrice());
		item.setItemCoo(item.getItemCoo());
		item.setItemImage(item.getItemImage());
		item.setSubCategoriesId(item.getSubCategoriesId());
		ItemProfile updateEmployee=itemProfileDAO.save(itemProfile);
		return ResponseEntity.ok().body(updateEmployee);		
	}
	
	/*Delete an item by id*/
	@DeleteMapping("/deleteCategoriesById/id/{id}")
	public ResponseEntity<ItemProfile> deleteEmployee(@PathVariable(value="id") String id){
		
		Long itemId = Long.parseLong(id);
		ItemProfile item=itemProfileDAO.findOne(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		itemProfileDAO.delete(item);		
		return ResponseEntity.ok().build();		
	}

}
