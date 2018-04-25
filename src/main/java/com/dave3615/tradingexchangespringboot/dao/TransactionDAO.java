package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import com.dave3615.tradingexchangespringboot.model.Transaction;
import com.dave3615.tradingexchangespringboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Long> {

    List<Transaction> findAll();
    List<Transaction> findAllByOrderByTransactionTimeDesc();
    List<Transaction> findAllByUser(User user);

    Transaction save(Transaction transaction);
}