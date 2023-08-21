package com.nt.demo.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.nt.demo.dao.CustomerRepository;
import com.nt.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
     private CustomerRepository custRepo;
     
	
	@Override
	public Customer saveCustomer(Customer customer) {
		
		return custRepo.save(customer);
	}


	@Override
	public Iterable<Customer> saveGroupedCustomer(Iterable<Customer> customer) {
		
		return custRepo.saveAll(customer);
	}


	@Override
	public boolean isCustomerAvailable(Integer id) {
		
		Boolean flag= custRepo.existsById(id);
	
		return flag;
	}


	@Override
	public long customerCount() {
		
		return custRepo.count();
	}


	@Override
	public Iterable<Customer> findAllCustomer() {
		
		
		return custRepo.findAll();
	}


	

	@Override
	public Optional<Customer> findById(Integer id) {
		
		return  custRepo.findById(id);
		
	}


	@Override
	public void DeleteCustomer(Integer id) {
		
		 custRepo.deleteById(id);
	}



	


	/*@Override
	public Iterable<Customer> findAllCustomerById(Iterable<Integer> ids) {
		
		return custRepo.findAllById(ids);
	}*/



	


	
}
