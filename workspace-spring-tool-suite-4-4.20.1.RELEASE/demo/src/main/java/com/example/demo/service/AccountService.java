package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Account;

public interface AccountService {

	Account createaccount(Account account);

	List<Account> getallaccount();

	Account getaccount(Long acc_id);

	 Account updateaccount(Long acc_id,Account updatedAccount);
	 
    
	boolean creditAmount(Long acco_id, double amount);

	

	boolean debitAmount(Long acc_id, double amount);

	

}
