package com.example.bankapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankapp.dto.TransferRequest;
import com.example.bankapp.model.Transaction;
import com.example.bankapp.model.User;
import com.example.bankapp.repository.TransactionRepository;
import com.example.bankapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    
    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionService transactionService, TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/transfer")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> transferFunds(@RequestBody TransferRequest transferRequest) {
        transactionService.transferFunds(
                transferRequest.getFromAccount(),
                transferRequest.getToAccount(),
                transferRequest.getAmount()
        );
        return ResponseEntity.ok("Amount transferred");
    }
    
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Transaction>> getTransactions(
            @AuthenticationPrincipal User user,
            @RequestParam String accountNumber) {
        List<Transaction> transactions = transactionRepository.findBySourceAccountNumber(accountNumber);
        return ResponseEntity.ok(transactions);
    }
    
//    //Further implementation 
//    @GetMapping
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam(required = false) LocalDateTime start, @RequestParam(required = false) LocalDateTime end) {
//        if (start != null && end != null) {
//            return ResponseEntity.ok(transactionService.getTransactionsBetweenDates(start, end));
//        }
//        return ResponseEntity.ok(transactionService.getAllTransactions());
//    }
}
