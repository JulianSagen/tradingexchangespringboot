package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import com.dave3615.tradingexchangespringboot.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TradeSellDAO extends CrudRepository<SellOrder, Long> {


    List<SellOrder> findAll();
    List<SellOrder> findByUser(User user);
    BuyOrder save(BuyOrder buyOrder);
}