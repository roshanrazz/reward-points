package com.roshan.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(generator = TransactionIdGenerator.GENERATOR_NAME)
	@GenericGenerator(name = TransactionIdGenerator.GENERATOR_NAME, strategy = "com.roshan.entity.TransactionIdGenerator", parameters = {
	@Parameter(name = TransactionIdGenerator.PREFIX_PARAM, value = "T0") })
	@Column(name = "transaction_id")
	private String transactionId;
	@Column(name = "user_id")
	private String userId;
	private LocalDate date;
	private int amount;
	private int points;
	
	public Transaction() {
		super();
	}

	public Transaction(String transactionId, String userId, LocalDate date, int amount, int points) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.date = date;
		this.amount = amount;
		this.points = points;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", date=" + date + ", amount="
				+ amount + ", points=" + points + "]";
	}

	
}
