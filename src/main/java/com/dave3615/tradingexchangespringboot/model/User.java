package com.dave3615.tradingexchangespringboot.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    private long bitcoins;
    private long usd;

    private int active;


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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


}
