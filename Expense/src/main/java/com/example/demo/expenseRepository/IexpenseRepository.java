package com.example.demo.expenseRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.expenseModel.Expense;

public interface IexpenseRepository extends JpaRepository<Expense, Long> {

}
