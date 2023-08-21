package com.nt.demo.service;

import java.util.Optional;

import com.nt.demo.entity.Customer;

public interface ICustomerService {

	//save only one customer
	public Customer saveCustomer(Customer customer);
	
	//save the group of customer
	public Iterable<Customer> saveGroupedCustomer(Iterable<Customer> customer);
	
	//check whether customer is available or not
	public boolean isCustomerAvailable(Integer id);
	
	//For counting no.of customer in DB
	public long customerCount();
	
	//For showing all customer
	public Iterable<Customer> findAllCustomer();
	
	//get all customer by using ids
	//public Iterable<Customer> findAllCustomerById(Iterable<Integer> ids);
	
	//For finding the customer by using the Ids
	public Optional<Customer> findById(Integer id);
	
    //For Deleting a Single customer
	public void DeleteCustomer(Integer id);
	
	
}
