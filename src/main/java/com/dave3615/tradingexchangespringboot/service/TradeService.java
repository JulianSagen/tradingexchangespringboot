package com.dave3615.tradingexchangespringboot.service;

import com.dave3615.tradingexchangespringboot.dao.TradeBuyDAO;
import com.dave3615.tradingexchangespringboot.dao.TradeSellDAO;
import com.dave3615.tradingexchangespringboot.dao.UserDAO;
import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class TradeService {

    @Autowired
    private TradeBuyDAO tradeBuyDAO;

    @Autowired
    private TradeSellDAO tradeSellDAO;

    @Autowired
    private UserDAO userDAO;

    public void placeBuyOrder(BuyOrder buyOrder) {
        tradeBuyDAO.save(buyOrder);
    }
    public void placeSellOrder(SellOrder sellOrder) {
        tradeSellDAO.save(sellOrder);
    }

    public List<BuyOrder> getBuyOrders(){
        return tradeBuyDAO.findAll();
    }
    public List<SellOrder> getSellOrders(){
        return tradeSellDAO.findAll();
    }



}
