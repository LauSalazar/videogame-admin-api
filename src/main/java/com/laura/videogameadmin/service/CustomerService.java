package com.laura.videogameadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.videogameadmin.model.Customer;
import com.laura.videogameadmin.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getCustomers(){
		return customerRepository.getCustomers();
	}

	public List<Map<String, Object>> getCustomersFrequent() {
		return customerRepository.getCustomersFrequent();
	}

	public List<Map<String, Object>> getLoansByCustomer(String identification) {
		return customerRepository.getLoansByCustomer(identification);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	public Customer getCustomerById(Long id) {
		return customerRepository.getCustomerById(id);
	}
}
