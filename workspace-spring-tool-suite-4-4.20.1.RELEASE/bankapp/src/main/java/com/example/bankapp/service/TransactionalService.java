package com.example.bankapp.service;



	
	import java.util.List;

	import com.example.bankapp.entity.Transaction;

	public interface TransactionalService {

	    List<Transaction> getAllTransactions();

	    Transaction getTransactionById(Long transactionId);

	    Transaction createTransaction(Transaction transaction);

	    Transaction updateTransaction(Long transactionId, Transaction updatedTransaction);

	    boolean deleteTransaction(Long transactionId);
	}

