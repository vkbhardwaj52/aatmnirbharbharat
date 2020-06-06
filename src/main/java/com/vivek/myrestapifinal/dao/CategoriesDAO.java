package com.vivek.myrestapifinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.myrestapifinal.model.Categories;
import com.vivek.myrestapifinal.repository.CategoriesRepository;

@Service
public class CategoriesDAO {
	
	@Autowired
	CategoriesRepository categoriesRepository;
	
	
	//Save an categories	
	public Categories save(Categories categories)
	{
		return categoriesRepository.save(categories);
	}
	
	
	//Search all categories
	public List<Categories> findAll()
	{
		return categoriesRepository.findAll();
	}
	
	
	//Get an categories
	public Categories findOne(Long categoriesId)
	{
		return categoriesRepository.findOne(categoriesId);
	}
	
	
	//delete an categories
	public void delete(Categories categories)
	{
		categoriesRepository.delete(categories);
	}

}
