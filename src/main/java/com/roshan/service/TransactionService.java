package com.roshan.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan.entity.Transaction;
import com.roshan.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
//	private UserRepository userRepository;
	
	public Transaction createTransaction(Transaction transaction, String userId) {
		transaction.setUserId(userId);
		transaction.setDate(LocalDate.now());
		int amount = transaction.getAmount();
		int points = (amount >= 100) ? ((amount - 100)*2 + 50 ): (amount > 50) ? (amount-50) : 0;
		transaction.setPoints(points);
		return transactionRepository.saveAndFlush(transaction);
	}
	
	public String totalPoints(String userId){
		List<Transaction> transactions = transactionRepository.findByUserId(userId);
		int sumOfPoints = transactions.stream().mapToInt(transaction -> transaction.getPoints()).sum();
		return Integer.toString(sumOfPoints);
		
	}
	
	public String pointsByMonth(String userId, String month) {
		List<Transaction> transactions = transactionRepository.findByUserId(userId);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
		int sumOfPoints = transactions.stream().filter(transaction -> transaction.getDate().format(dateTimeFormatter).equals(month)).mapToInt(transaction -> transaction.getPoints()).sum();
		return Integer.toString(sumOfPoints);
	}

}
