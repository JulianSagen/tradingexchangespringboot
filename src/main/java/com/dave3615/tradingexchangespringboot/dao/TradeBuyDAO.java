package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface TradeBuyDAO extends CrudRepository<BuyOrder, Long> {

    List<BuyOrder> findAll();
    List<BuyOrder> findAllByOrderByPriceDesc();
    List<BuyOrder> findAllByUser(User user);
    BuyOrder save(BuyOrder buyOrder);
}