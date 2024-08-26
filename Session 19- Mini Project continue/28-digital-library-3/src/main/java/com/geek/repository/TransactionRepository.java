package com.geek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.geek.entity.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

	@Query(value = "select * from Transaction  where user_id= :u",nativeQuery = true)
	List<Transaction> searchTransactionByUser(@Param("u") int userId);
}
