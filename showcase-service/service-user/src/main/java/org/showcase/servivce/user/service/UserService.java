package org.showcase.servivce.user.service;

import lombok.extern.slf4j.Slf4j;
import org.showcase.servivce.user.entity.User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    public User getByUserId(Long userId) {
        User user=new User(1L,"zhangsan");
        log.info("get {} user info:{}",userId,user);
        return user;
    }
}
