package com.laura.videogameadmin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laura.videogameadmin.model.Customer;
import com.laura.videogameadmin.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping(path = "/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(path = "/getCustomers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping(path = "/getCustomersFrequent")
	public List<Map<String,Object>> getCustomersFrequent() {
		return customerService.getCustomersFrequent();
	}
	
	@GetMapping(path = "/getLoansByCustomer/{identification}")
	public List<Map<String, Object>> getLoansByCustomer(@PathVariable String identification) {
		return customerService.getLoansByCustomer(identification); 
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<Customer> save(@RequestBody Customer customer){
		customerService.save(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id); 
	}

}
