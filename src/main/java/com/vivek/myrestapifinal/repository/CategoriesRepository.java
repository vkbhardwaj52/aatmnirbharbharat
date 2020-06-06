package com.vivek.myrestapifinal.repository;

import com.vivek.myrestapifinal.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long>{

}
