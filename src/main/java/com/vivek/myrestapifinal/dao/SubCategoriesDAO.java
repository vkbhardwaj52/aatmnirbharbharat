package com.vivek.myrestapifinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.myrestapifinal.model.SubCategories;
import com.vivek.myrestapifinal.repository.SubCategoriesRepository;

@Service
public class SubCategoriesDAO {
	
	@Autowired
	SubCategoriesRepository subCategoriesRepository;	
	
	//Save an categories	
	public SubCategories save(SubCategories subCategories)
	{
		return subCategoriesRepository.save(subCategories);
	}	
	
	//Search all categories
	public List<SubCategories> findAll()
	{
		return subCategoriesRepository.findAll();
	}
	
	//Get an categories
	public SubCategories findOne(Long SubCategoriesId)
	{
		return subCategoriesRepository.findOne(SubCategoriesId);
	}	
	
	//delete an categories
	public void delete(SubCategories SubCategoriesId)
	{
		subCategoriesRepository.delete(SubCategoriesId);
	}

}
