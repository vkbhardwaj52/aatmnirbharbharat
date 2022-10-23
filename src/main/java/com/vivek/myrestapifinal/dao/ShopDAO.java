package com.vivek.myrestapifinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.myrestapifinal.model.Shop;
import com.vivek.myrestapifinal.repository.ShopRepository;

@Service
public class ShopDAO {
	
	@Autowired
	ShopRepository shopRepository;
	
	
	//Save an categories	
	public Shop save(Shop shop)
	{
		return shopRepository.save(shop);
	}
	
	
	//Search all categories
	public List<Shop> findAll()
	{
		return shopRepository.findAll();
	}
	
	
	//Get an categories
	public Shop findOne(Long shopId)
	{
		return shopRepository.findOne(shopId);
	}
	
	
	//delete an categories
	public void delete(Shop shop)
	{
		shopRepository.delete(shop);
	}

}
