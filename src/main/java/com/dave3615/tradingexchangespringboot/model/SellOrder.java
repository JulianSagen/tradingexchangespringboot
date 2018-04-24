package com.dave3615.tradingexchangespringboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SellOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long price;
    private Long amountLeft;
    private Long totalAmount;
    private Date Time;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(Long amountLeft) {
        this.amountLeft = amountLeft;
    }

    public Long getTotalAmount() { return totalAmount; }

    public void setTotalAmount(Long totalAmount) { this.totalAmount = totalAmount; }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
