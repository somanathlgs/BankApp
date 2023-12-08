package com.example.bankapp.service;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.bankapp.entity.Transaction;
import com.example.bankapp.repository.TransactionalRepository;

import java.util.List;
	import java.util.Optional;

	@Service
	public class TransactionalServiceimpl  implements TransactionalService{
	    @Autowired
	    private TransactionalRepository transactionRepository;

	    @Override
	    public List<Transaction> getAllTransactions() {
	        return transactionRepository.findAll();
	    }

	    @Override
	    public Transaction getTransactionById(Long transactionId) {
	        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
	        return optionalTransaction.orElse(null);
	    }

	    @Override
	    public Transaction createTransaction(Transaction transaction) {
	        // You might want to add validation logic here before saving to the database
	        return transactionRepository.save(transaction);
	    }

	    @Override
	    public Transaction updateTransaction(Long transactionId, Transaction updatedTransaction) {
	        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
	        if (optionalTransaction.isPresent()) {
	            Transaction existingTransaction = optionalTransaction.get();
	            // Update the fields you want to allow updating
	            existingTransaction.setAmount(updatedTransaction.getAmount());
	            // Add more fields as needed
	            return transactionRepository.save(existingTransaction);
	        } else {
	            return null; // Transaction not found
	        }
	    }

	    @Override
	    public boolean deleteTransaction(Long transactionId) {
	        if (transactionRepository.existsById(transactionId)) {
	            transactionRepository.deleteById(transactionId);
	            return true;
	        } else {
	            return false; // Transaction not found
	        }
	    }
	}
