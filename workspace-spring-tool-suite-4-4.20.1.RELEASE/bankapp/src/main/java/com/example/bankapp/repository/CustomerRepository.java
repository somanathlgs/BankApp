package com.example.bankapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
