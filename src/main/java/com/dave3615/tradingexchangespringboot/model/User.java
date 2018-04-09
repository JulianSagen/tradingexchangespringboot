package com.dave3615.tradingexchangespringboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    private long bitcoins;
    private long usd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBitcoins(long bitcoins){
        this.bitcoins = bitcoins;
    }

    public long getBitcoins(){
        return bitcoins;
    }
    public void setUsd(long usd){
        this.usd = usd;
    }

    public long getUsd(){
        return usd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
