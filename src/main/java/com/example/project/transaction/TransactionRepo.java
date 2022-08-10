package com.example.project.transaction;

import com.example.project.trader.Trader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    List<Transaction> findAll();
    List<Transaction> findTransactionsByDateEquals(String date);
    List<Transaction> findTransactionsByTrader(Trader t);
}
