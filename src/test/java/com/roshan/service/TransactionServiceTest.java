package com.roshan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.roshan.entity.Transaction;
import com.roshan.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private TransactionService transactionService;
	
	@Test
	public void testCreateTransaction() {
		String userId = "U001";
		Transaction transaction = new Transaction();
		transaction.setUserId(userId);
		transaction.setAmount(120);
		transaction.setTransactionId("T005");
		when(transactionRepository.saveAndFlush(transaction)).thenReturn(transaction);
        assertEquals(transaction, transactionService.createTransaction(transaction, userId));
	}

	@Test
	public void testTotalPoints() {
		String userId = "U004";
		Transaction transaction = new Transaction();
		transaction.setUserId(userId);
		transaction.setAmount(120);
		transaction.setTransactionId("T006");
		transaction.setDate(LocalDate.now());
		transaction.setPoints(90);
		
		
		Transaction transaction2 = new Transaction();
		transaction2.setUserId(userId);
		transaction2.setAmount(100);
		transaction2.setTransactionId("T007");
		transaction2.setDate(LocalDate.now());
		transaction2.setPoints(50);
		
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);
		transactions.add(transaction2);
		
		when(transactionRepository.findByUserId(userId)).thenReturn(transactions);
		assertEquals("140", transactionService.totalPoints(userId));
		
		
	}
	
	
	@Test
	public void testPointsByMonth() {
		String userId = "U005";
		Transaction transaction = new Transaction();
		transaction.setUserId(userId);
		transaction.setAmount(130);
		transaction.setTransactionId("T008");
		transaction.setDate(LocalDate.now());
		transaction.setPoints(110);
		
		
		Transaction transaction2 = new Transaction();
		transaction2.setUserId(userId);
		transaction2.setAmount(100);
		transaction2.setTransactionId("T009");
		transaction2.setDate(LocalDate.of(2023, 05, 25));
		transaction2.setPoints(50);
		
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);
		transactions.add(transaction2);
		
		when(transactionRepository.findByUserId(userId)).thenReturn(transactions);
		assertEquals("110", transactionService.pointsByMonth(userId,"2023-07"));
		
		
	}

}
