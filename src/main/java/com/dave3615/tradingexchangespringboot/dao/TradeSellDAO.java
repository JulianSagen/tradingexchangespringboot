package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import com.dave3615.tradingexchangespringboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeSellDAO extends CrudRepository<SellOrder, Long> {


    List<SellOrder> findAll();
    List<SellOrder>  findAllByOrderByPriceAsc();
    List<SellOrder> findAllByUser(User user);
    BuyOrder save(BuyOrder buyOrder);
}