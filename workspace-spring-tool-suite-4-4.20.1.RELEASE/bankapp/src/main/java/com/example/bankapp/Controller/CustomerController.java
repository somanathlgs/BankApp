package com.example.bankapp.Controller;

	
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.http.HttpStatus;
		import org.springframework.http.ResponseEntity;
		import org.springframework.web.bind.annotation.*;

import com.example.bankapp.entity.Customer;
import com.example.bankapp.service.CustomerService;

import java.util.List;

		@RestController
		@RequestMapping("/api/customers")
		public class CustomerController {

		    @Autowired
		    private CustomerService customerService;

		    // Endpoint to get all customers
		    @GetMapping
		    public ResponseEntity<List<Customer>> getAllCustomers() {
		        List<Customer> customers = customerService.getAllCustomers();
		        return new ResponseEntity<>(customers, HttpStatus.OK);
		    }

		    // Endpoint to get a customer by ID
		    @GetMapping("/{customerId}")
		    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
		        Customer customer = customerService.getCustomerById(customerId);
		        if (customer != null) {
		            return new ResponseEntity<>(customer, HttpStatus.OK);
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		    }

		    // Endpoint to create a new customer
		    @PostMapping
		    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		        Customer createdCustomer = customerService.createCustomer(customer);
		        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
		    }

		    // Endpoint to update an existing customer
		    @PutMapping("/{customerId}")
		    public ResponseEntity<Customer> updateCustomer(
		            @PathVariable Long customerId,
		            @RequestBody Customer updatedCustomer) {
		        Customer customer = customerService.updateCustomer(customerId, updatedCustomer);
		        if (customer != null) {
		            return new ResponseEntity<>(customer, HttpStatus.OK);
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		    }

		    // Endpoint to delete a customer by ID
		    @DeleteMapping("/{customerId}")
		    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
		        boolean deleted = customerService.deleteCustomer(customerId);
		        if (deleted) {
		            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		        }
		    }
}
