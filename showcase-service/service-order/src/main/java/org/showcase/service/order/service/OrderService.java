package org.showcase.service.order.service;

import lombok.extern.slf4j.Slf4j;
import org.showcase.api.user.client.UserClient;
import org.showcase.api.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private UserClient userClient;

    public String orderSave(Long userId, Long amount) {
        String orderId= UUID.randomUUID().toString();
        log.info("handle order save business");
        UserVo userVo=userClient.getUserById(userId);
        log.info("orderId:{} userVo：{}",orderId,userVo);
        return orderId;
    }
}
