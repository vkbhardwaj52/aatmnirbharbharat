package com.vivek.myrestapifinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.myrestapifinal.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories,Long>{

}
