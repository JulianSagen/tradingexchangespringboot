package com.dave3615.tradingexchangespringboot.service;

import com.dave3615.tradingexchangespringboot.dao.UserDAO;
import com.dave3615.tradingexchangespringboot.model.User;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class LoginService  {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;


    public void registrer(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        assignStarterCurrency(user, 100,100);
        userDAO.save(user);
    }

    private void assignStarterCurrency(User user, long addedBitcoins, long addedUsd){
        user.setBitcoins(user.getBitcoins() + addedBitcoins);
        user.setUsd(user.getUsd() + addedUsd);
    }

}
