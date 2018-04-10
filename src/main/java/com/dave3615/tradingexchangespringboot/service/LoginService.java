package com.dave3615.tradingexchangespringboot.service;

import com.dave3615.tradingexchangespringboot.dao.RoleDAO;
import com.dave3615.tradingexchangespringboot.dao.UserDAO;
import com.dave3615.tradingexchangespringboot.model.Role;
import com.dave3615.tradingexchangespringboot.model.User;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;


@Service
public class LoginService  {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;


    public void registrerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        assignStarterCurrency(user, 100,100);
        Role userRole = roleDAO.findByRole("USER");
        user.setActive(1);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userDAO.save(user);
    }

    private void assignStarterCurrency(User user, long addedBitcoins, long addedUsd){
        user.setBitcoins(user.getBitcoins() + addedBitcoins);
        user.setUsd(user.getUsd() + addedUsd);
    }

}
