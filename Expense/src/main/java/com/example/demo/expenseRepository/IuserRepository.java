package com.example.demo.expenseRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.expenseModel.User;

public interface IuserRepository extends JpaRepository<User, Long>{

}
