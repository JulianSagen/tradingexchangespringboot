package com.dave3615.tradingexchangespringboot.controller;

import com.dave3615.tradingexchangespringboot.dao.UserDAO;
import com.dave3615.tradingexchangespringboot.model.AjaxResponseBody;
import com.dave3615.tradingexchangespringboot.model.BuyOrder;
import com.dave3615.tradingexchangespringboot.model.SellOrder;
import com.dave3615.tradingexchangespringboot.model.User;
import com.dave3615.tradingexchangespringboot.service.LoginService;
import com.dave3615.tradingexchangespringboot.service.TradeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.awt.AWTIcon32_security_icon_yellow16_png;

import javax.xml.ws.Response;
import java.net.URI;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @Autowired
    UserDAO userDAO;

    private static final Logger logger = LogManager.getLogger(TradeController.class);

    @PostMapping("/place/buyorder")
    public String createBuyOrder(@ModelAttribute BuyOrder buyOrder, Model model) {
        tradeService.placeBuyOrder(buyOrder);
        System.out.println("Buy Order placed");

        return "redirect:/order";
    }

    @PostMapping("/place/sellorder")
    public String createSellOrder(@ModelAttribute SellOrder sellOrder, Model model) {
        tradeService.placeSellOrder(sellOrder);
        System.out.println("Sell Order placed");

        return "redirect:/order";
    }

    @GetMapping("/get/buysellorders")
    public ResponseEntity<AjaxResponseBody> getBuyOrder() {
        AjaxResponseBody result = new AjaxResponseBody("Body created", tradeService.getBuyOrders(), tradeService.getSellOrders());
        System.out.println(result.toString());
        return ResponseEntity.ok(result);
    }
}