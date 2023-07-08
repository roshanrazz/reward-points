package com.roshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.entity.Transaction;
import com.roshan.service.TransactionService;

@RestController
@RequestMapping("/api/v1/users")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/{userId}/transaction")
	public Transaction createTransaction(@RequestBody Transaction transaction, @PathVariable String userId) {
		return transactionService.createTransaction(transaction, userId);
	}
	
	@GetMapping("/{userId}/points")
	public String totalPoints(@PathVariable String userId) {
		return transactionService.totalPoints(userId);
	}
	
	@GetMapping("/{userId}/points/{month}")
	public String totalPoints(@PathVariable String userId,@PathVariable String month) {
		return transactionService.pointsByMonth(userId,month);
	}
}
