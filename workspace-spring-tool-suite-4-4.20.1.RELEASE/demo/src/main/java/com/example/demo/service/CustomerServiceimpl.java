package com.example.demo.service;


import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
@Service
public class CustomerServiceimpl implements CustomerService {

	
	
	@Autowired
	private CustomerRepository customerRepository;
	
 /*    List<Customer>list;
	
	public CustomerServiceimpl(){
		
		list=new ArrayList<>();
		
		list.add(new Customer(1,"rahul","patil","M","pune","maha","525203",10000.0,"4651365"));
	}*/

		
	@Override
	public void createcustomer(Customer customer) {
		
		this.customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getcustomer() {
		List<Customer> list = this.customerRepository.findAll();
		return list;
	}

	@Override
	public Customer getcustomerbyid(String cust_id) {
		  Customer c = customerRepository.findById( Long.parseLong(cust_id)).orElse(null);
		return c;
		
	}

	@Override
	public void deletecustomer() {
		
		customerRepository.deleteAll();
		
	}

	@Override
	public Customer updatecustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	
	

}
