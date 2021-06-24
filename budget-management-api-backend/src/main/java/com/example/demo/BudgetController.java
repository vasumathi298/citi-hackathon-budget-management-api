package com.example.demo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.model.User;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@RestController
@RequestMapping("/users")
public class BudgetController {
	@Autowired
	private UserRepository repository;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
	  return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") ObjectId id) {
	  return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User User) {
	  User.set_id(id);
	  repository.save(User);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User User) {
	  User.set_id(ObjectId.get());
	  User.setTransactions(new HashMap<String, List<Transaction>>());
	  repository.save(User);
	  return User;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable ObjectId id) {
	  repository.delete(repository.findBy_id(id));
	}
	
	@RequestMapping(value = "/{id}/updateMonthlyBudget", method = RequestMethod.PUT)
	public User setMonthlyBudget(@PathVariable ObjectId id, @RequestBody Map<String, Double> monthlyBudget) {
		User user = repository.findBy_id(id);
		user.setMonthlyBudget(monthlyBudget);
		repository.save(user);
		return user;
	}
	
	@RequestMapping(value = "/{id}/addTransaction", method = RequestMethod.PUT)
	public User addTransaction(@PathVariable ObjectId id, @RequestBody Transaction transaction ) {
		User user = repository.findBy_id(id);
		Map<String, List<String> > categories = user.categories;
		for (Map.Entry<String,List<String>> entry : categories.entrySet()) 
		{
			List<String> subcategories = entry.getValue();
			for(String s: subcategories)
			{
				if(s.equals(transaction.getName()))
				{
					String category = entry.getKey();
					Map<String, List<Transaction>> transactions = user.getTransactions();
					
					if(!transactions.containsKey(category))
					{
						List<Transaction> ls = new ArrayList<>();
						ls.add(transaction);
						transactions.put(category, ls);
						user.setTransactions(transactions);
						repository.save(user);
					}
					else {
						List<Transaction> list = transactions.get(category);
						list.add(transaction);
						transactions.put(category, list);
						user.setTransactions(transactions);
						repository.save(user);
					}
				}
			}
		}
		return user;
	}
	
	@RequestMapping(value = "/{id}/addCategory", method = RequestMethod.PUT)
	public void addCategory(@PathVariable ObjectId id, @RequestParam String category, @RequestBody List subcategories) {
		User user = repository.findBy_id(id);
		user.categories.put(category, subcategories);
		repository.save(user);
	}	
	
	@RequestMapping(value = "/{id}/expenditure", method = RequestMethod.GET)
	public ResponseEntity<Object> getExpenditure(@PathVariable ObjectId id) {
		User user = repository.findBy_id(id);
		String str = "Category\tExpense\t   Monthly Budget\n";
		Map<String, Double> monthlyBudget = user.getMonthlyBudget();
		Map<String, List<Transaction>> transactions = user.getTransactions();
		double total = 0.0, totalBudget = 0.0;
		for (Map.Entry<String,Double> entry : monthlyBudget.entrySet()) 
		{
			String category = entry.getKey();
			double budget  = entry.getValue();
			totalBudget += budget;
			List<Transaction> trans = transactions.get(category);
			double sum = 0.0;
			for(Transaction t : trans)
			{
				sum += t.getExpense();
			}
			total+=sum;
			str+=category+"\t"+sum+"\t    "+budget+"\n";
		}
		str+="\nOverall budget = "+totalBudget;
		str+="\nTotal Expenditure = "+total;
		if(total > totalBudget)
		{
			str+="\nYou have exceeded your monthly budget limit!";
		}
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
}
