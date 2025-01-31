package com.example.bankapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.User;

public interface AccountRepository extends JpaRepository<Account, Long> {
	List<Account> findByUser(User user);
        List<Account> findByUserId(Long id);
	Optional<Account> findByAccountNumber(String accountNumber);
}
