package com.dave3615.tradingexchangespringboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long price;
    private Long amount;
    private String buyOrSell;
    private Date transactionTime;

    @ManyToOne
    private User user;

    public Transaction(){

    }

    public Transaction(Long price, Long amount, String buyOrSell, Date transactionTime, User user) {
        this.price = price;
        this.amount = amount;
        this.buyOrSell = buyOrSell;
        this.transactionTime = transactionTime;
        this.user = user;
    }

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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}