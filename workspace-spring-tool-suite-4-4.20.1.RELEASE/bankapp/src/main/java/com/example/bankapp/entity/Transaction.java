package com.example.bankapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// Transaction.java
	@Entity
	public class Transaction {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Double amount;
	    private LocalDateTime timestamp;
	    @ManyToOne
	    private Account account;
	    // other fields, getters, setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public Transaction(Long id, Double amount, LocalDateTime timestamp, Account account) {
			super();
			this.id = id;
			this.amount = amount;
			this.timestamp = timestamp;
			this.account = account;
		}
		public Transaction() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Transaction [id=" + id + ", amount=" + amount + ", timestamp=" + timestamp + ", account=" + account
					+ "]";
		}
	
	    
}
