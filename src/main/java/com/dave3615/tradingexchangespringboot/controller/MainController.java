package com.dave3615.tradingexchangespringboot.controller;

import com.dave3615.tradingexchangespringboot.model.User;
import com.dave3615.tradingexchangespringboot.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

        @Autowired
        LoginService loginService;

        @GetMapping("/")
        public String home(Model model) {
            System.out.println("Loading form");
            return "index";
        }

        @GetMapping("/login")
        public String login(Model model) {
            System.out.println("Loading form");
            return "login";
        }

    @GetMapping("/registrer")
    public String BuildingForm(Model model) {

        model.addAttribute("user", new User());

        System.out.println("Loading form");
        return "registrer";
    }






}
