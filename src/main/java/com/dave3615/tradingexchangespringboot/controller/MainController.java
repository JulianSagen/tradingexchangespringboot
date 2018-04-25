package com.dave3615.tradingexchangespringboot.controller;

import com.dave3615.tradingexchangespringboot.dao.UserDAO;
import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import com.dave3615.tradingexchangespringboot.model.User;
import com.dave3615.tradingexchangespringboot.service.LoginService;
import com.dave3615.tradingexchangespringboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

        @Autowired
        LoginService loginService;
        @Autowired
        TradeService tradeService;

        @Autowired
        UserDAO userDAO;

        @GetMapping("/")
        public String home(Model model) {
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                User user = userDAO.findByUsername(((UserDetails) principal).getUsername());
                model.addAttribute("user", user);
            }

            model.addAttribute("buyorders", tradeService.getBuyOrders());
            model.addAttribute("sellorders", tradeService.getSellOrders());
            model.addAttribute("transactions", tradeService.getTransactions());

            return "index";
        }

        @GetMapping("/login")
        public String login(Model model) {
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                User user = userDAO.findByUsername(((UserDetails) principal).getUsername());
                model.addAttribute("user", user);
            }
            System.out.println("Loading form");
            return "login";
        }

    @GetMapping("/registrer")
    public String registrer(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDAO.findByUsername(((UserDetails) principal).getUsername());
            model.addAttribute("user", user);
        }

        model.addAttribute("user", new User());

        System.out.println("Loading form");
        return "registrer";
    }

    @GetMapping("/userpage")
    @PreAuthorize("hasRole(@roles.USER)")
    public String userpage(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDAO.findByUsername(((UserDetails)principal).getUsername());


        model.addAttribute("user", user);

        System.out.println("Loading form");
        return "accountadministration";
    }

    @GetMapping("/order")
    public String order(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDAO.findByUsername(((UserDetails)principal).getUsername());

        model.addAttribute("buyorder", new BuyOrder());
        model.addAttribute("sellorder", new SellOrder());

        model.addAttribute("user", user);

        model.addAttribute("buyordersfromuser", tradeService.buyOrdersFromUser(user));
        model.addAttribute("sellordersfromuser", tradeService.sellOrdersFromUser(user));

        model.addAttribute("transactionsfromuser", tradeService.getTransactionsFromUser(user));


        System.out.println("Loading form");
        return "placeorder";
    }




}
