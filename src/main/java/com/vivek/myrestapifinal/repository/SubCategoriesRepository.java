package com.vivek.myrestapifinal.repository;

import java.util.List;

import org.hibernate.annotations.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.myrestapifinal.model.SubCategories;

public interface SubCategoriesRepository extends JpaRepository<SubCategories,Long>{
	
	List<SubCategories> findByCateforiesId(Long categoriesId);

}
