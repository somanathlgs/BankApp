package com.example.bankapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// Account.java

	@Entity
	public class Account {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String accountNumber;
	    private Double balance;
	    @ManyToOne
	    private Customer customer;
	    // other fields, getters, setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(Double balance) {
			this.balance = balance;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public Account(Long id, String accountNumber, Double balance, Customer customer) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.balance = balance;
			this.customer = customer;
		}
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", customer="
					+ customer + "]";
		}
	    
	    
	}



	



