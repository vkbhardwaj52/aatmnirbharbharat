package com.vivek.myrestapifinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.myrestapifinal.model.ItemProfile;
import com.vivek.myrestapifinal.repository.ItemProfileRepository;

@Service
public class ItemProfileDAO {
	
	@Autowired
	ItemProfileRepository itemProfileRepository;
	
	
	//Save an item	
	public ItemProfile save(ItemProfile item)
	{
		return itemProfileRepository.save(item);
	}
	
	
	//Search all item
	public List<ItemProfile> findAll()
	{
		return itemProfileRepository.findAll();
	}
	
	
	//Get an item
	public ItemProfile findOne(Long itemId)
	{
		return itemProfileRepository.findOne(itemId);
	}
	
	
	//delete an item
	public void delete(ItemProfile item)
	{
		itemProfileRepository.delete(item);
	}

}
