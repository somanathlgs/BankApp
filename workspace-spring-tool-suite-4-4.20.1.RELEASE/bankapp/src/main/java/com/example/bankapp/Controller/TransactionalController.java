package com.example.bankapp.Controller;




	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.example.bankapp.entity.Transaction;
import com.example.bankapp.service.TransactionalService;

import java.util.List;

	@RestController
	@RequestMapping("/api/transactions")
	public class TransactionalController {
	    @Autowired
	    private TransactionalService transactionService;

	    // Endpoint to get all transactions
	    @GetMapping
	    public ResponseEntity<List<Transaction>> getAllTransactions() {
	        List<Transaction> transactions = transactionService.getAllTransactions();
	        return new ResponseEntity<>(transactions, HttpStatus.OK);
	    }

	    // Endpoint to get a transaction by ID
	    @GetMapping("/{transactionId}")
	    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId) {
	        Transaction transaction = transactionService.getTransactionById(transactionId);
	        if (transaction != null) {
	            return new ResponseEntity<>(transaction, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Endpoint to create a new transaction
	    @PostMapping
	    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
	        Transaction createdTransaction = transactionService.createTransaction(transaction);
	        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
	    }

	    // Endpoint to update an existing transaction
	    @PutMapping("/{transactionId}")
	    public ResponseEntity<Transaction> updateTransaction(
	            @PathVariable Long transactionId,
	            @RequestBody Transaction updatedTransaction) {
	        Transaction transaction = transactionService.updateTransaction(transactionId, updatedTransaction);
	        if (transaction != null) {
	            return new ResponseEntity<>(transaction, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Endpoint to delete a transaction by ID
	    @DeleteMapping("/{transactionId}")
	    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
	        boolean deleted = transactionService.deleteTransaction(transactionId);
	        if (deleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}

