package org.showcase.service.order.rest;

import lombok.extern.slf4j.Slf4j;
import org.showcase.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("order")
public class OrderRest {

    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    public String orderSave(Long userId,Long amount){
        log.info("order down");
        String orderId=orderService.orderSave(userId,amount);
        return orderId;
    }
}
