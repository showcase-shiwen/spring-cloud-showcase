package org.showcase.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.showcase.user.entity.User;
import org.showcase.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public User get(Long userId){
        return userService.getByUserId(userId);
    }
}