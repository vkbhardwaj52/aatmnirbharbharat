package com.vivek.myrestapifinal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.myrestapifinal.model.ItemProfile;
import com.vivek.myrestapifinal.repository.ItemProfileRepository;

@Service
public class ItemProfileDAO {
	
	private static EntityManagerFactory entityManagerFactory =
	          Persistence.createEntityManagerFactory("example-unit");
	
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
	
	/*
	//Search all item
	public List<ItemProfile> findAllWithConditions(String subCategoriesId)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
	      Query query = em.createQuery("SELECT e FROM item_profile e WHERE e.sub_categories_id = :subCategoriesId");
	      query.setParameter("subCategoriesId", subCategoriesId);
	      List<ItemProfile> resultList = query.getResultList();
	      em.close();
	      return resultList;
	}
	*/
	
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
