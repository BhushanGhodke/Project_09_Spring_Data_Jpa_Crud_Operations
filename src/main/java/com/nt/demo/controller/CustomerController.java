package com.nt.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.demo.entity.Customer;
import com.nt.demo.service.ICustomerService;


@RestController
public class CustomerController {
	
		
		@Autowired
		private ICustomerService service;
	
	   // Create an API for Save one Customer to DB
		@PostMapping("/save")
		public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
			
			Customer savedCustomer =service.saveCustomer(customer);
		
		     return ResponseEntity.ok().body(savedCustomer);
		}
		 
		
		//Create an API for save group of customer to DB
		@PostMapping("/saveAll")
		public ResponseEntity<Iterable<Customer>> saveGroupedCustomer(@RequestBody Iterable<Customer> customer){
		
			Iterable<Customer>  savedCustomer =service.saveGroupedCustomer(customer);
			
		     return ResponseEntity.ok().body(savedCustomer);
		
		}
		
		
		//Create an API to check customer is already available in DB or not
		@GetMapping("/getInfo/{id}")
		public String isCustomerAvaialble(@PathVariable Integer id){
			
			Boolean flag=service.isCustomerAvailable(id);
			System.out.println(flag);
		
		  if(flag==false) {
			 return "Customer with id = "+id +" is not avaiable";
			 
		  }else {
			  return "Customer with id = "+id +" is avaiable";
		  }
		}
		
		//Create and API for counting customer in DB table
		@GetMapping("/getCount")
		public String  customerCount() {
			
			long count =service.customerCount();
		
		         return "Customer count is "+count;
		}
		
		//Create an API to Show all customer present in DB table
		@GetMapping("/showAllCustomer")
		public ResponseEntity<List<Customer>> showAllCustomer(){
			
			List<Customer> cust= (List<Customer>) service.findAllCustomer();
			
			return ResponseEntity.ok().body(cust);
		}
		
		
		/*@GetMapping("/getAllCustomer/{ids}")
		public ResponseEntity<Customer> findAllCustomerById(@PathVariable Iterable<Integer> ids ){
			
			 
		Customer customer=	(Customer) service.findAllCustomerById(ids);
		
		return ResponseEntity.ok().body(customer);
		}*/
	
		//Create an API for getting customer by using id (Optional)
		@GetMapping("/getCustomerById/{id}")
		public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Integer id){
			
			Optional<Customer> customer= service.findById(id);
		
			return ResponseEntity.ok().body(customer);
		}
		
		//Create an API for Updating customer in DB

		@PutMapping("/update/{id}")
		public ResponseEntity<String> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
		
			Optional<Customer> cust= service.findById(id);
			
			if(cust.isPresent()) {
				Customer cust1= cust.get();	
				cust1.setCname(customer.getCname());
				cust1.setCaddrs(customer.getCaddrs());
				cust1.setBillamt(customer.getBillamt());
				
				service.saveCustomer(cust1);
				
				return ResponseEntity.ok().body(cust1.toString());
				
			}
			else {
			   return ResponseEntity.ok().body("Customer not Found");
			}
			
		}
		
		
		//create an API for Delete the single customer from DB table
		@DeleteMapping("/Delete/{id}")
		public ResponseEntity<String> DeleteCustomer(@PathVariable Integer id ){
			
			if(service.isCustomerAvailable(id)) {
				service.DeleteCustomer(id);
				return  ResponseEntity.ok().body( "Customer is Deleted with id "+ id);
								
			}else {
				return ResponseEntity.ok().body("Customer Not Found with id = "+id);
			}
			
			}
}
