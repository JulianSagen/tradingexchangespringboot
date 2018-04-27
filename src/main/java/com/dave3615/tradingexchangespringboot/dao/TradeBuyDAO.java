package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TradeBuyDAO extends CrudRepository<BuyOrder, Long> {

    List<BuyOrder> findAll();
    List<BuyOrder> findAllByOrderByPriceAsc();
    List<BuyOrder> findAllByOrderByPriceDesc();
    List<BuyOrder> findAllByUser(User user);
    BuyOrder save(BuyOrder buyOrder);
    void deleteById(long id);
    BuyOrder findById(long id);
}