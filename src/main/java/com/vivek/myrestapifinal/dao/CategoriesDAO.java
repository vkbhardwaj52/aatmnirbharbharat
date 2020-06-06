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
	
	
	//Save an employee	
	public Categories save(Categories emp)
	{
		return categoriesRepository.save(emp);
	}
	
	
	//Search all employee
	public List<Categories> findAll()
	{
		return categoriesRepository.findAll();
	}
	
	
	//Get an employee
	public Categories findOne(Long empid)
	{
		return categoriesRepository.findOne(empid);
	}
	
	
	//delete an employee
	public void delete(Categories emp)
	{
		categoriesRepository.delete(emp);
	}

}
