package com.example.bankapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.User;
import com.example.bankapp.service.AccountService;
import com.example.bankapp.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<Account> createAccount(@AuthenticationPrincipal User user) {
        Account account = accountService.createAccount(user);
        return ResponseEntity.ok(account);
    }
    
    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(accountService.getUserAccounts(user));
    }
}
