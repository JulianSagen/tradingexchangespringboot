package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import com.dave3615.tradingexchangespringboot.model.Transaction;
import com.dave3615.tradingexchangespringboot.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDAO extends CrudRepository<Transaction, Long> {



    Transaction save(Transaction transaction);
}