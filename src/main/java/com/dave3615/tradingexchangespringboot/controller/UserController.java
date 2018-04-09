package com.dave3615.tradingexchangespringboot.controller;

import com.dave3615.tradingexchangespringboot.model.User;
import com.dave3615.tradingexchangespringboot.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    LoginService loginService;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping("/registrer")
    public String BuildingForm(@ModelAttribute User user, Model model) {

        loginService.registrer(user);

        System.out.println("User registrered");
        return "redirect:/";
    }





}