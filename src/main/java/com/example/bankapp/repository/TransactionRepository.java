package com.example.bankapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySourceAccountNumberOrTargetAccountNumber(String source, String target);
    List<Transaction> findByTargetAccountNumber(String target);
    List<Transaction> findBySourceAccountNumber(String source);
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}

