package com.example.demo.model;

public class Transaction {
	private String name;
	private double expense;
	public Transaction(String name, double expense) {
		super();
		this.name = name;
		this.expense = expense;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	
}
