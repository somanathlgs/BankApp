package com.example.bankapp.service;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.bankapp.entity.Customer;
import com.example.bankapp.repository.CustomerRepository;

import java.util.List;
	import java.util.Optional;

	@Service
	public class CustomerServiceimpl implements CustomerService {

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    @Override
	    public Customer getCustomerById(Long customerId) {
	        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
	        return optionalCustomer.orElse(null);
	    }

	    @Override
	    public Customer createCustomer(Customer customer) {
	        // You might want to add validation logic here before saving to the database
	        return customerRepository.save(customer);
	    }

	    @Override
	    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
	        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
	        if (optionalCustomer.isPresent()) {
	            Customer existingCustomer = optionalCustomer.get();
	            // Update the fields you want to allow updating
	            existingCustomer.setName(updatedCustomer.getName());
	            // Add more fields as needed
	            return customerRepository.save(existingCustomer);
	        } else {
	            return null; // Customer not found
	        }
	    }

	    @Override
	    public boolean deleteCustomer(Long customerId) {
	        if (customerRepository.existsById(customerId)) {
	            customerRepository.deleteById(customerId);
	            return true;
	        } else {
	            return false; // Customer not found
	        }
	    }
	}



