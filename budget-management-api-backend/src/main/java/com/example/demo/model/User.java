package com.example.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import java.util.Arrays; 

@Component
public class User {
	@Id
	public ObjectId _id;
	private String name;
	//private double overallBudget;
	Map<String, List<Transaction> > transactions;
	Map<String, Double> monthlyBudget;
	public static Map<String, List<String> > categories = new HashMap<String, List<String>>();
	static{
		categories.put("Utilities", Arrays.asList("Cellphone", "Gas", "Electricity", "Internet", "Water"));
		categories.put("Home/Rent", Arrays.asList("Mortgage"));
		categories.put("Entertainment", Arrays.asList("Movies", "Restaurants", "Games"));
		categories.put("Insurance", Arrays.asList("Medical", "Vehice"));
	}
	
	public User() {
		
	}
	
	public User(String name)
	{
		this.name = name;
	}
	public User(ObjectId _id, String name, Map<String, List<Transaction>> transactions,
			Map<String, Double> monthlyBudget) {
		//super();
		this._id = _id;
		this.name = name;
		this.transactions = transactions;
		this.monthlyBudget = monthlyBudget;
	}
	public String get_id() { return _id.toHexString(); }
	
	public void set_id(ObjectId _id) { this._id = _id; }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public double getOverallBudget() {
//		return overallBudget;
//	}
//	public void setOverallBudget(double overallBudget) {
//		this.overallBudget = overallBudget;
//	}
	public Map<String, List<Transaction>> getTransactions() {
		return transactions;
	}
	public void setTransactions(Map<String, List<Transaction>> transactions) {
		this.transactions = transactions;
	}
	public Map<String, Double> getMonthlyBudget() {
		return monthlyBudget;
	}
	public void setMonthlyBudget(Map<String, Double> monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}
	
	
}
