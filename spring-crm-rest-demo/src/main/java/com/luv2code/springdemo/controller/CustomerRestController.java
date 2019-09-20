package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//autowire the customer service
	@Autowired
	private CustomerService customerService;
	
	//add mapping for GET/customers
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		
		
		return customerService.getCustomers();
		
	}
	
	//add mapping to GET single customer
	
	@GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			
			throw new CustomerNotFoundException("Customer Id not Found :"+customerId);
			
		}
		
		return theCustomer;
		
	}
	
	//add mapping to POST customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//also just incase , pass an id in json ... set id to 0
		
		//this force a save new customer
		
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		
		
		return theCustomer;
	}
	
	//add mapping for PUT /customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		System.out.println("Updating the customer :"+theCustomer.getFirstName());
		
		customerService.saveCustomer(theCustomer);
		
		
		
		return theCustomer;
	}
	
	//add mapping for DELETE /customers/{customerId} 
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		//throw exception if null
		if (tempCustomer == null) {
			
			throw new CustomerNotFoundException("Customer Id Not Found :"+customerId);
			
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id: "+customerId;
		
	}
	
}
