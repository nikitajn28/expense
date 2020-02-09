package com.example.demo.expenseController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.expenseModel.Category;
import com.example.demo.expenseModel.Expense;
import com.example.demo.expenseRepository.IcategoryRepository;
import com.example.demo.expenseRepository.IexpenseRepository;
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private IcategoryRepository categoryRepository;
	
	@Autowired
	private IexpenseRepository expenseRepository;
	
     @GetMapping(value="/categories"  ,  produces="application/json")
    ResponseEntity<List<Category>> getCategories(){
    	List<Category> result=	(List<Category>) categoryRepository.findAll();
	    	return new ResponseEntity<List<Category>>(result, HttpStatus.OK);
	}
     
    @PostMapping(value="add/expense") 
    ResponseEntity addExpense(@Valid @RequestBody Expense expense) throws URISyntaxException{
    	Expense newExpense= expenseRepository.save(expense);
		return new ResponseEntity<>(HttpStatus.CREATED);
    	
    }
    @PutMapping(value="edit/expense/{id}")
    ResponseEntity editExpense(@Valid @PathVariable Long id, @RequestBody Expense expense ) {
    	if(expenseRepository.findById(id).isPresent()) {
    	 expenseRepository.save(expense);
		return new ResponseEntity (HttpStatus.OK);
    	}
    	else
    		return new ResponseEntity(HttpStatus.NOT_FOUND);
    	
    }
    @GetMapping(value="expenses")
    ResponseEntity<List<Expense>> getExpenses() {
    	List<Expense> allExpense =expenseRepository.findAll();
		return new ResponseEntity<List<Expense>> (allExpense, HttpStatus.OK );
    	
    }
    
    @DeleteMapping(value="delete/expense/{id}")
    ResponseEntity deleteExpense(@PathVariable Long id) {
    	expenseRepository.deleteById(id);
		return new ResponseEntity (HttpStatus.OK);
    	
    }
}
