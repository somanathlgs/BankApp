package com.example.bankapp.Controller;


 

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import com.example.bankapp.entity.Account;
import com.example.bankapp.service.AccountService;

import java.util.List;

	@RestController
	@RequestMapping("/api/accounts")
	public class AccountController {

	    @Autowired
	    private AccountService accountService;

	    // Endpoint to get all accounts
	    @GetMapping
	    public ResponseEntity<List<Account>> getAllAccounts() {
	        List<Account> accounts = accountService.getAllAccounts();
	        return new ResponseEntity<>(accounts, HttpStatus.OK);
	    }

	    // Endpoint to get an account by ID
	    @GetMapping("/{accountId}")
	    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
	        Account account = accountService.getAccountById(accountId);
	        if (account != null) {
	            return new ResponseEntity<>(account, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Endpoint to create a new account
	    @PostMapping
	    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
	        Account createdAccount = accountService.createAccount(account);
	        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	    }

	    // Endpoint to update an existing account
	    @PutMapping("/{accountId}")
	    public ResponseEntity<Account> updateAccount(
	            @PathVariable Long accountId,
	            @RequestBody Account updatedAccount) {
	        Account account = accountService.updateAccount(accountId, updatedAccount);
	        if (account != null) {
	            return new ResponseEntity<>(account, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Endpoint to delete an account by ID
	    @DeleteMapping("/{accountId}")
	    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
	        boolean deleted = accountService.deleteAccount(accountId);
	        if (deleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}






