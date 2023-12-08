package com.example.bankapp.service;

     	import java.util.List;

        import com.example.bankapp.entity.Account;

        
        
		public interface AccountService {

		    List<Account> getAllAccounts();

		    Account getAccountById(Long accountId);

		    Account createAccount(Account account);

		    Account updateAccount(Long accountId, Account updatedAccount);

		    boolean deleteAccount(Long accountId);
}
