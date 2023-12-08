package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceimpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
    private AccountNumberGeneratorService accountNumberGeneratorService;

	
	
	@Override
	public Account createaccount(Account account) {
		
		String randomAccountNumber = accountNumberGeneratorService.generateRandomAccountNumber();

        Account newAccount = new Account();
        newAccount.setAcc_number(randomAccountNumber);

        // You might want to set other default values for the new account
        newAccount.setBalance(5000);
        newAccount.setAcc_status("Active");
       

        return accountRepository.save(newAccount);
		
		//		Account save = accountRepository.save(account);
		//return save;
	}

	@Override
	public List<Account> getallaccount() {
		List<Account> list = accountRepository.findAll();
		return list;
	}
	
	@Override
	public Account getaccount(Long acc_id) {
	      Account a = accountRepository.findById(acc_id).orElse(null);
		return a;
		
	}
	
	public Account updateaccount(Long acc_id, Account updatedAccount) {
        Optional<Account> optionalAccount = accountRepository.findById(acc_id);
        if (optionalAccount.isPresent()) {
            Account existingAccount = optionalAccount.get();
            // Update the fields you want to allow updating
            existingAccount.setBalance(updatedAccount.getBalance());
            // Add more fields as needed
            return accountRepository.save(existingAccount);
        } else {
            return null; // Account not found
        }
    }
	
	

	
/*	 @Override
	    public Account createRandomAccount() {
	        String randomAccountNumber = accountNumberGeneratorService.generateRandomAccountNumber();

	        Account newAccount = new Account();
	        newAccount.setAcc_number(randomAccountNumber);

	        // You might want to set other default values for the new account
	        newAccount.setBalance(0.0);

	        return accountRepository.save(newAccount);
	    }

	*/

	@Override
	public boolean creditAmount(Long acc_id, double amount) {
		 Optional<Account> optionalAccount = accountRepository.findById(acc_id);
	        if (optionalAccount.isPresent()) {
	            Account account = optionalAccount.get();
	            double currentBalance = account.getBalance();
	            account.setBalance(currentBalance + amount);
	            accountRepository.save(account);
	            return true;
	        } else {
	            return false; // Account not found
	        }
	}

	
	
	
	
	
	@Override
	public boolean debitAmount(Long acc_id, double amount) {
		Optional<Account> optionalAccount = accountRepository.findById(acc_id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            double currentBalance = account.getBalance();
            
            // Check if there is sufficient balance
            if (currentBalance >= amount) {
                account.setBalance(currentBalance - amount);
                accountRepository.save(account);
                return true;
            } else {
                return false; // Insufficient balance
            }
        } else {
            return false; // Account not found
        }
    }

	

	
	
}
