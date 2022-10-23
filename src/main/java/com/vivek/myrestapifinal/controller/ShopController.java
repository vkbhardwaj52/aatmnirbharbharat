package com.vivek.myrestapifinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.myrestapifinal.dao.ShopDAO;
import com.vivek.myrestapifinal.model.Shop;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ShopDAO shopDAO;	
	
	//To get all shop
	@GetMapping("/getAllShop")
	public List<Shop> getAllShop()
	{
		return shopDAO.findAll(); 
	}	
	
	//Save an shop
	@PostMapping("/saveShop")
	public Shop saveShop(@Valid @RequestBody Shop emp)
	{
		return shopDAO.save(emp);
	}
	
	//Get categories by id
	@GetMapping("/getShopById/id/{id}")
	public ResponseEntity<Shop> getShopById(@PathVariable(value="id") String id){
		
		Long shopId = Long.parseLong(id);
		Shop shop=shopDAO.findOne(shopId);
		
		if(shop==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(shop);		
	}
	
	//Delete an shop by id
	@DeleteMapping("/deleteShopById/id/{id}")
	public ResponseEntity<Shop> deleteShopById(@PathVariable(value="id") String id){
		
		Long shopId = Long.parseLong(id);
		Shop shop=shopDAO.findOne(shopId);
		if(shop==null) {
			return ResponseEntity.notFound().build();
		}
		shopDAO.delete(shop);		
		return ResponseEntity.ok().build();		
	}
}