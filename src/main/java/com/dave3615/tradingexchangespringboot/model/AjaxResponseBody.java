package com.dave3615.tradingexchangespringboot.model;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<BuyOrder> buyOrder;
    List<SellOrder> sellOrders;

    public AjaxResponseBody(String message, List<BuyOrder> buyOrder, List<SellOrder> sellOrders) {
        this.msg = message;
        this.buyOrder = buyOrder;
        this.sellOrders = sellOrders;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<BuyOrder> getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(List<BuyOrder> buyOrder) {
        this.buyOrder = buyOrder;
    }

    public List<SellOrder> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<SellOrder> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
