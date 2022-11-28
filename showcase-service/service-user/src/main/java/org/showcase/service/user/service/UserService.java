package org.showcase.service.user.service;

import lombok.extern.slf4j.Slf4j;
import org.showcase.service.user.entity.User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    public User getByUserId(Long userId) {
        User user=User.builder().userName("zhangsan").id(1L).build();
        log.info("get {} user info:{}",userId,user);
        return user;
    }
}
