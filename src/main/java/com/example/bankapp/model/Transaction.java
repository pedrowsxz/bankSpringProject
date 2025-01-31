package com.example.bankapp.model;

import com.example.bankapp.enums.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private TransactionType type;

	private LocalDateTime timestamp;

	@ManyToOne
	@JoinColumn(name = "source_account_id")
	private Account sourceAccount;

	@ManyToOne
	@JoinColumn(name = "target_account_id")
	private Account targetAccount;

	private String description;

	public Transaction() {
	}

	public Transaction(Long id, BigDecimal amount, TransactionType type, LocalDateTime timestamp, Account sourceAccount,
			Account targetAccount, String description) {
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.timestamp = timestamp;
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}