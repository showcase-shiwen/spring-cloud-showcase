package org.showcase.service.order.rest;

import lombok.extern.slf4j.Slf4j;
import org.showcase.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("order")
public class OrderRest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String applicationName;


    @PostMapping("save")
    public String orderSave(Long userId,Long amount,HttpServletResponse response){
        log.info("order down");
        String orderId=orderService.orderSave(userId,amount);
        return orderId;
    }
    @GetMapping("services")
    public Object getServices(){
        return discoveryClient.getServices();
    }
    @GetMapping("instance")
    public Object getInstance(){
        log.debug("service :{} instance",applicationName);
        return discoveryClient.getInstances(applicationName);
    }
}
