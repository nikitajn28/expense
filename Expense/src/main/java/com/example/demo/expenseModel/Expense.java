package com.example.demo.expenseModel;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="expense")
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

	@Id
	private Long id;
	
	private String description;
	private String date;
	private String location;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", description=" + description + ", date=" + date + ", location=" + location
				+ ", category=" + category + ", user=" + user + "]";
	}

	@ManyToOne
	private Category category;
	
	@ManyToOne
	private  User user;
	
	
	
	
}
