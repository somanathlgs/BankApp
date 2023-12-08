package com.example.bankapp.service;

import java.util.List;

import com.example.bankapp.entity.Customer;

public interface CustomerService {

		List<Customer> getAllCustomers();

		Customer getCustomerById(Long customerId);

	    Customer createCustomer(Customer customer);

	    Customer updateCustomer(Long customerId, Customer updatedCustomer);

	    boolean deleteCustomer(Long customerId);
	


}
