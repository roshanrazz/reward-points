package com.roshan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

	List<Transaction> findByUserId(String userId);


}
