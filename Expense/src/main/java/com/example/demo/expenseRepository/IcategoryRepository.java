package com.example.demo.expenseRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.expenseModel.Category;

public interface IcategoryRepository extends CrudRepository <Category, Long>{
	
	Category findByCategoryName(String name);

}
