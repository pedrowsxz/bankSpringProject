package com.example.bankapp.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.User;
import com.example.bankapp.repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AccountService {
    
    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public Account createAccount(User user) {
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setUser(user);
        return accountRepository.save(account);
    }

    public List<Account> getUserAccounts(User user) {
        return accountRepository.findByUserId(user.getId());
    }
    
    private String generateAccountNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }
}
